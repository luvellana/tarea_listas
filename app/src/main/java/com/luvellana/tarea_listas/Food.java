package com.luvellana.tarea_listas;

import com.google.gson.annotations.Expose;

public class Food {

    @Expose
    private int id;


    @Expose
    private int coverImage;

    @Expose
    private String nombrePlato;

    @Expose
    private double precio;


    public Food(int id, int coverImage, String nombrePlato, int precio) {
        this.id = id;
        this.coverImage = coverImage;
        this.nombrePlato = nombrePlato;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }


    public int getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(int coverImage) {
        this.coverImage = coverImage;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public double getPrecio() { return precio;}

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
