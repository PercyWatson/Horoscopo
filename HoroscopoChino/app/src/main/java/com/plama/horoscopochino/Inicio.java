package com.plama.horoscopochino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Inicio extends AppCompatActivity {
    ArrayList<Personas> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        if (getIntent().getSerializableExtra("Lista")!=null){
            lista=((ArrayList<Personas>) getIntent().getSerializableExtra("Lista"));
        }
        else{
            lista=new ArrayList<Personas>();
        }

    }

    public void logini(View view) {

        Intent intent = new Intent(Inicio.this, Login.class);
        intent.putExtra("Lista", lista);
        startActivity(intent);
    }


    public void registro(View view) {

        Intent intent = new Intent(Inicio.this, Registro.class);
        intent.putExtra("Lista", lista);
        startActivity(intent);
    }

    public void ayuda(View view) {
        Intent intent = new Intent(Inicio.this, Ayuda.class);
        intent.putExtra("Lista", lista);
        startActivity(intent);
    }
}
