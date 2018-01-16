package com.example.user.appdevshoptest.presenter;

import com.example.user.appdevshoptest.model.Item;
import java.util.ArrayList;

public interface IGetList extends IProgress {
    void onSucces(ArrayList<Item> arrayList);
    void onError(String error);
}
