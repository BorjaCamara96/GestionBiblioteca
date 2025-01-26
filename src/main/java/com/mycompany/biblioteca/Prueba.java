/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Borja
 */
public class Prueba {

    public static ArrayList<Biblioteca> articulos = new ArrayList<Biblioteca>();
    public static ArrayList<Socios> socio = new ArrayList<Socios>();
    public static ArrayList<Interacciones> accion = new ArrayList<Interacciones>();
    
    public static void main(String[] args) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        articulos.add(new Libros("9788418027956", "Los sellos oscuros", "Anna Benning", 20, 2024, 440));
        articulos.add(new Libros("9780605024519", "El ladron del rayo", "Rick Riordan", 12, 2005, 288));
        articulos.add(new Libros("9788466129350", "Donde los árboles cantan", "Laura Gallego García", 21, 2013, 477));
        articulos.add(new Libros("9788419228420", "Mi lugar bajo el sol", "Rubén Álvarez", 12, 2022, 432));
        articulos.add(new Libros("9788498890532", "Tiempo de odio", "Andrzej Sapkowski", 5, 2010, 272));
        
        articulos.add(new Dvd("B003Z7SIHM", "Piratas del Caribe: La maldición de la Perla Negra", "Disney", 10, "Español", 143));
        articulos.add(new Dvd("B0CXMF25FV", "Pobres Criaturas", "Film4 Productions", 3, "Ingles", 141));
        articulos.add(new Dvd("B0C61VPMRZ", "Avatar: El Sentido del Agua", "	20th Century Studios", 5, "Español, Ingles", 192));
        articulos.add(new Dvd("B07RB4Q5TF", "Vengadores: Endgame", "Marvel Studios", 6, "Español", 181));
        articulos.add(new Dvd("B006ZVOM0M", "El Origen Del Planeta De Los Simios", "20th Century Fox", 7, "Ingles", 104));
        
        articulos.add(new Revistas("63728223", "MARCA", "Unidad Editorial", new SimpleDateFormat ("dd/MM/yyyy").parse("12/03/2024")));
        articulos.add(new Revistas("67480936", "Muy interesante","Zinet Media Global",new SimpleDateFormat ("dd/MM/yyyy").parse("04/03/2022")));
        articulos.add(new Revistas("76849892", "Viajes", "National Geographic", new SimpleDateFormat ("dd/MM/yyyy").parse("26/07/2023")));
        articulos.add(new Revistas("57483989", "Auto Bild", "Axel Springer AG", new SimpleDateFormat ("dd/MM/yyyy").parse("08/01/2020")));
        articulos.add(new Revistas("68474958", "FORBES", "Steve Forbes", new SimpleDateFormat ("dd/MM/yyyy").parse("27/03/2022")));
        
