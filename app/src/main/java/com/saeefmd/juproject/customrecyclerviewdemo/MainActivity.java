package com.saeefmd.juproject.customrecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private HeaderModel headerModel;
    private ListModel listModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);

        headerModel = new HeaderModel();
        listModel = new ListModel();

        setHeaderModel();
        setListModel();
        setRecyclerView();
    }

    private void setHeaderModel() {
        headerModel.setTitle("Wallpapers");
        headerModel.setDesc("Check Out These Beautiful Wallpapers");
        headerModel.setSource("Source: Unsplash.com");
    }

    private void setListModel() {
        List<Integer> urls = new ArrayList<>();

        for (int i=0; i<=30; i++) {
            urls.add(i);
        }

        /*urls.add("https://unsplash.com/photos/PRSm9_059_I");
        urls.add("https://unsplash.com/photos/LMU2w-K4J7k");
        urls.add("https://unsplash.com/photos/qMYBsbbyga0");
        urls.add("https://unsplash.com/photos/coUZnech6qw");
        urls.add("https://unsplash.com/photos/key37thh970");*/
        //urls.add("");

        listModel.setImageUrls(urls);
    }

    private void setRecyclerView() {

        /*GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(MainActivity.this, headerModel, listModel);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.isHeader(position) ? gridLayoutManager.getSpanCount() : 1;
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(adapter);*/

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(MainActivity.this, headerModel, listModel);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(myRecyclerAdapter);
    }
}