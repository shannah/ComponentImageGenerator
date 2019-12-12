/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.compgen;

import com.codename1.io.File;

/**
 *
 * @author shannah
 */
public class Context {

    /**
     * @return the baseDir
     */
    public File getBaseDir() {
        return baseDir;
    }

    /**
     * @param baseDir the baseDir to set
     */
    public void setBaseDir(File baseDir) {
        this.baseDir = baseDir;
    }
    
    
    private File baseDir;
    
    
    
}
