/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coffeemaker;

/**
 *
 * @author sandra
 */
public enum TiposCafe {
    CAFE_SOLO(0, 001,0.80),
    SOLO_LARGO(0, 002,0.90),
    SOLO_CON_LECHE(0, 003,1.10),
    CORTADO(0, 004,1),
    CAFE_SOLO_DESCAFEINADO(0, 102,0.80),
    SOLO_LARGO_DESCAFEINADO(0, 102,0.90),
    SOLO_CON_LECHE_DESCAFEINADO(0, 103,1.10),
    CORTADO_DESCAFEINADO(0, 104,1),
    CHOCOLATE(0, 111,1.40),
    LECHE_FRIA(0, 221,0.50),
    LECHE_CALIENTE(0, 222,0.50);

    private int cantidadComplemento;
    private int codProducto;
    private double precio;

    private TiposCafe(int cantidadComplemento, int codProducto, double precio) {
        this.cantidadComplemento = cantidadComplemento;
        this.codProducto = codProducto;
        this.precio = precio;
    }

    public int getCantidadComplemento() {
        return cantidadComplemento;
    }

    public void setCantidadComplemento(int cantidadComplemento) {
        this.cantidadComplemento = cantidadComplemento;
    }

    public int getCodProducto() {
        return codProducto;
    }


    public double getPrecio() {
        return precio;
    }
    
    
}
