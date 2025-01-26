/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

/**
 *
 * @author Estudiante
 */
public class Dvd extends Biblioteca{

    private String idioma;
    private double duracion;

    public Dvd(){
    }
    public Dvd(String x, String y, String z, int a, String b, double c){
        super(x, y, z, a);
        this.idioma = b;
        this.duracion = c;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    
    @Override
    public void consultar(){
        System.out.println("ISBN: "+super.getIsbn()+" | TITULO: "+super.getTitulo()+" | AUTOR: "+super.getAutor()+" | IDIOMA :"+this.getIdioma()+" | DURACIÓN : "+this.getDuracion()+" | DISPONIBILIDAD: "+super.getNumEjemplares());
    }
}
