package com.formulasheet.model;
import java.util.List;
import java.util.ArrayList;

public class ContentsList<T extends Content> extends Content{

    private List<T> contents;

    public ContentsList() {
        super();
        this.contents = new ArrayList<>();
    }

    public ContentsList(ContentsList<T> lst) {
        super();
        this.contents = new ArrayList<>(lst.getContents());
    }


    public void addContent( T content){
        this.contents.add(content);
        content.setOwner(getOwner());
    }

    public void addContent(int i,  T content){
        this.contents.add(i, content);
        content.setOwner(getOwner());
    }

    public void addContents( List<T> contents){
        for(T content : contents){
            addContent(content);
        }
    }

    public T getContent(int i){
        return contents.get(i);
    }

    public T removeContent(int i){
        return contents.remove(i);
    }

    public int size(){
        return contents.size();
    }

    public List<T> getContents() {
        return contents;
    }
    
}
