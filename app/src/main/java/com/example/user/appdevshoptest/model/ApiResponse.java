package com.example.user.appdevshoptest.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;


public class ApiResponse {

    @SerializedName("response")
    private ArrayList<Item> arrayList;

    public ArrayList<Item> getArrayList() {
        return arrayList;
    }
}
