package com.pbochenski.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;

public class Example2 extends AppCompatActivity {

    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.list)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example3);
        ButterKnife.bind(this);
    }

    @OnItemSelected(R.id.spinner)
    void onSpinnerItemSelected(int position) {
        Toast.makeText(this, getResources().getStringArray(R.array.spinner1)[position], Toast.LENGTH_SHORT).show();
    }

    @OnItemClick(R.id.list)
    void onListItemClicked(int position) {
        Toast.makeText(this, getResources().getStringArray(R.array.list1)[position], Toast.LENGTH_SHORT).show();
    }
}
