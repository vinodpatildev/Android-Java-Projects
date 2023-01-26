package com.vinodpatildev.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,"application started.",Toast.LENGTH_LONG).show();

        ListView myListView = (ListView) findViewById(R.id.myListView);

        ArrayList<String> familyMembers = new ArrayList<String>();

        familyMembers.add("Vinod");
        familyMembers.add("Rahul");
        familyMembers.add("Yogesh");
        familyMembers.add("Prathamesh");
        familyMembers.add("Vinod");
        familyMembers.add("Rahul");
        familyMembers.add("Yogesh");
        familyMembers.add("Prathamesh");
        familyMembers.add("Vinod");
        familyMembers.add("Rahul");
        familyMembers.add("Yogesh");
        familyMembers.add("Prathamesh");
        familyMembers.add("Vinod");
        familyMembers.add("Rahul");
        familyMembers.add("Yogesh");
        familyMembers.add("Prathamesh");


        ArrayAdapter<String> familyMembersAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,familyMembers);

        myListView.setAdapter(familyMembersAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Snackbar.make(view,familyMembers.get(i),Snackbar.LENGTH_LONG).show();
            }
        });
    }
}