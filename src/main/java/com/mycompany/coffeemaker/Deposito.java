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
public class Deposito {

    private int cantidadMax;
    private int cantidadUmbral;
    private int cantidadActual;
    private String contenido;

//    Metodos
//    contenido;
//    vaciar;
//    rellenar;
//    servir;
//     comprobarDeposito;
    public Deposito(int cantidadMax, int cantidadUmbral, int cantidadActual, String contenido) {
        this.cantidadMax = cantidadMax;
        this.cantidadUmbral = cantidadUmbral;
        this.cantidadActual = cantidadActual;
        this.contenido = contenido;
    }

    // Método que devuelve que si se vacia el deposito al llegar a la cantidadMax en caso contrario
    // se vacia.
    public boolean vaciar(int cantidadActual) {

        if (cantidadActual > cantidadMax) {
            return false;
        } else {
            cantidadActual -= cantidadActual;
            return true;
        }

    }

    // Método que devuelve que si se llena el deposito al llegar a la cantidadumbral en caso contrario
    // el deposito se llenaria.
    public boolean llenar(int cantidadActual) {

        if (cantidadActual > cantidadUmbral) {
            return false;
        } else {
            cantidadActual += cantidadActual;
            return true;
        }

    }

    // Método que comprueba el deposito de la cafetera
    public String comprobarDeposito() {
        return "Deposito disponible=" + cantidadActual;
    }

    public int getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(int cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public int getCantidadUmbral() {
        return cantidadUmbral;
    }

    public void setCantidadUmbral(int cantidadUmbral) {
        this.cantidadUmbral = cantidadUmbral;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Deposito{" + "cantidadMax=" + cantidadMax + ", cantidadUmbral=" + cantidadUmbral + ", cantidadActual=" + cantidadActual + ", contenido=" + contenido + '}';
    }

}
