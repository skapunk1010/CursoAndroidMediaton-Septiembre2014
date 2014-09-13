package com.example.corruptusinextremis.practica05_listview;

import java.io.Serializable;

public class Item implements Serializable{
    private int idImagen;
    private String titulo;
    private String descripcion;
    private boolean check;

    public Item(String titulo, String d, boolean check,int idImagen){
        this.titulo = titulo;
        this.descripcion = d;
        this.idImagen = idImagen;
        this.check = check;
    }

    public int getIdImage(){
        return this.idImagen;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public boolean isCheck(){
        return check;
    }

    public void setChecked(boolean check){
        this.check = check;
    }

}