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
public enum Category {
    Label,
    Button,
    Fab,
    CheckBox,
    ToggleButton,
    RadioButton,
    ComboBox,
    Calendar,
    Signature,
    Tree,
    Picker,
    List,
    Switch,
    TextField,
    TextArea,
    Tabs,
    ProgressBar,
    
    WebView,
    
    Dialog,
    InteractionDialog,
    Sheet,
    ToastBar,
    ToolBar,
    
    ;
    
    
    
    private String id, label;
    
    Category(String id, String label) {
        this.id = id;
        this.label = label;
    }

    Category(String id) {
        this(id,id);
    }
    
    Category() {
        this.id = this.name();
        this.label = this.name();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }
    
    
}
