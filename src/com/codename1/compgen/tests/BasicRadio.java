/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.compgen.tests;

import com.codename1.compgen.MainTestRunner.Test;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

/**
 *
 * @author shannah
 */
public class BasicRadio extends BaseTest {

    @Override
    protected Component createSubjectComponent() {
        RadioButton selected = new RadioButton("Selected");
        selected.setSelected(true);
        RadioButton unselected = new RadioButton("Unselected");
        return BoxLayout.encloseY(selected, unselected);
    }

    @Override
    public String getId() {
        return "RadioButton";
    }

    @Override
    public Category getCategory() {
        return Category.RadioButton;
    }

    @Override
    public String getDescription() {
        return "Simple Radio Button";
    }

    @Override
    public Links getLinks() {
        return createDemoLinks();
    }
    
    
    
    
    
    
    
    
}
