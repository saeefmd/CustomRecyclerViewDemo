package com.saeefmd.juproject.customrecyclerviewdemo;

import java.util.List;

public class ListModel {

    private List<Integer> imageUrls;

    public ListModel(List<Integer> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public ListModel() {
    }

    public List<Integer> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<Integer> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
