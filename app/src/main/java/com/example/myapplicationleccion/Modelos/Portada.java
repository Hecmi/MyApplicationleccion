package com.example.myapplicationleccion.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Portada {
    private String categoria;
    private String titulo;
    private String precio;
    private String descripcion;
    private String portada;


    public Portada(JSONObject a) throws JSONException {
        categoria = a.getString("category").toString();
        titulo = a.getString("title").toString() ;
        precio = a.getString("price").toString() ;
       descripcion = a.getString("description").toString() ;
       portada= a.getString("image").toString();
    }
    public static ArrayList<Portada> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Portada> usuarios = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            usuarios.add(new Portada(datos.getJSONObject(i)));
        }
        return usuarios;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;

    }
    public String getPortada() {
        return portada;
    }

    public void setportada(String descripcion) {
        this.descripcion = portada;
    }
}
