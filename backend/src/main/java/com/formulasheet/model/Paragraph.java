package com.formulasheet.model;

public class Paragraph extends Item {

    public Paragraph() {
        super();
        setContent(new ItemsList<Line>());
    }

     public Paragraph(String text) {
        super();
        setContentFromText(text);
    }

    public void setContentFromText(String text){
        ItemsList<Line> lst = new ItemsList<>();
        lst.setOwner(this);
        String[] lines = text.split("[.//n]+");
        for(String line : lines){
            if(!line.trim().isEmpty()){
                Line lineContent = new Line(line.trim());
                lst.addItem(lineContent);
            }
        }
        setContent(lst);
    }


    @SuppressWarnings("unchecked")
    public ItemsList<Line> getLines(){
        return (ItemsList<Line>)getContent();
       
    }

    @Override
    public void setContent(Content content){
        if(content instanceof ItemsList){
            super.setContent(content);
        }
    }


    
}
