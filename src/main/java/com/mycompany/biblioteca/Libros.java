/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

/**
 *
 * @author Estudiante
 */
public class Libros extends Biblioteca {
    
    private int año;
    private int numPaginas;
    
    public Libros(){
   
    }
    
    public Libros(String x, String y, String z, int a, int b, int c){
        super(x, y, z, a);
        this.año = b;
        this.numPaginas = c;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    
    @Override
     public void consultar(){
        System.out.println("ISBN: "+super.getIsbn()+" | TITULO: "+super.getTitulo()+" | AUTOR: "+super.getAutor()+" | AÑO :"+this.getAño()+" | NUMERO DE PAGINAS : "+this.getNumPaginas()+" | DISPONIBILIDAD: "+super.getNumEjemplares());
    }
}
