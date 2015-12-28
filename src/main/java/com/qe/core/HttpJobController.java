package com.qe.core;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

import org.apache.http.client.ClientProtocolException;

import com.google.common.util.concurrent.RateLimiter;
import com.qe.core.interfaces.HttpQuery;

public class HttpJobController<T> {

    private JobConfig jobConfig;
    private HttpQueryProcessor<T> httpQueryProcessor;
    private ExecutorService executorService;
    private Iterator<HttpQuery> queryIterator;

    
    public HttpJobController(JobConfig jobConfig, Iterator<HttpQuery> queryIterator,
            HttpQueryProcessor<T> httpQueryProcessor, ExecutorService executorService) {

        this.jobConfig = jobConfig;
        this.httpQueryProcessor = httpQueryProcessor;
        this.executorService = executorService;
        this.queryIterator = queryIterator;
    }

    public void submit() throws ClientProtocolException, IOException {

        double tps = jobConfig.getTransactionsPerSecond();

        RateLimiter rateLimiter = RateLimiter.create(tps); // 2 per second

        while (queryIterator.hasNext()) {

            rateLimiter.acquire();
            System.out.println(System.currentTimeMillis());
            HttpQuery query = queryIterator.next();
            httpQueryProcessor.submit(query);

        }
    }
}
