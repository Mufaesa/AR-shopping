package com.example.tfjvr.advanced_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class GroceryList extends AppCompatActivity {

    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    String[] mArray;

    private static final String TAG = "ListDataActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        ListView mListView = (ListView) findViewById(R.id.listView);

        mListView.setAdapter(adapter);

        Bundle b=this.getIntent().getExtras();
        String[] array=b.getStringArray("GroceryList");

        mArray = array;

        listItems.add(array[0]);

        String mString = array[1];
        if(mString.equals(" ")){

        }else {
            listItems.add(array[1]);
        }
    }

    public void openCamera(View view) {

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(mArray[2]);
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        }
    }


}
