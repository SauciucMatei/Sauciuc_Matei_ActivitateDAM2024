package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class AdaugareMotocicleta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adaugare_motocicleta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lv_imagini), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent it = getIntent();

        if (it.hasExtra("motocicleta")) {
            Motocicleta motocicleta = it.getParcelableExtra("motocicleta");
            EditText etProducator = findViewById(R.id.numeProducator);
            etProducator.setText(motocicleta.getProducator());

            EditText etPret = findViewById(R.id.pret);
            etPret.setText(String.valueOf(motocicleta.getPret()));

            EditText etAutonomie = findViewById(R.id.autonomie);
            etAutonomie.setText(String.valueOf(motocicleta.getAutonomie_Mile()));

            EditText etNrLocuri = findViewById(R.id.numarLocuri);
            etNrLocuri.setText(String.valueOf(motocicleta.getNumarLocuri()));

            Spinner stTip = findViewById(R.id.tip);
            stTip.setSelected(motocicleta.isNou());

            DatePicker dp = findViewById(R.id.data);
            dp.init(dp.getYear(),dp.getMonth(),dp.getDayOfMonth(),null);
        }

        Button salvareBtn = findViewById(R.id.button);
        salvareBtn.setOnClickListener((view) ->
        {
            EditText etNumeProducator = findViewById(R.id.numeProducator);
            String numeProducator = etNumeProducator.getText().toString();

            EditText etPret = findViewById(R.id.pret);
            float pret = Float.parseFloat((etPret.getText().toString()));

            EditText etAutonomie = findViewById(R.id.autonomie);
            float autonomie = Float.parseFloat(etAutonomie.getText().toString());

            EditText etNumarLocuri = findViewById(R.id.numarLocuri);
            int numarLocuri = Integer.parseInt(etNumarLocuri.getText().toString());

            Spinner spTip = findViewById(R.id.tip);
            boolean nou;
            nou = spTip.getSelectedItem().toString().contentEquals("nou");

            DatePicker dp = findViewById(R.id.data);
            Date data = new Date(dp.getYear(), dp.getMonth(), dp.getDayOfMonth());
            Motocicleta motocicleta = new Motocicleta(numeProducator, pret, autonomie, numarLocuri, data, nou);


            it.putExtra("motocicleta", motocicleta);
            setResult(RESULT_OK, it);
            finish();
        });
    }
}