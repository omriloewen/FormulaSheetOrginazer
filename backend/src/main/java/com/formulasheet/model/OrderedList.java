package com.formulasheet.model;

public class OrderedList extends Container {

    public OrderedList() {
        super();
        setShape(new BulletList());
    }

    @Override
    public boolean addItem(Item item) {
        if(item.getShape() instanceof Rect){
            return super.addItem(item);
        }
        return false;
    }

    @Override
    public boolean addItem(int i, Item item) {
        if(item.getShape() instanceof Rect){
            return super.addItem(i, item);
        }
        return false;
    }
    
}
