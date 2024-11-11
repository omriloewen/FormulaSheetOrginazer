package com.formulasheet.model;

public class Sheet extends Item{

    private int pageNum;
     
    public Sheet(int i) {
        super();
        this.pageNum = i;
        ItemsList<Page> lst = new ItemsList<Page>();
        lst.setOwner(this);
        for (int j = 0; j < i; j++) {
            lst.addItem(new Page());
        }
        setContent(lst);
    }


    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageNum() {
        return pageNum;
    }
}
