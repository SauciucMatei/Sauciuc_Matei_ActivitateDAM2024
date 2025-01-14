package com.example.seminar4;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListaFirebase extends AppCompatActivity {
    List<Motocicleta> motociclete=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_firebase);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://ase-dam-e0a89-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference referece = database.getReference();
        referece.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> snapshots = snapshot.getChildren();
                for(DataSnapshot snapshot1 : snapshots) {
                    Motocicleta motocicleta = snapshot1.getValue(Motocicleta.class);
                    motociclete.add(motocicleta);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ArrayAdapter<Motocicleta> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,motociclete);
        ListView view = findViewById(R.id.lv_1);
        view.setAdapter(adapter);
    }
}