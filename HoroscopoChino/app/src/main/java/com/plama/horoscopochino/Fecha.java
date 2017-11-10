package com.plama.horoscopochino;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Fecha extends AppCompatActivity {
    ArrayList<Personas> lista;
    EditText et;
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha);
        if (getIntent().getSerializableExtra("Lista")!=null){
            lista=((ArrayList<Personas>) getIntent().getSerializableExtra("Lista"));
        }
        else{
            lista=new ArrayList<Personas>();
        }
    }

    public void ayudaaño(View view) {
        Intent intent = new Intent(Fecha.this, Ayuda.class);
        intent.putExtra("Lista", lista);
        startActivity(intent);
    }

    public void volveraño(View view) {
        Intent intent = new Intent(Fecha.this, Inicio.class);
        intent.putExtra("Lista", lista);
        startActivity(intent);
    }

    public void btncalcular(View view) {
        et = (EditText)findViewById(R.id.txtfielfecha);
        imagen=(ImageView)findViewById(R.id.imageView);
        TextView txtCambiado = (TextView)findViewById(R.id.txtresultado);

       String fecha = et.getText().toString();
       try{
           int numero = Integer.parseInt(fecha);
           if (numero<=0) {
               txtCambiado.setText("Ingrese un numero mayor a 0");
           }
           else {

               txtCambiado.setText("numero es: "+numero);
               switch (numero % 12) {
                   case 0:
                       imagen.setImageResource(R.drawable.flaite);
                       txtCambiado.setText("Mono: Los monos son inteligentes, inventivos, ingeniosos, entretenidos, pero también son peligrosos y se desaniman fácilmente.");
                       break;
                   case 1:
                       imagen.setImageResource(R.drawable.posho);
                       txtCambiado.setText("Gallo: Los gallos son valientes, trabajadores, inteligentes, arrogantes, irresponsables, egoístas y excéntricos.");
                       break;
                   case 2:
                       imagen.setImageResource(R.drawable.doge);
                       txtCambiado.setText("Perro: Los nacidos bajo este signo son honestos, tranquilos, inteligentes, generosos, tercos, leales y fieles a sus seres queridos. ");
                       break;
                   case 3:
                       imagen.setImageResource(R.drawable.pepa);
                       txtCambiado.setText("Jabali o Cerdo: Los cerdos son honestos, confiables, sinceros, tolerantes, tímidos, cariñosos, amables, impulsivos y de mal humor");
                       break;
                   case 4:
                       imagen.setImageResource(R.drawable.guaren);
                       txtCambiado.setText("Rata: Los nacidos bajo el signo de la Rata son imaginativos, encantadores y realmente generosos con la persona que aman. Sin embargo, tienen una tendencia a ser temperamentales y excesivamente críticos.");
                       break;
                   case 5:
                       imagen.setImageResource(R.drawable.wey);
                       txtCambiado.setText("Bufalo: Es un símbolo de individuos poderosos con personalidades inflexibles y obstinados. \n" +
                               "Los nacidos bajo el signo son líderes naturales, que por lo general tienen éxito cuando les da la oportunidad.\n");
                       break;
                   case 6:
                       imagen.setImageResource(R.drawable.gatito);
                       txtCambiado.setText("Tigre: Los nacidos bajo el signo del tigre son sensibles, agresivos, impredecibles, con encanto, emocionales, valientes y capaces de un gran amor. A menudo se arriesgan y tienen una vida sin preocupaciones. ");
                       break;
                   case 7:
                       imagen.setImageResource(R.drawable.wonejo);
                       txtCambiado.setText("Liebre, Conejo o Gato: Los nacidos bajo este signo son cariñosos, talentosos, serviciales, siempre agradables.\n" +
                               "Tienen una tendencia a ser demasiado sentimentales y superficiales y evitar el conflicto y la implicación emocional.\n");
                       break;
                   case 8:
                       imagen.setImageResource(R.drawable.pejelagarto);
                       txtCambiado.setText("Dragon: Las personas nacidas bajo este signo son consideradas como nobles, sabias y creativas, incluso muy sociables con todos y tolerantes, son comprensivos a los sentimientos con los demás.");
                       break;
                   case 9:
                       imagen.setImageResource(R.drawable.zkane);
                       txtCambiado.setText("Serpiente: Los nacidos bajo este signo suelen ser considerados inteligentes, apasionados, decididos, románticos y ricos en sabiduría y encanto.");
                       break;
                   case 10:
                       imagen.setImageResource(R.drawable.spirit);
                       txtCambiado.setText("Caballo: Por lo general, se consideran superiores a otros. Tienen una fuerte tendencia de egoísmo y de la astucia. Aventureros, científicos, poetas, políticos, son ocupaciones adecuadas para ellos.");
                       break;
                   case 11:
                       imagen.setImageResource(R.drawable.kaura);
                       txtCambiado.setText("Cabra: El signo indica una persona que es creativa, artística, apasionada, elegante, cariñosa, sincera, encantadora, pero pesimista, tímida, desorganizada y vulnerable");
                       break;

               }
           }
       }
       catch (NumberFormatException nfe){
           txtCambiado.setText("debe ingresar un numero");
       }
    }
}