        int control = 0, codigoSocio = 0;
        int codSocio, positionArticulo, positionAccion;
        String isbn;
        boolean comprobador;
        do{
            try{
                System.out.println("""
                                   \nIntroduce una opcion.
                                   1) Ver Stock disponible.
                                   2) Crear un usuario.
                                   3) Socios dados de alta.
                                   4) Prestacion de articulo.
                                   5) Devolucion de articulo.
                                   6) Ver historico de interacciones.
                                   0) Salir de aplicacion.
                                   """);
                int opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("\nSTOCK DE ARTICULOS DISPONIBLES:\n");
                        for(Biblioteca articulo : articulos){
                            System.out.print((articulos.indexOf(articulo))+") - ");                    
                            articulo.consultar();
                            System.out.println();
                        }
                        break;
                    case 2:
                        System.out.println("\nIntroduce nombre de socio:");
                        String nombreSocio = sc.next();
                        socio.add(new Socios(codigoSocio, nombreSocio));
                        codigoSocio++;
                        break;
                    case 3:
                        System.out.println("Nº SOCIO | NOMBRE | PRESTAMOS PENDIENTES");
                        for(Socios socio1 : socio){
                            System.out.println(socio.indexOf(socio1)+") "+socio1.getNombreSocio()+" - "+socio1.getNumPrestamos());
                        }
                        break;
                    case 4:
                        positionArticulo = 0;
                        comprobador = false;
                        System.out.println("\nIntroduce codigo de socio:");
                        codSocio = sc.nextInt();
                        for(Socios socio1 : socio){
                            if(codSocio == socio1.getCodigoSocio())
                                comprobador = true;
                        }
                        if(comprobador == false){
                            System.out.println("El socio introducido no esta de alta.");
                            break;
                        }
                        comprobador = false;
                        System.out.println("\nIntroduce ISBN de articulo:");
                        isbn = sc.next();
                        for(Biblioteca articulo : articulos){
                            if(isbn.equals(articulo.getIsbn())){
                                positionArticulo = articulos.indexOf(articulo);
                                comprobador = true;
                                break;
                            }
                        }
                        if(comprobador == false){
                            System.out.println("El ISBN introducido no existe.");
                            break;
                        }
                        Interacciones interaccion1 = new Interacciones();
                        if(interaccion1.comprobarPrestamo(socio.get(codSocio), articulos.get(positionArticulo)) == true){
                            interaccion1.prestamo(socio.get(codSocio), articulos.get(positionArticulo));
                            accion.add(interaccion1);  
                            System.out.println("Prestamo realizado.");
                        }
                        break;
                    case 5:
                        positionArticulo = 0;
                        positionAccion = 0;
                        comprobador = false;
                        System.out.println("\nIntroduce codigo de socio:");
                        codSocio = sc.nextInt();
                        System.out.println("""
                                           PRESTAMOS PENDIENTES.
                                           Nº SOCIO | NOMBRE | ISBN | TITULO | AUTOR | FECHA | ESTADO
                                           """);
                        for(Interacciones accion1 : accion){
                            if(accion1.getNumeroSocio() == codSocio && "PENDIENTE".equals(accion1.getEstado())){
                                System.out.println(accion1.getNumeroSocio()+" | "+accion1.getNombre()+" | "+accion1.getIsbn()+" | "+
                                        accion1.getTitulo()+" | "+accion1.getAutor()+" | "+accion1.getFecha()+" | "+accion1.getEstado());
                            }
                        }
                        System.out.println("\nIntroduce ISBN de articulo:");
                        isbn = sc.next();
                        for(Biblioteca articulo : articulos){
                            if(isbn.equals(articulo.getIsbn())){
                                positionArticulo = articulos.indexOf(articulo);
                                comprobador = true;
                                break;
                            }
                        }
                        if(comprobador == false){
                            System.out.println("El ISBN introducido no existe.");
                            break;
                        }
                        comprobador = false;
                        for(Interacciones accion1 : accion){
                            if("PENDIENTE".equals(accion1.getEstado())){
                                if(codSocio == accion1.getNumeroSocio() && isbn.equals(accion1.getIsbn())){
                                    comprobador = true;
                                    positionAccion = accion.indexOf(accion1);
                                    break;
                                }
                            }
                        }
                        if(comprobador == false){
                            System.out.println("El socio no ha codigo en prestamo el articulo indicado.");
                            break;
                        }
                        Interacciones interaccion2 = new Interacciones();
                        if(interaccion2.comprobarDevolucion(socio.get(codSocio), articulos.get(positionArticulo)) == true){
                            interaccion2.devolucion(socio.get(codSocio), articulos.get(positionArticulo));
                            accion.add(interaccion2); 
                            accion.get(positionAccion).setEstado("DEVOLUCION COMPLETADA");
                            System.out.println("Devolucion realizada.");
                        }
                        break;
                    case 6:
                        System.out.println("\nNº | ACCION | Nº SOCIO | NOMBRE SOCIO | ISBN | TITULO | AUTOR | FECHA INTERACCION | ESTADO ACTUAL \n");
                        for(Interacciones accion1 : accion){
                            System.out.println(accion.indexOf(accion1)+") "+accion1.getAccion()+" | "+accion1.getNumeroSocio()+" | "+accion1.getNombre()+
                                    " | "+accion1.getIsbn()+" | "+accion1.getTitulo()+" | "+accion1.getAutor()+
                                    " | "+accion1.getFecha().format(formatter)+" | "+accion1.getEstado());
                        }
                        break;
                    case 0:
                        control = 1;
                        break;
                    default:
                        System.out.println("Ha introducido un valor fuera de rango.");
                }
            }
            catch(Exception e){
                System.out.println("Ha introducido un valor no valido.");
                sc.nextLine();
            }
        } while (control == 0);
    }
}
