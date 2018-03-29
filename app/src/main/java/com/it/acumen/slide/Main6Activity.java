package com.it.acumen.slide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {
    ListView listview;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        user=new User();
        listview=(ListView)findViewById(R.id.ListView);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Tests");
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.user_info,R.id.userInfo,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    user=ds.getValue(User.class);
                    list.add("Test name:"+user.getTestname().toString()+"  \n " +"Branch :"+user.getBranch().toString()+"\n"+"TAKE TEST");
                }
                listview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(Main6Activity.this,Main7Activity.class);
                startActivity(intent);
            }
        });
    }
}
