package com.example.seminar4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ListaPoze extends AppCompatActivity {
    List<Bitmap> imagini = null;
    List<ImaginiDomeniu> imgItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_poze);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imagineIV), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<String> linkuriImagini = new ArrayList<>();
        imagini = new ArrayList<>();

        linkuriImagini.add("https://www.motociclete.com.ro/images/principal/2024-Yamaha-YZF700R7-EU-Icon_Blue-360-Degrees-001-03.jpg");
        linkuriImagini.add("https://www.cfmoto.ro/storage/transformed_images/homepage/product-card/cfmoto-300nk-albastr-vfhcr-1663829512_200x200.jpg");

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for(String link:linkuriImagini){
                    HttpURLConnection connection = null;
                    try {
                        URL url = new URL(link);
                        connection = (HttpURLConnection) url.openConnection();

                        InputStream is = connection.getInputStream();
                        imagini.add(BitmapFactory.decodeStream(is));
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imgItems = new ArrayList<>();
                        imgItems.add(new ImaginiDomeniu("Motocicleta 1",imagini.get(0),"https://www.motociclete.com.ro"));
                        imgItems.add(new ImaginiDomeniu("Motocicleta 2",imagini.get(1),"https://www.motociclete.com.ro"));

                        ListView lv = findViewById(R.id.lv_imagini);
                        ImageAdapter adapter = new ImageAdapter(getApplicationContext(),R.layout.image_adapt,imgItems);
                    }
                })
            }
        });

    }
}