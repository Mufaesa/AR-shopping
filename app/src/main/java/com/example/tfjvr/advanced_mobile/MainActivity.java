package com.example.tfjvr.advanced_mobile;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseHelper = new DatabaseHelper(this);

    }

//    public void removenr3(){
//        mDatabaseHelper.deletenr3(4);
//    }

    public void RememberView(View view) {
        startActivity(new Intent(MainActivity.this, sqlDatabase.class));
    }

}
