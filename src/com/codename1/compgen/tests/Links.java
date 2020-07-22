/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.compgen.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author shannah
 */
public class Links implements Iterable<Link> {
    private List<Link> links = new ArrayList<Link>();
    
    public Links(Link... links) {
        this.links.addAll(Arrays.asList(links));
    }

    @Override
    public Iterator<Link> iterator() {
        return links.iterator();
    }
    
    
}
