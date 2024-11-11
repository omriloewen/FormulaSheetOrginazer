package com.formulasheet.model;

public abstract class RawContent extends Content {
    protected double heightPerFontSize;
    protected double widthPerFontSize;


    public RawContent() {
        super();
    }

    public double getHeightPerFontSize() {
        return heightPerFontSize;
    }

    public double getWidthPerFontSize() {
        return widthPerFontSize;
    }

    public void setHeightPerFontSize(double height) {
        this.heightPerFontSize = height;
    }

    public void setWidthPerFontSize(double width) {
        this.widthPerFontSize = width;
    }

}
