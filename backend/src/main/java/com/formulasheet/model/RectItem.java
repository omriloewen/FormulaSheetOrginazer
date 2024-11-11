package com.formulasheet.model;


public abstract class RectItem extends Item {
    
    public RectItem() {
        super();
        setShape(new Rect());
        

    }

    public  RectItem(Content content, String title) {
        super(content,title);
        setShape(new Rect());
        
    }

    public RectItem(Content content) {
        super(content);
        setShape(new Rect());
        
    }

}
