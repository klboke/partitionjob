package com.kailing.bootbatch.partitionjob.support;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;
import java.util.Date;

public class BatchIncrementer implements JobParametersIncrementer {

    @Override
    public JobParameters getNext(JobParameters parameters){
        return new JobParametersBuilder()
                .addLong("batchDate",new Date().getTime())
                .toJobParameters();
    }
}
