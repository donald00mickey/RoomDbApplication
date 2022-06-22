package com.example.roomapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import java.security.PublicKey;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
