package com.qe.partner;

import java.util.Iterator;

import org.apache.http.message.BasicHttpRequest;

import com.qe.core.interfaces.HttpQuery;

public class ExpediaQueryIterator implements Iterator<HttpQuery> {

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public HttpQuery next() {
        return new HttpQuery(new BasicHttpRequest("GET", "http://www.google.com"));
    }
    
    

}
