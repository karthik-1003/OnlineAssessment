package com.example.onlineassessment;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OptionsActivity extends AppCompatActivity {
    Button b1, b2, b3, b4;
//    A Firebase reference represents a particular location in your Database and can be used for reading or
//    writing data to that Database location.
    DatabaseReference databaseReference;
    public static ArrayList<Modelclass> listOfQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        listOfQ = new ArrayList<>();
//        The entry point for accessing a Firebase Database. You can get an instance by calling getInstance().
//        To access a location in the database and read or write data, use getReference().

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference = FirebaseDatabase.getInstance().getReference("os");
//                disableButton(b1);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        A DataSnapshot instance contains data from a Firebase Database location.
//                        Any time you read Database data, you receive the data as a DataSnapshot.
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

//                            getChildren()
//                            Gives access to all of the immediate children of this snapshot.
                            Modelclass modelclass = dataSnapshot1.getValue(Modelclass.class);
//                            getValue method is used to marshall the data contained in this snapshot into a class of your choosing.
                            listOfQ.add(modelclass);
                        }
                        Intent intent = new Intent(OptionsActivity.this, CountdownActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference = FirebaseDatabase.getInstance().getReference("question");
//                disableButton(b1);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            Modelclass modelclass = dataSnapshot1.getValue(Modelclass.class);
                            listOfQ.add(modelclass);
                        }
                        Intent intent = new Intent(OptionsActivity.this, CountdownActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference = FirebaseDatabase.getInstance().getReference("python");
//                disableButton(b1);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            Modelclass modelclass = dataSnapshot1.getValue(Modelclass.class);
                            listOfQ.add(modelclass);
                        }
                        Intent intent = new Intent(OptionsActivity.this, CountdownActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference = FirebaseDatabase.getInstance().getReference("java");
//                disableButton(b1);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            Modelclass modelclass = dataSnapshot1.getValue(Modelclass.class);
                            listOfQ.add(modelclass);
                        }
                        Intent intent = new Intent(OptionsActivity.this, CountdownActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }
//    public void disableButton(Button button){
//        button.setClickable(false);
//    }
}