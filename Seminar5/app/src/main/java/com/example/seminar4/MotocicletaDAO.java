package com.example.seminar4;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MotocicletaDAO {
    @Query("SELECT * FROM Motociclete")
    List<Motocicleta> getAll();

    @Query("Select * FROM Motociclete WHERE producator=:producator")
    Motocicleta getById(String producator);

    @Insert(entity = Motocicleta.class)
    void insertMotocicleta(Motocicleta motocicleta);
}