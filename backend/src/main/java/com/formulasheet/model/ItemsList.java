package com.formulasheet.model;
import java.util.List;
import java.util.ArrayList;

public class ItemsList<T extends Item> extends Content{

    private List<T> items;

    public ItemsList() {
        super();
        this.items = new ArrayList<>();
    }

    public boolean addItem( T item){
        if(!this.items.add(item)){
            return false;
        }
        item.setParent(getOwner());
        return true;
    }

    public boolean addItem(int i,  T item){
        this.items.add(i, item);
        item.setParent(getOwner());
        return true;
    }

    public boolean addItems( List<T> items){
        for(T item : items){
            if(!addItem(item)){
                return false;
            }
        }
        return true;
    }

    public T getItem(int i){
        return items.get(i);
    }

    public T removeItem(int i){
        return items.remove(i);
    }

    public int size(){
        return items.size();
    }
    
}
