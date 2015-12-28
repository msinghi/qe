package com.qe;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.Map;

import javax.ws.rs.Path;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codahale.metrics.MetricRegistry;

public class QueryEngineApplication extends Application<QueryEngineConfiguration> {
    
    public static void main(String[] args) throws Exception {
        new QueryEngineApplication().run(args);
    }

    @Override
    public String getName() {
        return "QueryEngine";
    }

    @Override
    public void initialize(Bootstrap<QueryEngineConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(QueryEngineConfiguration configuration, Environment environment) {

        // add isActiveResource and buildInfoResource
        final MetricRegistry registry = environment.metrics();
        final MetricsReporter reporter = new MetricsReporter(registry);
        environment.lifecycle().manage(reporter);
        
        final AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        parentContext.refresh();
        
        
        parentContext.getBeanFactory().registerSingleton("metricRegistry", registry);
        
        parentContext.registerShutdownHook();
        parentContext.start();
        
        final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] { ("/application-context.xml")}, parentContext);
        
        final Map<String, Object> resources = applicationContext.getBeansWithAnnotation(Path.class);
        
        for (final Map.Entry<String, Object> entry : resources.entrySet()) {
            environment.jersey().register(entry.getValue());
        }
        
    }

}
