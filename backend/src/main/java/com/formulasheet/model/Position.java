package com.formulasheet.model;

public class Position {

    int x;
    int y;

    public Position() {
    }

    public Position(int x, int y) {
        this.x = x;
        this.y =y;
       
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }
    
}
