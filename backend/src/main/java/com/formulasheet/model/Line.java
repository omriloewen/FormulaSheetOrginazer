package com.formulasheet.model;

public class Line extends RectItem {

    public Line(){
        super();
        TextContent textContent = new TextContent();
        textContent.setOwner(this);
        setContent(textContent);
    }

    public Line(String text) {
        super();
        TextContent textContent = new TextContent(text);
        textContent.setOwner(this);
        setContent(textContent);
    }



  

    
}
