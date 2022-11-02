package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView contador;
    EditText meta;
    Button botonMas, botonMenos, botonColorTexto, botonColorFondo;
    Switch switchx2, switchMenos0;
    int cont = 0;
    int defaultColorFondo, defaultColorTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonMas = findViewById(R.id.botonMas);
        botonMas.setOnClickListener(this);
        botonMenos = findViewById(R.id.botonMenos);
        botonMenos.setOnClickListener(this);
        botonColorFondo = findViewById(R.id.botonColorFondo);
        botonColorFondo.setOnClickListener(this);
        botonColorTexto = findViewById(R.id.botonColorTexto);
        botonColorTexto.setOnClickListener(this);

        contador = findViewById(R.id.textViewContador);

        switchx2 = findViewById(R.id.switchX2);
        switchMenos0 = findViewById(R.id.switchMenos0);

        defaultColorFondo = ContextCompat.getColor(MainActivity.this, com.google.android.material.R.color.design_default_color_primary);
        defaultColorTexto = ContextCompat.getColor(MainActivity.this, com.google.android.material.R.color.design_default_color_primary);

        meta = findViewById(R.id.editTextNumber);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botonMas:
                if (switchx2.isChecked()){
                    cont+=2;
                }else if (switchMenos0.isChecked() && cont < 0){
                    cont = 0;
                    cont++;
                }else{
                    cont++;
                }
                contador.setText(String.valueOf(cont));
                break;
            case R.id.botonMenos:
                if (switchx2.isChecked()){
                    cont-=2;
                }else{
                    cont--;
                }
                if (switchMenos0.isChecked() && cont < 0){
                    cont = 0;
                }
                contador.setText(String.valueOf(cont));
                break;
            case R.id.botonColorFondo:
                escogerColorFondo();
                break;
            case R.id.botonColorTexto:
                escogerColorTexto();
                break;
        }
        //TODO:
        //- que pille el numero del edittext y lo ponga como meta
        //- lo del bundle
        //- si eso alguna movida extra, pero lo mismo no, para no entregarlo dentro de 200 años

    }

    public void escogerColorFondo() {
        AmbilWarnaDialog selector = new AmbilWarnaDialog(this, defaultColorFondo, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                defaultColorFondo = color;
                contador.setBackgroundColor(defaultColorFondo);
            }
        });
        selector.show();
    }

    public void escogerColorTexto(){
        AmbilWarnaDialog selector2 = new AmbilWarnaDialog(this, defaultColorTexto, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                defaultColorTexto = color;
                contador.setTextColor(defaultColorTexto);
            }
        });
        selector2.show();
    }
}