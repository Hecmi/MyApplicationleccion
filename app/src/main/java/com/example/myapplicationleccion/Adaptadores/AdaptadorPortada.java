package com.example.myapplicationleccion.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.myapplicationleccion.Modelos.Portada;
import com.example.myapplicationleccion.R;

import java.util.ArrayList;

public class AdaptadorPortada extends ArrayAdapter<Portada> {
    public AdaptadorPortada(Context context, ArrayList<Portada> datos) {
        super(context, R.layout.lyportada, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyportada, null);
        TextView Categoria= (TextView)item.findViewById(R.id.txtCategoria);Categoria.setText(getItem(position).getCategoria());
        TextView titulo = (TextView)item.findViewById(R.id.txtTtiulo); titulo.setText(getItem(position).getTitulo());
        TextView preci = (TextView)item.findViewById(R.id.txtPrice);preci.setText(getItem(position).getPrecio());
        TextView descripcion = (TextView)item.findViewById(R.id.txtDescription);descripcion.setText(getItem(position).getDescripcion());

        ImageView imageView = (ImageView)item.findViewById(R.id.imagePortada);
        Glide.with(this.getContext())
                .load(getItem(position).getPortada())
                .into(imageView);
        return(item);
    }
}
