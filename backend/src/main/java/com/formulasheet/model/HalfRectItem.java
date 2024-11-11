package com.formulasheet.model;


public abstract class HalfRectItem extends Item {
    
    public HalfRectItem() {
        super();
        setShape(new HalfRect());
        

    }

    public HalfRectItem(Content content, String title) {
        super(content,title);
        setShape(new HalfRect());
        
    }

    public HalfRectItem(Content content) {
        super(content);
        setShape(new HalfRect());
        
    }

}
