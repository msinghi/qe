package com.qe.sample;

import com.qe.core.JobConfig;

public class DefaultJobConfig implements JobConfig {

    @Override
    public double getTransactionsPerSecond() {
        return .5;
    }

}
