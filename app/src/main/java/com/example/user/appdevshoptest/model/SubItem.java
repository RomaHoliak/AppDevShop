package com.example.user.appdevshoptest.model;

import java.util.List;

public class SubItem {

    private List<Item> listItems;

    public SubItem(List<Item> listItems){
        this.listItems = listItems;
    }


    public List<Item> getListItems() {
        return listItems;
    }

}
