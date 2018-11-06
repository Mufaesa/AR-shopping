package com.example.tfjvr.advanced_mobile;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListDataActivity extends AppCompatActivity {

    private static final String TAG = "ListDataActivity";

    DatabaseHelper mDatabaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

        //set an onItemClickListener to the ListView
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + name);

                //get the id associated with that name
                int itemID = -1;
                Cursor data = mDatabaseHelper.getItemID(name);
                while(data.moveToNext()){
                    itemID = data.getInt(0);
                }

                Set<Integer> existingInts = new HashSet<Integer>();
                existingInts.add(1);
                existingInts.add(2);
                existingInts.add(3);

                if(itemID > -1){
                    Log.d(TAG, "onItemClick: The ID is: " + itemID);

                    if (existingInts.contains(itemID)) {

                        if (itemID == 1) {
                            Bundle b = new Bundle();
                            b.putStringArray("GroceryList", new String[]{"Venz melk hagelslag", "Venz puur hagelslag", "com.TomVrijmoet.HighlightedKaasMelk"});
                            Intent highlightIntent = new Intent(ListDataActivity.this, GroceryList.class);
                            highlightIntent.putExtras(b);
                            Log.d(TAG, "Kaas en melk!!!");
                            startActivity(highlightIntent);
                        }
                        if (itemID == 2) {
                            Bundle b = new Bundle();
                            b.putStringArray("GroceryList", new String[]{"Honig allesbinder", " ", "com.TomVrijmoet.HighlightedEi2"});
                            Intent highlightIntent = new Intent(ListDataActivity.this, GroceryList.class);
                            highlightIntent.putExtras(b);
                            Log.d(TAG, "Ei!!");
                            startActivity(highlightIntent);
                        }
                        if (itemID == 3) {
                            Bundle b = new Bundle();
                            b.putStringArray("GroceryList", new String[]{"Venz puur hagelslag", " ", "com.TomVrijmoet.HighlightedKaas"});
                            Intent highlightIntent = new Intent(ListDataActivity.this, GroceryList.class);
                            highlightIntent.putExtras(b);
                            Log.d(TAG, "Kaas!!");
                            startActivity(highlightIntent);
                        }
                    }else{
                        Bundle b = new Bundle();
                        b.putStringArray("GroceryList", new String[]{" ", " ", "com.TomVrijmoet.clearGroceryList"});
                        Intent highlightIntent = new Intent(ListDataActivity.this, GroceryList.class);
                        highlightIntent.putExtras(b);
                        Log.d(TAG, "No grocery items");
                        startActivity(highlightIntent);
                    }

                }
                else{
                    toastMessage("No ID associated with that task");
                }
            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}