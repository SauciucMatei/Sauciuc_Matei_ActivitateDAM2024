package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class ListaMotociclete extends AppCompatActivity {

    private List<Motocicleta> motociclete = null;
    private int idModificat = 0;
    private MotocicleteAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_motociclete);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lv_imagini), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it = getIntent();
        List<Motocicleta> motociclete = it.getParcelableArrayListExtra("motociclete");
        if (motociclete == null) {
            Toast.makeText(this, "Lista de motociclete este goală sau nu a fost primită corect.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, motociclete.toString(), Toast.LENGTH_SHORT).show();
        }
        ListView lv = findViewById(R.id.lista);

//        ArrayAdapter<Elicopter> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, motociclete);
//        lv.setAdapter(adapter);
        adapter = new MotocicleteAdapter(motociclete, getApplicationContext(), R.layout.list_view_linie);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intentModifica = new Intent(getApplicationContext(), AdaugareMotocicleta.class);
                intentModifica.putExtra("motocicleta", motociclete.get(position));
                idModificat = position;
                startActivityForResult(intentModifica, 209);
                Toast.makeText(getApplicationContext(), motociclete.get(position).toString(), Toast.LENGTH_LONG).show();

            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                motociclete.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 209) {
            motociclete.set(idModificat, data.getParcelableExtra("motocicleta"));
            adapter.notifyDataSetChanged();
        }
    }
}