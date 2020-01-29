/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coffeemaker;

import java.util.Scanner;

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

    private static Scanner teclado = new Scanner(System.in);

    public Interfaz(Cafetera cafetera, Administracion administracion) {
        this.cafetera = cafetera;
        this.administracion = administracion;
    }

    public Cafetera getCafetera() {
        return cafetera;
    }

    public Administracion getAdministracion() {
        return administracion;
    }

    // Voy a hacer un menuInicial que sea el menu que se muestre cuando la máquina está en reposo
    public void menuInicial() {
        int solucion = 0;
        do {
            System.out.println("Bienvenido+\n"
                    + "------------------------+\n"
                    + "1.Venta de productos+\n"
                    + "2.Administración de la cafetera");
            solucion = teclado.nextInt();
        } while (solucion > 0 && 3 < solucion);

        switch (solucion) {
            case 1:
                menuVenta();
                break;
            case 2:
                menuAdministracion();
                break;
        }

    }

    // Voy a hacer un menu para las ventas que será llamado desde el menú inicial.
    private void menuVenta() {

    }

    // Voy a hacer un menu para el administrador que será llamado desde el menú inicial.
    private void menuAdministracion() {
       
    }

}
