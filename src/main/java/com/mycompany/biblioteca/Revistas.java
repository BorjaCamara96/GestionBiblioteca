/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Borja
 */
public class Revistas extends Biblioteca{
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    private Date fechaPublicacion;

    public Revistas(){
    }
    
    public Revistas(String x, String y, String z, Date a){
        super(x, y, z);
        super.revista = true;
        this.fechaPublicacion = a;
    }
    
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date x) {
        this.fechaPublicacion = x;
    }  
    
    @Override
    public void consultar(){
        System.out.println("ISBN: "+super.getIsbn()+" | TITULO: "+super.getTitulo()+" | AUTOR: "+super.getAutor()+" | FECHA PUBLICACION: "+sdf.format(this.getFechaPublicacion()));
    }
    
}
