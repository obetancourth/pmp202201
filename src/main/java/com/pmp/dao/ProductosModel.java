/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.ArrayList;

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
    
    public ArrayList<Producto> obtenerProductos () {
        try {
            ArrayList productos = new ArrayList<Producto>();
            Statement comandoSQL = _conexion.createStatement();
            ResultSet registroEnTabla = comandoSQL.executeQuery("SELECT * FROM productos;");
            while (registroEnTabla.next()) {
                Producto productoActual = new Producto();
                productoActual.setId( registroEnTabla.getInt("id") );
                productoActual.setNombre( registroEnTabla.getString("nombre"));
                productoActual.setSku(registroEnTabla.getString("sku"));
                productoActual.setObservacion( registroEnTabla.getString("observacion"));
                productoActual.setCantidad( registroEnTabla.getInt("cantidad"));
                productoActual.setPrecio( registroEnTabla.getDouble("precio"));
                
                productos.add(productoActual);
            }
            return productos;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return new ArrayList<Producto>();
        }
    }
    
    public Producto obtenerProducto (int id) {
        try {
            PreparedStatement comandoSQL = _conexion.prepareStatement("SELECT * FROM productos where id = ?;");
            comandoSQL.setInt(1, id);
            ResultSet registroEnTabla = comandoSQL.executeQuery();
            Producto productoActual = new Producto();
            while (registroEnTabla.next()) {
                productoActual.setId( registroEnTabla.getInt("id") );
                productoActual.setNombre( registroEnTabla.getString("nombre"));
                productoActual.setSku(registroEnTabla.getString("sku"));
                productoActual.setObservacion( registroEnTabla.getString("observacion"));
                productoActual.setCantidad( registroEnTabla.getInt("cantidad"));
                productoActual.setPrecio( registroEnTabla.getDouble("precio"));
                break;
            }
            return productoActual;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public int agregarProducto (Producto nuevoProducto) {
        try {
            String insertSql = "INSERT INTO productos (nombre, sku, observacion, cantidad, precio) values (?, ?, ?, ?, ?);";
            PreparedStatement comandoSQL = _conexion.prepareStatement(insertSql);
            comandoSQL.setString(1, nuevoProducto.getNombre());
            comandoSQL.setString(2, nuevoProducto.getSku());
            comandoSQL.setString(3, nuevoProducto.getObservacion());
            comandoSQL.setInt(4, nuevoProducto.getCantidad());
            comandoSQL.setDouble(5, nuevoProducto.getPrecio());
            
            int RegistroAfectados  = comandoSQL.executeUpdate();
            comandoSQL.close();
            return RegistroAfectados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public int actualizarProducto (Producto updateProducto) {
        try {
            String updateSql = "UPDATE productos SET nombre=?, sku=?, observacion=?, cantidad=?, precio=? where id =?;";
            PreparedStatement comandoSQL = _conexion.prepareStatement(updateSql);
            comandoSQL.setString(1, updateProducto.getNombre());
            comandoSQL.setString(2, updateProducto.getSku());
            comandoSQL.setString(3, updateProducto.getObservacion());
            comandoSQL.setInt(4, updateProducto.getCantidad());
            comandoSQL.setDouble(5, updateProducto.getPrecio());
            comandoSQL.setInt(6, updateProducto.getId());
            
            int RegistroAfectados  = comandoSQL.executeUpdate();
            comandoSQL.close();
            return RegistroAfectados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
    public int deleteProducto (int id) {
        try {
            String deleteSql = "DELETE FROM productos where id =?;";
            PreparedStatement comandoSQL = _conexion.prepareStatement(deleteSql);
            comandoSQL.setInt(1, id);
            
            int RegistroAfectados  = comandoSQL.executeUpdate();
            comandoSQL.close();
            return RegistroAfectados;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }
    
   
    
}
