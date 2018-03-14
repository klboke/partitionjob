package com.kailing.bootbatch.partitionjob.Item;

import com.kailing.bootbatch.partitionjob.entity.Article;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by kl on 2018/3/14.
 * Content :数据输出item
 */
public class PrintWriterItem<T> implements ItemWriter<T> {
    @Override
    public void write(List<? extends T> list) throws Exception {
        list.stream().forEach(a->{
            Article article=(Article)a;
            System.err.println(article.getTitle());
        });

    }
}
