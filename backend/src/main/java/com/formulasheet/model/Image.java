package com.formulasheet.model;

public class Image extends RectItem {

    public Image() {
        super();
        setContent(new ImageContent());
    }

    public Image(String src){
        super();
        setContent(new ImageContent(src, getRootTextSize()));
    }
    
}
