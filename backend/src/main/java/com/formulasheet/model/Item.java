package com.formulasheet.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public abstract class Item {

    public static int[] levelsFontSizes = {20,20,20,20,20};
    protected static int baseFontSize = 20;

    private String id;
    private double relFontSize;
    private Title title;
    private Content content;
    private Shape shape;
    private Order order;
    private Orderator orderator;
    private Item parent;
    private int level = 4;
    private Position position;



    public Item() {
        LocalDateTime currTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        this.id = currTime.format(formatter);
        relFontSize = 1;

    }

    public Item(Content content, String title) {
        this();
        this.content = content;
        this.content.setOwner(this);
        this.title = new Title(title);
        this.title.setParent(this);
    }

    public Item(Content content) {
        this();
        this.content = content;
        this.content.setOwner(this);
    }

    public static boolean setBaseFontSize(int i){
        if(i < 10 || i > 18){
            return false;
        }
        baseFontSize = i;
        return true;
    }

    public static int BaseFontSize(){
        return baseFontSize;
    }

    public int fontSizeFromRelSize(){
        if(relFontSize == 1){
            return levelsFontSizes[level];
        }
        return (int)Math.floor((levelsFontSizes[level] - 8) * relFontSize) + 8;
    }


    protected void setContent(Content content) {
        this.content = content;
        this.content.setOwner(this);
    }

    public Content getContent() {
        return content;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrderator(Orderator orderator) {
        this.orderator = orderator;
    }

    public Orderator getOrderator() {
        return orderator;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
        this.shape.setOwner(this);
    }

    public Shape getShape() {
        return shape;
    }

    

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setRelFontSize(double relFontSize) {
        this.relFontSize = relFontSize;
    }

    public double getRelFontSize() {
        return relFontSize;
    }

    public void setTitle(Title title) {
        this.title = title;
        this.title.setParent(this);
    }

    public void setTitle(String title) {
        this.title = new Title(title) ;
        this.title.setParent(this);
    }

    public Title getTitle() {
        return title;
    }

    public Item getParent() {
        return parent;
    }
    public void setParent(Item parent) {
        this.parent = parent;
        this.relFontSize = this.relFontSize * parent.getRelFontSize();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setPosition(int x, int y) {
        this.position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }
    
}
