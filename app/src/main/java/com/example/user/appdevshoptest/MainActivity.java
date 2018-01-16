package com.example.user.appdevshoptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.user.appdevshoptest.adapters.MainAdapter;
import com.example.user.appdevshoptest.model.Entity;
import com.example.user.appdevshoptest.model.Item;
import com.example.user.appdevshoptest.presenter.IGetList;
import com.example.user.appdevshoptest.presenter.PGetList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IGetList {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private PGetList pGetList;
    private Toolbar toolbar;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        pGetList = new PGetList(this);
        pGetList.getList();
    }



    private void initView(){
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setTitle("Vertical Linear Sample");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    private void showList(ArrayList<Item> arrayList){
        ArrayList<Entity> arrayEntity = new ArrayList<>();
        for (Item item: arrayList)
            arrayEntity.add(Entity.newBuilder().setItem(item).build());


        recyclerView.setVisibility(View.VISIBLE);
        MainAdapter mainAdapter = new MainAdapter(arrayEntity,this);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void showProgress() {
        if (progressBar != null)
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        if (progressBar != null)
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSucces(ArrayList<Item> arrayList) {
        showList(arrayList);
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }

}
