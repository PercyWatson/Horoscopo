package com.plama.horoscopochino;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    ArrayList<Personas> lista;
    EditText usuario, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getIntent().getSerializableExtra("Lista")!=null){
            lista=((ArrayList<Personas>) getIntent().getSerializableExtra("Lista"));
        }
        else{
            lista=new ArrayList<Personas>();
        }

    }

    public void volverlogeo(View view) {
        Intent intent = new Intent(Login.this, Inicio.class);
        intent.putExtra("Lista", lista);
        startActivity(intent);
    }

    public void registrologeo(View view) {
        Intent intent = new Intent(Login.this, Registro.class);
        intent.putExtra("Lista", lista);
        startActivity(intent);
    }

    public void ayudalogeo(View view) {
        Intent intent = new Intent(Login.this, Ayuda.class);
        intent.putExtra("Lista", lista);
        startActivity(intent);
    }

    public void loginlogeo(View view) {
        usuario = (EditText) findViewById(R.id.txtfieldusuario);
        String name = usuario.getText().toString().trim();
        password = (EditText) findViewById(R.id.txtfieldpassword);
        String pass = password.getText().toString().trim();

        if (name.equals("")){
            Toast toast = Toast.makeText(getApplicationContext(), "Debe ingresar un nombre de usuario", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            if (pass.equals("")){
                Toast toast = Toast.makeText(getApplicationContext(), "Debe ingresar una contraseña", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                if (lista.isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "No existen usuarios registrados", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                    {

                        int error = 0;
                        int al = lista.size();
                        for (int i = 0; i<al; i++){
                            String nombresito=lista.get(i).getNombre();
                            String contrase=lista.get(i).getContrasena();
                            if (name.equals(nombresito)){
                                if (pass.equals(contrase)){
                                    error=1;
                                }
                                else{
                                    error=2;
                                }
                            }
                        }
                        switch (error){
                            case 0:
                                Toast toast = Toast.makeText(getApplicationContext(), "No existe el usuario: "+name, Toast.LENGTH_SHORT);
                                toast.show();
                                break;
                            case 1:
                                toast = Toast.makeText(getApplicationContext(), "Bienvenido: "+name, Toast.LENGTH_SHORT);
                                toast.show();
                                Intent intent = new Intent(Login.this, Fecha.class);
                                intent.putExtra("Lista", lista);
                                startActivity(intent);
                                break;
                            case 2:
                                 toast = Toast.makeText(getApplicationContext(), "Contraseña incorreta!", Toast.LENGTH_SHORT);
                                toast.show();
                                break;
                        }

                    }
                }
            }
        }
}
