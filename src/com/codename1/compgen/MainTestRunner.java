/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.compgen;

import com.codename1.compgen.tests.BasicLabel;
import com.codename1.compgen.tests.BasicButton;
import com.codename1.io.File;
import com.codename1.io.FileSystemStorage;
import com.codename1.testing.AbstractTest;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.util.ImageIO;
import com.codename1.compgen.tests.*;
import com.codename1.ui.CN;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author shannah
 */
public class MainTestRunner extends AbstractTest {
    //private float imageWidthMM=100;
    //private float imageHeightMM=50;
    private int imageWidth=800, imageHeight=400;
    
    private int padding = CN.convertToPixels(2);
    private String skin=Display.getInstance().getProperty("simulator.skin", "");
    private String theme="native";
    private File baseDir=new File("output");
    
    public interface Test {
        public Component getSubjectComponent();
        public String getId();
        public Category getCategory();
        public Links getLinks();
        public String getDescription();
    }
    

    @Override
    public boolean shouldExecuteOnEDT() {
        return true;
    }

    public Test[] getTests() {
        return new Test[]{
            new BasicLabel(),
            new BasicButton(),
            new BasicCheckBox(),
            new BasicRadio(),
            new BasicToggleButton()
        
        };
    }
    
    private String getOutputFileName(String id) {
        return id+".png";
    }
    
    private String getOutputPath(String id) {
        char sep = FileSystemStorage.getInstance().getFileSystemSeparator();
        return new File(baseDir, skin+sep+theme+sep+getOutputFileName(id)).getAbsolutePath();
    }
    
    private String[] platforms() {
        Set<String> out = new LinkedHashSet<String>();
        for (File skinDir : baseDir.listFiles()) {
            
            if (skinDir.isDirectory()) {
                out.add(skinDir.getName());
            }
        }
        return out.toArray(new String[out.size()]);
    }
    
    private String[] themes() {
        Set<String> out = new LinkedHashSet<String>();
        for (String platform : platforms()) {
            
            File skinDir = new File(baseDir, platform);
            
            for (File themeDir : skinDir.listFiles()) {
                
                if (themeDir.isDirectory()) {
                    String themeName = themeDir.getName();
                    out.add(themeName);
                }
            }
        }
        return out.toArray(new String[out.size()]);
    }
    
    private Category[] categories(Test[] tests) {
        Set<Category> out = new LinkedHashSet<Category>();
        for (Test test : tests) {
            out.add(test.getCategory());
        }
        return out.toArray(new Category[out.size()]);
    }
    
