/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmp.dao;
// PJO  Plain Java Object
/**
 *
 * @author obetancourth
 */
public class Producto {

    /**
     * @return the _sku
     */
    public String getSku() {
        return _sku;
    }

    /**
     * @param _sku the _sku to set
     */
    public void setSku(String _sku) {
        this._sku = _sku;
    }

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    /**
     * @return the _precio
     */
    public double getPrecio() {
        return _precio;
    }

    /**
     * @param _precio the _precio to set
     */
    public void setPrecio(double _precio) {
        this._precio = _precio;
    }

    /**
     * @return the _cantidad
     */
    public int getCantidad() {
        return _cantidad;
    }

    /**
     * @param _cantidad the _cantidad to set
     */
    public void setCantidad(int _cantidad) {
        this._cantidad = _cantidad;
    }

    /**
     * @return the _observacion
     */
    public String getObservacion() {
        return _observacion;
    }

    /**
     * @param _observacion the _observacion to set
     */
    public void setObservacion(String _observacion) {
        this._observacion = _observacion;
    }
    
    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }
    
    private String _sku;
    private String _nombre;
    private double _precio;
    private int    _cantidad;
    private String _observacion;
    private int    _id;
    
}
