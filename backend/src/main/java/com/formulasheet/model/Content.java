package com.formulasheet.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public abstract class Content {
    private String id;
    private Item owner;

    public Content() {
        LocalDateTime currTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        this.id = currTime.format(formatter);
        this.owner = null;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOwner(Item owner) {
        this.owner = owner;
    }

    public Item getOwner() {
        return owner;
    }
}
