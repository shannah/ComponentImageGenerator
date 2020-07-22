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
public class BasicButton extends BaseTest {

    @Override
    protected Component createSubjectComponent() {
        return new Button("Button");
    }

    @Override
    public String getId() {
        return "Button";
    }

    @Override
    public Category getCategory() {
        return Category.Button;
    }

    @Override
    public Links getLinks() {
        return createDemoLinks();
    }

    @Override
    public String getDescription() {
        return "Simple Button";
    }
    
    
    
    
    
    
    
    
}
