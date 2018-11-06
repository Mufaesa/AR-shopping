package com.example.tfjvr.advanced_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditDataActivity extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";

    private Button btnSave,btnDelete;
    private EditText editable_item;

    DatabaseHelper mDatabaseHelper;

    //Add global variables for the extra incoming data (name id)
    private String selectedName;
    private int selectedID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_layout);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        editable_item = (EditText) findViewById(R.id.editable_item);
        mDatabaseHelper = new DatabaseHelper(this);

        Bundle b = this.getIntent().getExtras();
        String[] array=b.getStringArray("shoppingList");

        String item1 = (array[0]);
        editable_item.setText(item1);


//        //get the intent extra from the ListDataActivity
//        Intent receivedIntent = getIntent();
//
//        //now get the itemID we passed as an extra
//        selectedID = receivedIntent.getIntExtra("id",-1);
//
//        //now get the name we passed as an extra
//        selectedName = receivedIntent.getStringExtra("name");
//
//        //set the text to show the current selected name
//        editable_item.setText(selectedName);
//
//        //Save button
//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String item = editable_item.getText().toString();
//                if(!item.equals("")){
//                    mDatabaseHelper.updateName(item,selectedID,selectedName);
//                }else{
//                    toastMessage("You must enter a task");
//                }
//            }
//        });
//
//        //Delete button
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mDatabaseHelper.deleteName(selectedID,selectedName);
//                editable_item.setText("");
//                toastMessage("removed from database");
//            }
//        });

    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}