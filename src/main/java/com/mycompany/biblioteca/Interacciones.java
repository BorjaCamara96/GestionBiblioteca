/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

import java.time.LocalDate;

/**
 *
 * @author Borja
 */
public class Interacciones {
    private String [] acciones = {"PRESTAMO", "DEVOLUCION"};
    private String accion;
    private LocalDate fechaInteraccion;
    private String estado = "PENDIENTE";
    private Socios socio;
    private Biblioteca articulo;
    
    public Interacciones(){
    }
    
    public String getEstado(){
        return this.estado;
    }
    
    public void setEstado(String x){
        this.estado = x;
    }
    
    public String getAccion() {
        return accion;
    }

    public void setAccion(int x) {
        this.accion = this.acciones[x];
    }
    
    public LocalDate getFecha(){
        return this.fechaInteraccion;
    }
    
    public void setFecha(LocalDate x){
        this.fechaInteraccion = x;
    }
    public boolean comprobarPrestamo(Socios x, Biblioteca y){
        if(y.getRevista() == true){
            System.out.println("Las revistas no tienen seguimiento de prestamo");
            return false;
        }
        else if(y.getNumEjemplares() <= 1){
            System.out.println("No hay ejemplares disponibles del articulo seleccionado.");
            return false;
        }
        else if(x.getNumPrestamos() >=5){
            System.out.println("El socio ha superado el limite de prestamos.");
            return false;
        }        
        else{
            return true;
        }
    }
    public void prestamo(Socios x, Biblioteca y){
        this.accion = this.acciones[0];
        this.socio = x;
        this.socio.prestamoSocio();
        this.articulo = y;
        this.articulo.prestamoArticulo();
        this.fechaInteraccion = LocalDate.now();
    }
    public boolean comprobarDevolucion(Socios x, Biblioteca y){
        if(x.getNumPrestamos() < 1){
            System.out.println("El socio no tiene prestamos pendientes de devolver.");
            return false;
        }
        else{
            return true;
        }
    }
    
     public void devolucion(Socios x, Biblioteca y){
            this.accion = this.acciones[1];
            this.socio = x;
            this.socio.devolucionSocio();
            this.articulo = y;
            this.articulo.devolucionArticulo();
            this.fechaInteraccion = LocalDate.now();
            this.estado = "DEVOLUCION";
    }
    public String getNombre(){
        return this.socio.getNombreSocio();
    }
    
    public int getNumeroSocio(){
        return this.socio.getCodigoSocio();
    }
    
    public String getIsbn(){
        return this.articulo.getIsbn();
    }
    
    public String getTitulo(){
        return this.articulo.getTitulo();
    }
    
    public String getAutor(){
        return this.articulo.getAutor();
    }
    
}
