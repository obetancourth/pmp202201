/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.pmp221productos;

import java.util.Scanner;
/**
 *
 * @author obetancourth
 */
public class UIUtilidades {
    public static void separador(){
        System.out.println(new String(new char[80]).replace("\0", "-"));
    }
    public static void print(String text){
        System.out.println(text);
    }
    public static void encabezado(String text) {
        separador();
        print(text);
        separador();
    }
    public static void menu (){
        String menu = "L Lista\t | I Insertar\t | A Editar\t | E Eliminar\t | D Detalle\t | S Salir";
        separador();
        print(menu);
    }
    
    public static String capturarCampo(Scanner entradaTeclado, String leyenda, String valorPredeterminado ) {
        print(leyenda + "(" + valorPredeterminado + ") :");
        String input = entradaTeclado.nextLine();
        if(input.isEmpty()) {
            return valorPredeterminado;
        }
        return input;
    }
    public static void printEncabezadoTabla () {
        separador();
        print(String.format("%s\t%s\t%s\t%s", "ID", "SKU", "PRODUCTO", "PRECIO"));
        separador();
    }
}
