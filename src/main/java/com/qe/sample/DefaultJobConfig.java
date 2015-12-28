package com.qe.sample;

import com.qe.core.JobConfig;

public class DefaultJobConfig implements JobConfig {

    @Override
    public int getTransactionsPerSecond() {
        return 1;
    }

}
