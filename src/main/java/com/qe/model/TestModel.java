package com.qe.model;

import java.util.List;

public class TestModel {

    private String id;
    private List<String> links;
    private String partner;
    
    public TestModel(String id, List<String> links, String partner) {
        super();
        this.id = id;
        this.links = links;
        this.partner = partner;
    }
    
    public String getId() {
        return id;
    }

    public List<String> getLinks() {
        return links;
    }

    public String getPartner() {
        return partner;
    }
    
}
