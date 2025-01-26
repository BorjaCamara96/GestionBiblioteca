/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.biblioteca;

/**
 *
 * @author Estudiante
 */
public class Biblioteca {

    protected String isbn;
    protected String titulo;
    protected String autor;
    protected int numEjemplares;
    protected boolean revista = false;
    
    public Biblioteca(){
    }
    public Biblioteca(String x, String y, String z, int a){
        this.isbn = x;
        this.titulo = y;
        this.autor = z;
        this.numEjemplares = a;
    }
    
    public Biblioteca(String x, String y, String z){
        this.isbn = x;
        this.titulo = y;
        this.autor = z;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String x) {
        this.isbn = x;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String x) {
        this.titulo = x;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String x) {
        this.autor = x;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int x) {
        this.numEjemplares = x;
    }
    
    public boolean getRevista(){
        return this.revista;
    }
    
    public void setRevista(boolean x){
        this.revista = x;
    }
    
    public void consultar(){
        System.out.println("ISBN: "+this.getIsbn()+" | TITULO: "+this.getTitulo()+" | AUTOR: "+this.getAutor()+" | DISPONIBILIDAD: "+this.getNumEjemplares());
    }
    public void prestamoArticulo(){
        this.numEjemplares--;
    }
    public void devolucionArticulo(){
        this.numEjemplares++;
    }
}
