package com.example.meu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.*;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ImageView imgPorsche, imgFerrari;
    Button btnPorsche, btnFerrari, btnVoltar, btnFinalizar;
    RadioButton rbtV12, rbtV6;
    RadioGroup rbPorsche, rbFerrari;
    CheckBox chkSom, chkGPS;
    ListView lista_contatos;
    String escolha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.imagens)
        {
            setContentView(R.layout.imagens);
            CarregarTelaImagens();
        }
        if(id == R.id.contatos)
        {
            setContentView(R.layout.lista_contatos);
            CarregarTelaContatos();
        }

        if(id == R.id.maps)
        {
            setContentView(R.layout.activity_maps);
        }

        if(id == R.id.sair)
        {
            Toast.makeText(
                    getApplicationContext(),
                    "Sair",
                    Toast.LENGTH_LONG).show();
            finish();
            System.exit(0);
            //return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void CarregarTelaContatos() {
        setContentView(R.layout.lista_contatos);

        lista_contatos = (ListView) findViewById(R.id.lista_contatos);

        lista_contatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = ((TextView) view).getText().toString();
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Contatos");
                alert.setMessage("Contato Selecionado " + nome);
                alert.setNeutralButton("OK", null);
                alert.show();
            }
        });


    }

    private void CarregarTelaImagens() {

        setContentView(R.layout.imagens);

        btnFerrari = findViewById(R.id.btnFerrari);
        btnPorsche = findViewById(R.id.btnPorsche);
        imgPorsche = findViewById(R.id.imgPorsche);
        imgFerrari = findViewById(R.id.imgFerrari);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnFerrari.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                setContentView(R.layout.ferrari);
                CarregarTelaFerrari();

            }
        });

        btnPorsche.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                setContentView(R.layout.porsche);
                CarregarTelaPorsche();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
            }
        });
    }

    private void CarregarTelaPorsche() {

        setContentView(R.layout.porsche);

        rbtV12 = findViewById(R.id.rbtV12);
        rbtV6 = findViewById(R.id.rbtV6);
        rbPorsche = findViewById(R.id.rbPorsche);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        imgPorsche = findViewById(R.id.imgPorsche);
        chkSom = findViewById(R.id.chkSom);
        chkGPS = findViewById(R.id.chkGPS);

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int op = rbPorsche.getCheckedRadioButtonId();

                if (op == R.id.rbtV6) {
                    escolha += "\nMotor V6";
                }
                if (op == R.id.rbtV12) {
                    escolha += "\nMotor V12";
                }
                if (chkGPS.isChecked()) {
                    escolha += "\nGPS Garmin";
                }
                if (chkSom.isChecked()) {
                    escolha += "\nSom JBL";
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Opcionais escolhidos:");
                alert.setMessage(escolha);
                alert.setNeutralButton("Fechar", null);
                alert.show();

                escolha = "";

                setContentView(R.layout.activity_main);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
            }
        });


    }

    private void CarregarTelaFerrari() {
        setContentView(R.layout.ferrari);

        rbtV12 = findViewById(R.id.rbtV12);
        rbtV6 = findViewById(R.id.rbtV6);
        rbFerrari = findViewById(R.id.rbFerrari);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnVoltar = findViewById(R.id.btnVoltar);
        imgFerrari = findViewById(R.id.imgFerrari);
        chkSom = findViewById(R.id.chkSom);
        chkGPS = findViewById(R.id.chkGPS);



        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int op = rbFerrari.getCheckedRadioButtonId();

                if(op == R.id.rbtV6)
                {
                    escolha += "Motor V6";
                }
                if(op == R.id.rbtV12)
                {
                    escolha += "Motor V12";
                }
                if(chkGPS.isChecked())
                {
                    escolha += "\nGPS Garmin";
                }
                if(chkSom.isChecked())
                {
                    escolha += "\nSom JBL";
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Opcionais escolhidos:");
                alert.setMessage(escolha);
                alert.setNeutralButton("Fechar",null);
                alert.show();

                escolha = "";

                setContentView(R.layout.activity_main);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
            }
        });

    }


}