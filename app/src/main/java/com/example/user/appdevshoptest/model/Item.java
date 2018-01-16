package com.example.user.appdevshoptest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {

    private int id;
    private String name;

    private boolean isCheck;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @SerializedName("children")
    private List<Item> listItems;


    public List<Item> getListItems() {
        return listItems;
    }

    public boolean isEmpty(){
       return listItems.isEmpty();
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
