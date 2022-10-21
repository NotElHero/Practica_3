package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView contador;
    Button botonMas, botonMenos, botonColorTexto, botonColorFondo;
    Switch switchx2, switchMenos0;
    int cont = 0;

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

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botonMas:
                cont++;
                contador.setText(String.valueOf(cont));
                break;
            case R.id.botonMenos:
                cont--;
                contador.setText(String.valueOf(cont));
                break;
            case R.id.botonColorTexto:

                break;
        }
    }
}