package com.kailing.bootbatch.partitionjob.config;

import com.kailing.bootbatch.partitionjob.Item.MyProcessorItem;
import com.kailing.bootbatch.partitionjob.Item.PrintWriterItem;
import com.kailing.bootbatch.partitionjob.entity.Article;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.integration.partition.BeanFactoryStepLocator;
import org.springframework.batch.integration.partition.StepExecutionRequestHandler;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.ServiceActivator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kl on 2018/3/1.
 * Content :Slave从节点，真实业务处理
 */
@Configuration
public class SlaveConfiguration {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    public JobExplorer jobExplorer;

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    @Profile({"slave","mixed"})
    @ServiceActivator(inputChannel = "inboundRequests", outputChannel = "outboundStaging")
    public StepExecutionRequestHandler stepExecutionRequestHandler() {
        StepExecutionRequestHandler stepExecutionRequestHandler = new StepExecutionRequestHandler();
        BeanFactoryStepLocator stepLocator = new BeanFactoryStepLocator();
        stepLocator.setBeanFactory(this.applicationContext);
        stepExecutionRequestHandler.setStepLocator(stepLocator);
        stepExecutionRequestHandler.setJobExplorer(this.jobExplorer);
        return stepExecutionRequestHandler;
    }



    @Bean("slaveStep")
    public Step slaveStep(MyProcessorItem processorItem,
                          JpaPagingItemReader reader) {
        CompositeItemProcessor itemProcessor = new CompositeItemProcessor();
        List<ItemProcessor> processorList = new ArrayList<>();
        processorList.add(processorItem);
        itemProcessor.setDelegates(processorList);
        return stepBuilderFactory.get("slaveStep")
                .<Article, Article>chunk(1000)//事务提交批次
                .reader(reader)
                .processor(itemProcessor)
                .writer(new PrintWriterItem())
                .build();
    }


}
