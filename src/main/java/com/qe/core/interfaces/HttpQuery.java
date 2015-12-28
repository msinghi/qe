package com.qe.core.interfaces;

import org.apache.http.HttpRequest;

public class HttpQuery extends Query {

    HttpRequest httpRequest;
    
    public HttpQuery(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }
    
    public HttpRequest getHttpRequest() {
        return httpRequest;
    }
}

