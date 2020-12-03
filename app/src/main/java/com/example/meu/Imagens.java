package com.example.meu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Imagens extends AppCompatActivity {
    ImageView imgPorsche, imgFerrari;
    Button btnPorsche, btnFerrari;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.imagens);

        btnFerrari = findViewById(R.id.btnFerrari);
        btnPorsche = findViewById(R.id.btnPorsche);
        imgPorsche = findViewById(R.id.imgPorsche);
        imgFerrari = findViewById(R.id.imgFerrari);

        btnFerrari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setContentView(R.layout.ferrari);
                //CarregaTelaFerrari();
            }
        });


        btnPorsche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.porsche);
            }
        });

    }


}
