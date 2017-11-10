package com.plama.horoscopochino;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class Ayuda extends AppCompatActivity {
    ArrayList<Personas> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        if (getIntent().getSerializableExtra("Lista")!=null){
            lista=((ArrayList<Personas>) getIntent().getSerializableExtra("Lista"));
        }
        else{
            lista=new ArrayList<Personas>();
        }

    }

    public void ayudaayuda(View view) {
        Intent intent = new Intent(Ayuda.this, Inicio.class);
        intent.putExtra("Lista", lista);
        startActivity(intent);
    }
}
