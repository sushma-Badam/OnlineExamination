package com.it.acumen.slide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main7Activity extends AppCompatActivity {
    private TextView Test;
    Tester test;
    FirebaseDatabase database1;
    DatabaseReference ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        database1=FirebaseDatabase.getInstance();
        ref1=database1.getReference("questions");
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                test=dataSnapshot.getValue(Tester.class);
                Test.setText(test.getSno()+test.getQues()+" \n"+test.getOption1()+"\n"+test.getOption2()+"\n"+test.getOption3()+"\n"+test.getOption4());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
