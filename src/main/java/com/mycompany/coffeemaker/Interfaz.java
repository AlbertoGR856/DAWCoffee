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

    private static Scanner teclado = new Scanner(System.in);

    public Interfaz(Cafetera cafetera) {
        this.cafetera = cafetera;
    }

    // Voy a hacer un menuInicial que sea el menu que se muestre cuando la máquina está en reposo
    public void menuInicial() {
        int solucion = 0;
        do {
            System.out.println("Bienvenido\n"
                    + "------------------------\n"
                    + "1.Venta de productos\n"
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
        System.out.println("Introduce dinero: ");
    }

    // Voy a hacer un menu para el administrador que será llamado desde el menú inicial.
    private void menuAdministracion() {
        // Creo la variable solucion para que guarde el código introducido por el usuario.
        int contraseña = 0, usuario = 0;
        // Creo la variable intentos para que el administrador tenga más de un intento por si se equivoca introduciendo el código.
        int intentos = 0;
        // Creo un boolean para luego utilizarlo en el bucle.
        boolean confirmacion;
        
        // Hago un bucle para pedir los datos al usuario.
        do {
            // Mensaje de información para el usuario.
            System.out.println("A continuación, se le va a pedir el usuario y la contraseña. Va a tener 2 intentos.");

            // Le pido que introduzca el usuario
            System.out.println("Introduzca el usuario.");
            // Guardo en usuario la entrada por teclado.
            usuario = teclado.nextInt();

            // Le pido que introduzca la contraseña.
            System.out.println("Introduzca la contraseña.");
            // Guardo en contraseña la entrada por teclado.
            contraseña = teclado.nextInt();

            // Hago una confirmación con un ternario que será la que saqué al usuario del bucle
            confirmacion = (usuario == cafetera.getAdministracion().getUsuario() && contraseña == cafetera.getAdministracion().getContraseña() || intentos > 0 && intentos < 3) ? false : true;
            
            // Por si el usuario se equivoca sumo uno a la variable intentos.
            intentos++;
        } while (confirmacion);
        
        // Controlo que el código introducido sea correcto
        if (usuario == cafetera.getAdministracion().getUsuario() && contraseña == cafetera.getAdministracion().getContraseña()) {
            int solucion = 0;
            do {
                System.out.println("¿Qué quieres comprobar?\n"
                        + "------------------------\n"
                        + "1.Comprobar depósitos\n"
                        + "2.Comprobar estado general\n"
                        + "3.Consultar saldo de ventas realizadas.\n"
                        + "4.Rellenar depósitos.");
                solucion = teclado.nextInt();
            } while (solucion > 0 && 5 < solucion);

            switch (solucion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        } else {
            menuInicial();
        }
    }

}
