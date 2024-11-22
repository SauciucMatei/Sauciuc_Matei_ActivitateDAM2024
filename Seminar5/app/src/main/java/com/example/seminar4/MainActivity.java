package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Motocicleta> motocicletas =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.lv_imagini), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        motocicletas =new ArrayList<>();


        Button btn=findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getApplicationContext(), AdaugareMotocicleta.class);
                startActivityForResult(it,403);
            }
        });

        Button btnLista=findViewById(R.id.button2);
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(getApplicationContext(), ListaMotociclete.class);
                it.putParcelableArrayListExtra("motociclete",(ArrayList<? extends Parcelable>) motocicletas);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==403)
        {
            if(resultCode==RESULT_OK)
            {
                Motocicleta motocicleta =data.getParcelableExtra("motocicleta");
                motocicletas.add(motocicleta);
                Toast.makeText(getApplicationContext(), motocicleta.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}