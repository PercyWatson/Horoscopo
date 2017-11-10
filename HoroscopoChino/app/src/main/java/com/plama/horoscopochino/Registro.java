package com.plama.horoscopochino;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {

    ArrayList<Personas> lista;

    EditText usuario, contra1 , contra2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        if (getIntent().getSerializableExtra("Lista")!=null){
            lista=((ArrayList<Personas>) getIntent().getSerializableExtra("Lista"));
        }
        else{
            lista=new ArrayList<Personas>();
        }
    }

    public void ayudaregistro(View view) {
        Intent intent = new Intent(Registro.this, Ayuda.class);
        intent.putExtra("Lista", lista);
        startActivity(intent);
    }

    public void registrarseregistro(View view) {
        usuario = (EditText) findViewById(R.id.txtfieldusuarioregistro);
        String name = usuario.getText().toString().trim();

        contra1 = (EditText) findViewById(R.id.txtfieldpasswd);
        String contras1 = contra1.getText().toString().trim();
        contra2 = (EditText) findViewById(R.id.txtfieldpasswd2);
        String contras2 = contra2.getText().toString().trim();
        Personas p = new Personas(name, contras1);
        if (name.equals("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Debe ingresar un nombre", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            if (contras1.equals("")){
                Toast toast = Toast.makeText(getApplicationContext(), "Debe ingresar una contraseña", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                if (contras2.equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(), "Debe ingresar una contraseña", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    if (contras1.equals(contras2)){

                        int listita = lista.size();
                        if (listita==0){

                            lista.add(p);

                            Toast toast = Toast.makeText(getApplicationContext(), "Primer Usuario Registrado con exito", Toast.LENGTH_SHORT);
                            toast.show();

                        }
                        else{
                            int error = 0;
                            int al = lista.size();
                            for (int i = 0; i<al; i++){
                                String nombresito=lista.get(i).getNombre();
                                if (name.equals(nombresito)){
                                    error=1;
                                }
                            }
                            if (error==1){
                                Toast toast = Toast.makeText(getApplicationContext(), "El usuario ya esta registrado: "+name, Toast.LENGTH_SHORT);
                                toast.show();
                            }
                            else{
                                Personas a = new Personas(name, contras1);
                                lista.add(a);
                                Toast toast = Toast.makeText(getApplicationContext(), "Registrado con exito", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }

                    }
                    else{
                        Toast toast = Toast.makeText(getApplicationContext(), "Las contraseñas no son iguales", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        }


    }

    public void volverregistro(View view) {
        Intent intent = new Intent(this, Inicio.class);
        intent.putExtra("Lista", lista);
        startActivity(intent);
    }
}
