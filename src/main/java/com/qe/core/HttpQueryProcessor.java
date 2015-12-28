package com.qe.core;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;

import com.qe.core.interfaces.HttpQuery;
import com.qe.core.interfaces.ResponseDispatcher;

/*
 * T is the type of response that responseHandler generates
 */
public class HttpQueryProcessor<T> {

    private HttpClient httpClient;
    private String partner;
    private ResponseHandler<T> responseHandler;
    private HttpHost httpHost;
    private ResponseDispatcher<T> responseDispatcher;
    
    public HttpQueryProcessor(HttpClient httpClient, String partner, ResponseHandler<T> responseHandler, 
            ResponseDispatcher<T> responseDispatcher, String url) {
        
        this.httpClient = httpClient;
        this.partner = partner;
        this.responseHandler = responseHandler;
        this.httpHost = HttpHost.create(url);
        this.responseDispatcher = responseDispatcher;
        
    }
    
    public void submit(HttpQuery query) throws ClientProtocolException, IOException {
        
        T response = httpClient.execute(httpHost, query.getHttpRequest(), responseHandler);
        responseDispatcher.dispatch(response);
    }
}