    public String generateHtml() {
        HTMLBuilder sb = new HTMLBuilder();
        sb.appendRaw("<!doctype html>").newLine()
                .open("html")
                .open("head")
                .open("title").append("Codename One Components").close()
                .close()
                .open("body");
        
        sb.open("div").attr("class", "cn-filters");
        sb.open("div").attr("class", "cn1-filter cn-filter-platforms");
        sb.open("h3").append("Skins").close();
        sb.open("ul");
        for (String platform : platforms()) {
            sb.open("li").open("a").attr("href", "#").attr("data-platform", platform).append(platform).close().close();
        }
        sb.close(); // ul
        sb.close(); // cn-filter-platforms
        
        sb.open("div").attr("class", "cn1-filter cn-filter-themes");
        sb.open("h3").append("Theme").close();
        sb.open("ul");
        for (String theme : themes()) {
            sb.open("li").open("a").attr("href", "#").attr("data-theme", theme).append(theme).close().close();
        }
        sb.close(); // ul
        sb.close(); // cn-filter-themes
        
        sb.open("div").attr("class", "cn1-filter cn-filter-categories");
        sb.open("h3").append("Theme").close();
        sb.open("ul");
        for (Category category : categories(getTests())) {
            sb.open("li").open("a").attr("href", "#").attr("data-category", category.getId()).append(category.getLabel()).close().close();
        }
        sb.close(); // ul
        sb.close(); // cn-filter-categories
        
        sb.close(); // div class=cn-filters
        sb.open("div")
                .attr("class", "cn-tests");
        for (Test test : getTests()) {
            sb.open("div")
                    .attr("class", "cn-test")
                    .attr("data-test-id", test.getId())
                    .open("h2").append(test.getId()).close();
            for (File skinDir : baseDir.listFiles()) {
                if (!skinDir.isDirectory()) {
                    continue;
                }
                String skinName = skinDir.getName();
                for (File themeDir : skinDir.listFiles()) {
                    if (!themeDir.isDirectory()) {
                        continue;
                    }
                    String themeName = themeDir.getName();
                    File imgFile = new File(themeDir, getOutputFileName(test.getId()));
                    if (imgFile.exists()) {
                        sb.open("div").attr("class", "cn1-test-preview")
                                .attr("data-theme", themeName)
                                .attr("data-skin", skinName)
                                .open("img").attr("src", skinName+"/"+themeName+"/"+getOutputFileName(test.getId()))
                                    .attr("style", "width:"+(imageWidth/2)+"px; height:"+(imageHeight/2)+"px; border:1px solid gray")
                                .close() // img
                                .open("div").attr("class", "cn-test-links").open("ul");
                        for (Link link : test.getLinks()) {
                            sb.open("li").open("a").attr("class", "cn-test-link-"+link.getType().name()).attr("href", link.getUrl()).append(link.getType().name()).close().close();
                        }
                        sb.close().close(); // ul / div cn1-test-links
                        sb.open("div").attr("class", "cn-test-description").append(test.getDescription()).close();
                        sb.close();// div cn1-test-preview
                                
                               
                    }
                }
            }
            sb.close(); //cn-test
                    
        }
        sb.close(); //div cn-tests
        sb.close(); //body
        sb.close(); //html
        return sb.toString();
    }
    
    private Image createScaled(Image img, int w, int h) {
        Image out = Image.createImage(w, h, 0x0);
        Graphics g = out.getGraphics();
        g.setAntiAliased(true);
        
        g.drawImage(img, 0, 0, w, h);
        return out;
    }
    
    @Override
    public boolean runTest() throws Exception {
        int index = 0;
        
        
        for (Test test : getTests()) {
            Form f = test.getSubjectComponent().getComponentForm();
            String fname = "form"+index;
            index++;
            f.setName(fname);
            f.show();
            waitForFormName(fname);
            
            Component cmp = test.getSubjectComponent();
            Image img = cmp.toImage();
            
            Image background = Image.createImage(imageWidth, imageHeight, 0x0);
            
            int x = 0;
            int y = 0;
            int w = 0;
            int h = 0;
            System.out.println(test.getId()+" "+img.getWidth()+"x"+img.getHeight());
            if (img.getWidth() > imageWidth - 2 * padding) {
                System.out.println("Image for "+test.getId()+" is too wide: "+img.getWidth());
                w = imageWidth - 2*padding;
                h = (int)Math.round(w * img.getHeight()/(double)img.getWidth());
                img = createScaled(img, w, h);
            }
            if (img.getHeight() > imageHeight - 2 * padding) {
                System.out.println("Image for "+test.getId()+" is too high: "+img.getHeight());
                h = imageHeight - 2 * padding;
                w = (int)Math.round(h * img.getWidth()/(double)img.getHeight());
                img = createScaled(img, w, h);
            }
            Graphics g = background.getGraphics();
            g.drawImage(img, imageWidth / 2 - img.getWidth()/2, imageHeight / 2 - img.getHeight() / 2);
            
            new File(getOutputPath(test.getId())).getParentFile().mkdirs();
            ImageIO.getImageIO().save(background, FileSystemStorage.getInstance().openOutputStream(getOutputPath(test.getId())), ImageIO.FORMAT_PNG, 100);
            
            
        }
        File indexHtml = new File(baseDir, "index.html");
        FileSystemStorage.getInstance().openOutputStream(indexHtml.getAbsolutePath()).write(generateHtml().getBytes("UTF-8"));
        Display.getInstance().execute(indexHtml.getAbsolutePath());
        Display.getInstance().exitApplication();
        return true;
    }
    
    
    
}
