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
        // Creo la variable solucion para que guarde el código introducido por el usuario.
        int contraseña = 0, usuario = 0;
        // Creo la variable intentos para que el administrador tenga más de un intento por si se equivoca introduciendo el código
        int intentos = 0;
        boolean confirmacion;
        do {
            // Mensaje de información para el usuario
            System.out.println("A continuación, se le va a pedir el usuario y la contraseña. Va a tener 2 intentos.");

            System.out.println("Introduzca el usuario.");
            // Guardo en usuario la entrada por teclado
            usuario = teclado.nextInt();

            System.out.println("Introduzca la contraseña.");
            // Guardo en contraseña la entrada por teclado
            contraseña = teclado.nextInt();

            confirmacion = (usuario == administracion.getUsuario() && contraseña == administracion.getContraseña()) ? false : true;

            // Por si el usuario se equivoca sumo uno a la variable intentos.
            intentos++;
        } while (confirmacion);
       
    }

}
