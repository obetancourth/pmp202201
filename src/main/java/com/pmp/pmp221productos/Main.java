/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.pmp221productos;

import java.util.Scanner;
import java.lang.Math;

import com.pmp.dao.Producto;
import com.pmp.dao.ProductosModel;
/**
 *
 * @author obetancourth
 */
public class Main {
    private static Scanner entradaTeclado = new Scanner(System.in);
    private static ProductosModel model = new ProductosModel();
    public static void main ( String[] args ) {
        // guessTheNumber();
        UIUtilidades.encabezado("Gestión de Productos");
        String menuOption = "L";
        while (!menuOption.contentEquals("S")){
            switch (menuOption) {
                case "L":
                    UIUtilidades.print("Listado");
                    break;
                case "I":
                    // UIUtilidades.print("Insertar Nuevo");
                    insertarUnProducto();
                    break;
                case "A":
                    UIUtilidades.print("Actualizar");
                    break;
                case "E":
                    UIUtilidades.print("Eliminar");
                    break;
                case "D":
                    UIUtilidades.print("Mostrar Detalle");
                    break;
                default:
                    UIUtilidades.print("Opción no encontrada!!!");
            }
            UIUtilidades.menu();
            menuOption = entradaTeclado.nextLine().toUpperCase();
        }
    }
    
    private static void insertarUnProducto() {
        Producto nuevoProducto = new Producto();
        UIUtilidades.encabezado("Nuevo Producto");
        nuevoProducto.setSku(UIUtilidades.capturarCampo(entradaTeclado, "SKU", "PRD001"));
        nuevoProducto.setNombre(UIUtilidades.capturarCampo(entradaTeclado, "Nombre", "Producto XYZ"));
        nuevoProducto.setPrecio(Double.parseDouble(UIUtilidades.capturarCampo(entradaTeclado, "Precio", "100.00")));
        nuevoProducto.setCantidad(Integer.parseInt(UIUtilidades.capturarCampo(entradaTeclado, "Cantidad", "10")));
        nuevoProducto.setObservacion(UIUtilidades.capturarCampo(entradaTeclado, "Observación", ""));
        UIUtilidades.separador();
    }
    
    private static boolean guessTheNumber() {
        double numeroAAdivinar = Math.ceil(Math.random() * 100);
        int intentos = 0; 
        
        while (intentos < 5) {
            System.out.println("Ingrese un número entre 1 y 100:");
            double numeroIngresado = Double.parseDouble(entradaTeclado.nextLine());
            if (numeroIngresado > 0 && numeroIngresado <= 100) {
                if (numeroIngresado == numeroAAdivinar) {
                    System.out.println("Eureka ha adivinado el número secreto!");
                    return true;
                } else {
                    if (numeroIngresado > numeroAAdivinar) {
                        System.out.println("El número es menor.");
                    } else {
                        System.out.println("El número es mayor");
                    }
                    intentos ++;
                }
            } else {
                System.out.println("No es un número válido.");
            }
        }
        
        //if (intentos == 5 ){
            System.out.println("Ha perdido, no logró adivinar el número.");
            return false;
        //}
        
        
        /*
        Ejercicio
        El programa generara un numero aleatorio entre 1 y 100
        El programa solicitara que se ingrese un numero
           Validar si el numero ingresado esta en el rango correcto 1 - 100
           Determinar si el número ingresado es mayor al número aleatorio
           Determinar si el número ingresado en menor al número aleatorio
           Determinar si es el quinto intento
           Determinar si adivino el número
        */
        
    }
}
