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

    // Atributos de la clase Deposito
    private int cantidadMax;
    private int cantidadUmbral;
    private int cantidadActual;
    private String nombre;

    // Constructor parametrizado
    public Deposito(int cantidadMax, int cantidadUmbral, int cantidadActual, String nombre) {
        this.cantidadMax = cantidadMax;
        this.cantidadUmbral = cantidadUmbral;
        this.cantidadActual = cantidadActual;
        this.nombre = nombre;
    }

    // Método que rellena el deposito  una cantidad que se indica por parámetros.
    public void rellenarCantidad(int cantidad) {
        // Controlo que la cantidad introducida no sea negativa.
        if (cantidad > 0) {
            // Controlo que la cantidadActual más la cantidad que se introduce por
            // parámetros no pueda ser mayor que la cantidadMax. Si es igual, será
            // igual que la cantidadMax por eso tambien lo controlo.
            if ((this.cantidadActual + cantidad) >= this.cantidadMax) {
                this.cantidadActual = this.cantidadMax;
            } else {
                // Si no es mayor ni igual que la cantidadMax, lo sumo
                this.cantidadActual += cantidad;
            }
        } else{
            throw new IllegalArgumentException("La cantidad no puede ser negativa... espera, ¿cómo has conseguido ponerla negativa si no hay signo negativo en el panel númerico?");
        }
    }

    // Método que indica si el contenido del depósito ha alcanzado el Umbral.
    public boolean devolverContenido() {
        // Controlo que la cantidadActual sea menor o igual a la cantidadUmbral
        if (this.cantidadActual <= this.cantidadUmbral) {
            // Si es así, devuelve true.
            return true;
        } else {
            // Si no, devuelve false.
            return false;
        }
    }

    // Método que rellena el depósito entero.
    public void rellenarEntero() {
        this.cantidadActual = this.cantidadMax;
    }

    public int getCantidadMax() {
        return cantidadMax;
    }

    public int getCantidadUmbral() {
        return cantidadUmbral;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }
    
    @Override
    public String toString() {
        return "El depósito de " + nombre + " tiene: cantidad umbral = " + cantidadUmbral + "gr, cantidad actual = " + cantidadActual +"gr, cantidad máxima = "+cantidadMax+"gr.";
    }

}
