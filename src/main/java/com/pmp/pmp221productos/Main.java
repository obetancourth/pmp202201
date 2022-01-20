/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.pmp221productos;

import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author obetancourth
 */
public class Main {
    private static Scanner entradaTeclado = new Scanner(System.in);;
    
    public static void main ( String[] args ) {
        // entradaTeclado = new Scanner(System.in);
        // System.out.println("Hola Mundo!!!");
        // System.out.println("Escriba su nombre");
        // String nombre = entradaTeclado.nextLine();
        // System.out.println("Hola " + nombre);
        guessTheNumber();
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
