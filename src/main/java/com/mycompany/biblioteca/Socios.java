/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

/**
 *
 * @author Borja
 */
public class Socios {
    
    private int codigoSocio;
    private String nombreSocio;
    private int numPrestamos = 0;
    
    public Socios(){
    }
    
    public Socios(int x, String y){
        this.codigoSocio = x;
        this.nombreSocio = y;
    }

    public int getCodigoSocio() {
        return this.codigoSocio;
    }

    public void setCodigoSocio(int x) {
        this.codigoSocio = x;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String x) {
        this.nombreSocio = x;
    }

    public int getNumPrestamos() {
        return numPrestamos;
    }

    public void setNumPrestamos(int x) {
        this.numPrestamos = x;
    }
    
    public void prestamoSocio(){
        this.numPrestamos++;
    }
    
    public void devolucionSocio(){
        this.numPrestamos--;
    }
}
