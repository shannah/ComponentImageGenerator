/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.compgen;



import com.codename1.util.StringUtil;
import java.util.LinkedList;

/**
 *
 * @author shannah
 */
public class HTMLBuilder {
    StringBuilder sb = new StringBuilder();
    private LinkedList<String> tagStack = new LinkedList<>();
    private static final int DEFAULT=0;
    private static final int STATE_IN_OPEN_TAG=1;
    
    
    private int state;
    public HTMLBuilder open(String tag) {
        newLine();
        tagStack.push(tag);
        sb.append("<").append(tag);
        state = STATE_IN_OPEN_TAG;
        return this;
    }
    
    public HTMLBuilder newLine() {
        closeOpenTag();
        int indent = tagStack.size() * 2;
        sb.append("\n");
        for (int i=0; i<indent; i++) {
            sb.append(" ");
        }
        return this;
    }
    
    public HTMLBuilder attr(String key, String value) {
        if (state != STATE_IN_OPEN_TAG) {
            throw new IllegalStateException("attr can only called before appending content to a tag");
        }
        sb.append(" ").append(key).append("=\"").append(encodeString(value)).append("\"");
        return this;
    }
    
    public HTMLBuilder appendRaw(String str) {
        closeOpenTag();
        sb.append(str);
        return this;
    }
    
    public HTMLBuilder append(String string) {
        closeOpenTag();
        sb.append(encodeString(string));
        return this;
    }
    
    private void closeOpenTag() {
        if (state == STATE_IN_OPEN_TAG) {
            sb.append(">");
            state= DEFAULT;
            newLine();
        }
    }
    
    public HTMLBuilder close() {
        closeOpenTag();
        sb.append("</").append(tagStack.pop()).append(">");
        newLine();
        return this;
    }
    
    public String toString() {
        return sb.toString();
    }
    
    private String encodeString(String str) {
        str = StringUtil.replaceAll(str, "&", "&amp;");
        str = StringUtil.replaceAll(str, "<", "&lt;");
        str = StringUtil.replaceAll(str, ">", "&gt;");
        return str;
    }
    
}
