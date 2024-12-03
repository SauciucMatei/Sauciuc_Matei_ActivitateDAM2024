package com.example.seminar4;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Motocicleta.class}, version = 1)
@TypeConverters({com.example.seminar4.TypeConverters.class})
public abstract class MotocicleteDatabase extends RoomDatabase {
    public abstract MotocicletaDAO motocicletaDAO();

    public static MotocicleteDatabase instance;

    public static synchronized MotocicleteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            MotocicleteDatabase.class, "Motociclete")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

