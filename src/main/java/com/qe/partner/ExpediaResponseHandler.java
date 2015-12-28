package com.qe.partner;

import java.io.IOException;
import java.util.Arrays;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

import com.qe.model.TestModel;

public class ExpediaResponseHandler implements ResponseHandler<TestModel> {

    
    @Override
    public TestModel handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
        
        if (response.getStatusLine().getStatusCode() == 200) {
             return new TestModel("someid", Arrays.asList("url1", "url2"), "expedia");
        } else {
            throw new IOException();
        }
    }

}
