package com.kailing.bootbatch.partitionjob.Item;
import com.kailing.bootbatch.partitionjob.entity.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

/**
 * Created by kl on 2018/3/14.
 * Content :数据处理Item
 */
@Service
public class MyProcessorItem implements ItemProcessor<Article,Article> {

    Logger logger = LoggerFactory.getLogger(MyProcessorItem.class);

    @Override
    public Article process(Article article)throws Exception{
       logger.info("【{}】经过处理器",article.getTitle());
        return article;
    }
}
