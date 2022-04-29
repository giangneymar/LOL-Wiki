package com.example.lolwiki.models;

public class Champion {
    private String name;
    private boolean isSuper;

    public Champion(String name, boolean isSuper) {
        this.name = name;
        this.isSuper = isSuper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSuper() {
        return isSuper;
    }

    public void setSuper(boolean aSuper) {
        isSuper = aSuper;
    }
}
