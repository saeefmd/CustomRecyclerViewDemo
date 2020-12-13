package com.saeefmd.juproject.customrecyclerviewdemo;

public class HeaderModel {

    private String title;
    private String desc;
    private String source;

    public HeaderModel(String title, String desc, String source) {
        this.title = title;
        this.desc = desc;
        this.source = source;
    }

    public HeaderModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
