package com.example.myapplicationleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplicationleccion.Adaptadores.AdaptadorPortada;
import com.example.myapplicationleccion.Modelos.Portada;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import WebService.Asynchtask;

public class MainActivity2 extends AppCompatActivity implements Asynchtask {

    ListView Lstlibros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView Portada = (TextView)findViewById(R.id.resultado);
        Bundle bundle =this.getIntent().getExtras();
        Portada.setText("categoria  "+bundle.getString("category") + "\n"  + " titulo " + bundle.getString("title" )+ "\n"
                + " precio "+ bundle.getString("price")+ "\n"
                +  " descripcion"+ bundle.getString("description"));
    }
        public void processFinish(String result) throws JSONException {
            JSONArray jsonArray = new JSONArray(result);
            ArrayList<Portada> lstUsuarios = Portada.JsonObjectsBuild(jsonArray);
            AdaptadorPortada  adaptadorPortada = new AdaptadorPortada(this, lstUsuarios);
            Lstlibros.setAdapter(adaptadorPortada);

        }
    }