package com.example.tfjvr.advanced_mobile;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class todoList extends AppCompatActivity {
    ArrayList<String> mExampleList1;

    ArrayAdapter<String> m_adapter;
    ArrayList<String> m_listItems = new ArrayList<String>();

    ListView lv;
    EditText et;
    Button saveBtn;


    public static final String TASK_LIST = "Task list";
    private Button insertButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        insertButton = (Button) findViewById(R.id.insertButton);
        lv = (ListView) findViewById(R.id.todoLv);
        et = (EditText) findViewById(R.id.editText);
        saveBtn = (Button) findViewById(R.id.saveButton2);



        m_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, m_listItems);
        lv.setAdapter(m_adapter);
        final String input = et.getText().toString();

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = et.getText().toString();
                if (null != input && input.length() > 0) {

                    m_listItems.add(input);

                    m_adapter.notifyDataSetChanged();
                }
            }
        });

        loadData();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Button pressed");
                saveData();
            }
        });

    }

    private void  saveData(){
        System.out.println("Saving Data");
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mExampleList1);
        editor.putString(TASK_LIST, json);
        editor.apply();
    }

    private void loadData(){
        System.out.println("Loading data...");
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(TASK_LIST, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        mExampleList1 = gson.fromJson(json, type);

    }


}
