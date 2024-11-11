package com.formulasheet.model;

public class Formula extends RectItem {

    public Formula() {
        super();
        setContent(new FormulaContent());
    }

    public Formula(String latex){
        super();
        setContent(new FormulaContent(latex));

    }
    
}
