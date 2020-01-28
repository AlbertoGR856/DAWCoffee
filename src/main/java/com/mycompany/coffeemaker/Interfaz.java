/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coffeemaker;

/**
 *
 * @author usuario
 */
public class Interfaz {
    
//    private int codProducto;
//    private int cantidadComplemento;
    private Cafetera cafetera;
    private Administracion administracion;
    private TiposBebidas bebidas;

    public Interfaz(Cafetera cafetera, Administracion administracion) {
        this.cafetera = cafetera;
        this.administracion = administracion;
    }

    public Cafetera getCafetera() {
        return cafetera;
    }

    public void setCafetera(Cafetera cafetera) {
        this.cafetera = cafetera;
    }

    public Administracion getAdministracion() {
        return administracion;
    }

    public void setAdministracion(Administracion administracion) {
        this.administracion = administracion;
    }
    
    
}
