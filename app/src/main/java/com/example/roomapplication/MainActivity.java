package com.example.roomapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText firstName, lastName;
    Button insertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.t1);
        lastName = findViewById(R.id.t2);
        insertButton = findViewById(R.id.b1);

        insertButton.setOnClickListener(view -> {
            new backgroundThread().start();
        });
    }

    class backgroundThread extends Thread{
        public void run(){
            AppDatabase db  = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "room_db").build();
            UserDao userDao = db.userDao();
            userDao.userRegistration(new User(0, firstName.getText().toString(), lastName.getText().toString()));
        }
    }
}