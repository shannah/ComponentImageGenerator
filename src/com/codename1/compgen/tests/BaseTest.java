/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.compgen.tests;

import com.codename1.compgen.MainTestRunner.Test;
import com.codename1.compgen.tests.Link.Type;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.FlowLayout;

/**
 *
 * @author shannah
 */
public abstract class BaseTest implements Test {
    
    Form form;
    Component subjectComponent;
    
    BaseTest() {
        form = createForm();
        subjectComponent = createSubjectComponent();
        addSubjectComponentToForm();
    }
    
    protected void addSubjectComponentToForm() {
        form.add(subjectComponent);
    }
    
    protected Form createForm() {
        return new Form("Test", new FlowLayout());
    }
    
    protected abstract Component createSubjectComponent();
    
    @Override
    public Component getSubjectComponent() {
        return subjectComponent;
    }

    @Override
    public abstract String getId();
    
    public static Links createDemoLinks() {
        return new Links(
                new Link("http://example.com/css", Type.CSS),
                new Link("http://example.com/javadoc/foobar", Type.JavaDocs),
                new Link("http://example.com/java", Type.Java),
                new Link("http://example.com/kotlin", Type.Kotlin)
        );
    }
    
}
