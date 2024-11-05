package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GenerareMasina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_generare_masina);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int nrUsi = Integer.parseInt(((EditText)findViewById(R.id.nrUsi)).getText().toString());
            String nume = ((EditText)findViewById(R.id.numeMasina)).getText().toString();
            String tipMasina = ((EditText)findViewById(R.id.tipMasina)).getText().toString();
            String marca = ((EditText)findViewById(R.id.marcaMasina)).getText().toString();
            int anFabricatie = Integer.parseInt(((EditText)findViewById(R.id.anFabricatie)).getText().toString());
            Masina masina = new Masina(nrUsi,nume, tipMasina, marca, anFabricatie);
            Intent it = new Intent();
            it.putExtra("masina",masina);
            setResult(RESULT_OK,it);
            finish();
            Toast.makeText(GenerareMasina.this, masina.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}