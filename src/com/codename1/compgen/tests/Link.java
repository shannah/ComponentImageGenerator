/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.compgen.tests;

/**
 *
 * @author shannah
 */
public class Link {

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }
    private String url;
    private Type type;
    
    
    public static enum Type {
        JavaDocs,
        CSS,
        Java,
        Kotlin
    }
    
    public Link(String url, Type type) {
        this.url = url;
        this.type = type;
    }

    
}
