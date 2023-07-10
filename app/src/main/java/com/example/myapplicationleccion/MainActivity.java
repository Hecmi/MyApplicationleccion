package com.example.myapplicationleccion;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplicationleccion.Adaptadores.AdaptadorPortada;
import com.example.myapplicationleccion.Modelos.Portada;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask, AdapterView.OnItemClickListener {
    ListView LstOpciones;
    Object position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LstOpciones = (ListView) findViewById(R.id.ListaUsuario);
        View header = getLayoutInflater().inflate(R.layout.lyheder, null);
        LstOpciones.addHeaderView(header);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://fakestoreapi.com/products",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
        LstOpciones.setOnItemClickListener(this);

    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray jsonArray = new JSONArray(result);
        ArrayList<Portada> lstProductos = Portada.JsonObjectsBuild(jsonArray);
        AdaptadorPortada adaptadorPortada = new AdaptadorPortada(this,lstProductos);
        LstOpciones.setAdapter(adaptadorPortada);

    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Portada revista = (Portada) adapterView.getItemAtPosition(position);
        if (position == 1) {
            int a = 3;
            Bundle b = new Bundle();
            b.putInt("ID", a);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtras(b);
            startActivity(intent);
        } else if (position == 2) {
            int d = 2;
            Bundle b = new Bundle();
            b.putInt("ID", d);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtras(b);
            startActivity(intent);
        } else if (position == 3) {
            int c = 1;
            Bundle b = new Bundle();
            b.putInt("ID", c);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtras(b);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
        }
    }


   public void Enviar(View view) {

      TextView categoria= findViewById(R.id.txtCategoria);
       TextView titulo= findViewById(R.id.txtTtiulo);
       TextView precio = findViewById(R.id.txtPrice);
       TextView descripcion= findViewById(R.id.txtDescription);
      ImageView portada= findViewById(R.id.imagePortada);
      String Categoria, Titulo, Prtecio,Descripcion;

        Categoria=categoria.getText().toString();
        Titulo=titulo.getText().toString();
     Prtecio=precio.getText().toString();
       Descripcion=descripcion.getText().toString();

      Intent intent= new Intent(MainActivity.this,MainActivity2.class);

       Bundle b = new Bundle();

       b.putString("category" ,Categoria);
      b.putString("title", Titulo);
      b.putString("price" , Prtecio);
       b.putString("image", Descripcion);

      intent.putExtras(b);
    startActivity(intent);

    }
}




