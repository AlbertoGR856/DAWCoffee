/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coffeemaker;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Interfaz {

    // Atributos de la clase
    private Cafetera cafetera;
    private static Scanner teclado = new Scanner(System.in);

    // Constructor parametrizado
    public Interfaz(Cafetera cafetera) {
        this.cafetera = cafetera;
    }

    // Voy a hacer un menuInicial que sea el menu que se muestre cuando la máquina está en reposo
    public void menuInicial() {
        // Creo una variable para guardar el valor de entrada por teclado que se utilizará
        // más abajo.
        int opcion = 0;

        // Hago un try catch por si el usuario introduce algún tipo de dato que no es válido.
        try {
            // Hago un bucle para que el usuario escoja una de las opciones
            do {
                System.out.println("Bienvenido\n"
                        + "------------------------\n"
                        + "1.Venta de productos\n"
                        + "2.Administración de la cafetera");
                opcion = teclado.nextInt();
            } while (!(opcion == 1 || opcion == 2));
        } catch (InputMismatchException ime) {
            // Imprimo por pantalla un mensaje que le recomienda utilizar números
            System.out.println("Ese valor no es un número... prueba con un número.");
        }
        // Hago un switch que dependiendo de la opcion que haya escogido el usuario, haga una cosa u otra.
        switch (opcion) {
            case 1:
                // Si escoge la primera opción irá al menú de ventas de productos
                menuVenta();
                break;
            case 2:
                // Si escoge la segunda opción irá al menú de administración de la cafetera.
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
        // Creo la variable opcion para que guarde el código introducido por el usuario.
        int contrasenia = 0, usuario = 0;
        // Creo la variable intentos para que el administrador tenga más de un intento por si se equivoca introduciendo el código.
        int intentos = 0;
        // Creo un boolean para luego utilizarlo en el bucle.
        boolean confirmacion;

        // Hago un try catch por si el usuario introduce algún tipo de dato que no es válido.
        try {
            // Hago un bucle para pedir los datos al usuario.
            do {
                // Mensaje de información para el usuario.
                System.out.println("A continuación, se le va a pedir el usuario y la contraseña. Va a tener 2 intentos.");

                // Le pido que introduzca el usuario
                System.out.println("Introduzca el usuario.");
                // Guardo en usuario la entrada por teclado.
                usuario = teclado.nextInt();

                // Le pido que introduzca la contrasenia.
                System.out.println("Introduzca la contraseña.");
                // Guardo en contrasenia la entrada por teclado.
                contrasenia = teclado.nextInt();

                // Hago una confirmación con un ternario que será la que saqué al usuario del bucle.
                // Para que saque al usuario del bucle, tiene que escribir bien el usuario y la contraseña o llegar al límite de intentos.
                confirmacion = (cafetera.getAdministracion().comprobarUsuario(usuario) && cafetera.getAdministracion().comprobarContrasenia(contrasenia) || intentos >= 1 && intentos <= 2) ? false : true;

                // Por si el usuario se equivoca sumo uno a la variable intentos.
                intentos++;
            } while (confirmacion);
        } catch (InputMismatchException ime) {
            // Imprimo por pantalla un mensaje que le recomienda utilizar números
            System.out.println("Ese valor no es un número... prueba con un número.");
        }

        // Controlo que el código introducido sea correcto
        if (cafetera.getAdministracion().comprobarUsuario(usuario) && cafetera.getAdministracion().comprobarContrasenia(contrasenia)) {
            // Creo una variable para guardar el valor de entrada por teclado que se utilizará
            // más abajo.
            int opcion = 0;

            // Hago un try catch por si el usuario introduce algún tipo de dato que no es válido.
            try {
                // Hago un bucle para que el usuario escoja una de las opciones que se muestran en el System.out.println
                do {
                    System.out.println("¿Qué quieres comprobar?\n"
                            + "------------------------\n"
                            + "1.Comprobar depósitos\n"
                            + "2.Comprobar estado general\n"
                            + "3.Consultar saldo de ventas realizadas.\n"
                            + "4.Rellenar depósitos.");
                    opcion = teclado.nextInt();
                } while (opcion >= 1 && 4 <= opcion);
            } catch (InputMismatchException ime) {
                // Imprimo por pantalla un mensaje que le recomienda utilizar números
                System.out.println("Ese valor no es un número... prueba con un número.");
            }

            // Hago un switch que dependiendo de la opcion que haya escogido el usuario, haga una cosa u otra.
            switch (opcion) {
                case 1:
                    break;
                    
                // En esta opción mostrará el estado actual de los depósitos y el usuario y contraseña del administrador.
                case 2:
                    System.out.println(cafetera.getAdministracion().toString());
                    System.out.println(cafetera.getDepositoAgua().toString());
                    System.out.println(cafetera.getDepositoAzucar().toString());
                    System.out.println(cafetera.getDepositoCafe().toString());
                    System.out.println(cafetera.getDepositoChocolate().toString());
                    System.out.println(cafetera.getDepositoDescafeinado().toString());
                    System.out.println(cafetera.getDepositoLeche().toString());
                    System.out.println(cafetera.getDepositoSacarina().toString());
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
