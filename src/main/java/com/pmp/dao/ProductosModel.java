/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.dao;

import java.sql.Connection;
import java.sql.Statement;
/**
 *
 * @author obetancourth
 */
public class ProductosModel {
    /*
    private String _sku;
    private String _nombre;
    private double _precio;
    private int    _cantidad;
    private String _observacion;
    private int    _id;
    */
    private Connection _conexion = null;
    
    public ProductosModel(){
        _conexion = Conexion.getConexion();
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS productos"
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " nombre TEXT NOT NULL,"
                + " sku TEXT NOT NULL,"
                + " precio DECIMAL(10,2),"
                + " cantidad NUMERIC,"
                + " observacion TEXT);";
        
        try{
            Statement comando = _conexion.createStatement();
            int resultado = comando.executeUpdate(sqlCreateTable);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
