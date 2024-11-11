package com.formulasheet.model;

public  class Shape {
    private boolean topFixed;
    private boolean bttmFixed;
    private boolean leftFixed;
    private boolean rightFixed;
    private Item Owner;

    public Shape() {
        this.topFixed = false;
        this.bttmFixed = false;
        this.leftFixed = false;
        this.rightFixed = false;
    }
    
    public Shape(boolean Fixed) {
        this.topFixed = Fixed;
        this.bttmFixed = Fixed;
        this.leftFixed = Fixed;
        this.rightFixed = Fixed;
    }

    public Shape(boolean topBttmFixed, boolean leftRightFixed) {
        this.topFixed = topBttmFixed;
        this.bttmFixed = leftRightFixed;
        this.leftFixed = leftRightFixed;
        this.rightFixed = topBttmFixed;
    }

    public Shape(boolean topFixed, boolean bttmFixed,  boolean rightFixed) {
        this.topFixed = topFixed;
        this.bttmFixed = bttmFixed;
        this.leftFixed = false;
        this.rightFixed = rightFixed;
    }

    public Shape(boolean topFixed, boolean bttmFixed,  boolean leftFixed, boolean rightFixed) {
        this.topFixed = topFixed;
        this.bttmFixed = bttmFixed;
        this.leftFixed = leftFixed;
        this.rightFixed = rightFixed;
    }

    public void setBttmFixed(boolean bttmFixed) {
        this.bttmFixed = bttmFixed;
    }

    public boolean isBttmFixed() {
        return bttmFixed;
    }

    public void setLeftFixed(boolean leftFixed) {
        this.leftFixed = leftFixed;
    }

    public boolean isLeftFixed() {
        return leftFixed;
    }

    public void setRightFixed(boolean rightFixed) {
        this.rightFixed = rightFixed;
    }

    public boolean isRightFixed() {
        return rightFixed;
    }

    public void setTopFixed(boolean topFixed) {
        this.topFixed = topFixed;
    }

    public boolean isTopFixed() {
        return topFixed;
    }

    public Item getOwner() {
        return Owner;
    }

    public void setOwner(Item owner) {
        Owner = owner;
    }




}
