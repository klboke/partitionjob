package com.kailing.bootbatch.partitionjob.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Created by kl on 2018/3/14.
 * Content :job执行监听器
 */
public class JobListener implements JobExecutionListener {

    Logger logger= LoggerFactory.getLogger(getClass());

    @Override
    public void beforeJob(JobExecution jobExecution) {
           logger.error("Job准备执行,JobName:{}",jobExecution.getJobInstance().getJobName());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        logger.error("EndOfDayJob执行完毕,执行结果:{}",jobExecution.getExitStatus());
    }
}
