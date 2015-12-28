package com.qe;

import io.dropwizard.lifecycle.Managed;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;

public class MetricsReporter implements Managed {

    private final JmxReporter jmxReporter;
    
    public MetricsReporter(MetricRegistry registry) {
        
        jmxReporter = JmxReporter.forRegistry(registry).build();
    }

    @Override
    public void start() throws Exception {
        jmxReporter.start();
    }

    @Override
    public void stop() throws Exception {
        jmxReporter.stop();
    }
}
