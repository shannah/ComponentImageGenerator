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
public class ComponentSample {
    private String id;
    private String componentClass;
    private String sampleName;
    private String sampleDescription;
    private String codeSample;
    private Context context;
    
    
    
    public class Snapshot {
        private String theme;
        private String platform;
        
        private File getThemeDirectory() {
            return new File(getBaseDirectory(), theme);
        }

        private File getPlatformDirectory() {
            return new File(getThemeDirectory(), platform);
        }
        
        public File getImageFile() {
            return new File(getPlatformDirectory(), id+".png");
        }
        
        
    }
    
    public File getBaseDirectory() {
        return new File(context.getBaseDir(), id);
    }
    
    
    
    public File getCodeSampleFile() {
        return new File(getBaseDirectory(), "Sample.java");
    }
    
    
    
    
    
    
}
