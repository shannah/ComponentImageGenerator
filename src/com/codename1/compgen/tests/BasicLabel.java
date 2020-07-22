/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.compgen.tests;

import com.codename1.compgen.MainTestRunner.Test;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

/**
 *
 * @author shannah
 */
public class BasicLabel extends BaseTest {

    @Override
    protected Component createSubjectComponent() {
        return new Label("Label");
    }

    @Override
    public String getId() {
        return "Label";
    }

    @Override
    public Category getCategory() {
        return Category.Label;
    }

    @Override
    public String getDescription() {
        return "Simple Label";
    }

    @Override
    public Links getLinks() {
        return createDemoLinks();
    }
    
    
    
    
    
    
    
    
}
