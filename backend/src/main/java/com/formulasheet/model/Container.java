package com.formulasheet.model;

public class Container extends Item{

    public Container() {
        super();
        setContent(new ItemsList<Item>());
        getContent().setOwner(this);
    }



    public boolean addItem(Item item){
        return getContent().addItem(item);
    }

    public boolean addItem(int i, Item item){
        return getContent().addItem(i, item);
    }

    public Item removeItem(int i){
        return getContent().removeItem(i);
    }

    @SuppressWarnings("unchecked")
    @Override
    public ItemsList<Item> getContent() {
        
        return (ItemsList<Item>)super.getContent();
    }

    @Override
    protected void setContent(Content content) {
        if(content instanceof ItemsList){
            super.setContent(content);
        }
        
    }
    
}
