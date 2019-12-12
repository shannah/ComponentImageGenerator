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
import com.codename1.ui.layouts.FlowLayout;

/**
 *
 * @author shannah
 */
public class BasicCheckBox extends BaseTest {

    @Override
    protected Component createSubjectComponent() {
        CheckBox checked = new CheckBox("Checked");
        checked.setSelected(true);
        return FlowLayout.encloseIn(new CheckBox("Unchecked"), checked);
    }

    @Override
    public String getId() {
        return "CheckBox";
    }
    
    
}
