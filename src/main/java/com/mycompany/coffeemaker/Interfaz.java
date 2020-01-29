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
                        + "2.Administración de la cafetera\n"
                        + "3.Salir");
                opcion = teclado.nextInt();
            } while (!(opcion == 1 || opcion == 2 || opcion == 3));
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
            case 3:
                break;
        }

    }

    // Voy a hacer un menu para las ventas que será llamado desde el menú inicial.
    private void menuVenta() {
        System.out.println("Introduce dinero: ");
        menuInicial();
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
                } while (!(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4));
            } catch (InputMismatchException ime) {
                // Imprimo por pantalla un mensaje que le recomienda utilizar números
                System.out.println("Ese valor no es un número... prueba con un número.");
            }

            // Hago un switch que dependiendo de la opcion que haya escogido el usuario, haga una cosa u otra.
            switch (opcion) {
                case 1:
                    menuAdministracionOpcion1();
                    break;

                // En esta opción mostrará el estado actual de los depósitos y el usuario y contraseña del administrador.
                case 2:
                    menuAdministracionOpcion2();
                    break;
                case 3:
                    System.out.println("Se han realizado un total de " + cafetera.getNumVenta() + " ventas y se ha recaudado un total de " + cafetera.getSaldoAcumulado() + "€.");
                    break;
                case 4:
                    menuAdministracionOpcion4();
                    break;
            }
            menuInicial();
        } else {
            menuInicial();
        }
    }

    private void menuAdministracionOpcion1() {
        String cafe = (cafetera.getDepositoCafe().indicador()) ? ("El depósito " + cafetera.getDepositoCafe().getNombre() + " debe ser rellenado.") : "";
        String descafeinado = (cafetera.getDepositoDescafeinado().indicador()) ? ("\nEl depósito " + cafetera.getDepositoDescafeinado().getNombre() + " debe ser rellenado.") : "";
        String chocolate = (cafetera.getDepositoChocolate().indicador()) ? ("\nEl depósito " + cafetera.getDepositoChocolate().getNombre() + " debe ser rellenado.") : "";
        String leche = (cafetera.getDepositoLeche().indicador()) ? ("\nEl depósito " + cafetera.getDepositoLeche().getNombre() + " debe ser rellenado.") : "";
        String agua = (cafetera.getDepositoAgua().indicador()) ? ("\nEl depósito " + cafetera.getDepositoAgua().getNombre() + " debe ser rellenado.") : "";
        String azucar = (cafetera.getDepositoAzucar().indicador()) ? ("\nEl depósito " + cafetera.getDepositoAzucar().getNombre() + " debe ser rellenado.") : "";
        String sacarina = (cafetera.getDepositoSacarina().indicador()) ? ("\nEl depósito " + cafetera.getDepositoSacarina().getNombre() + " debe ser rellenado.") : "";
        // Si todos los depósitos están llenos, indicará que no hay que rellenarlos.
        if (cafe.equals("") && descafeinado.equals("") && chocolate.equals("") && leche.equals("") && azucar.equals("") && sacarina.equals("")) {
            System.out.println("Nigún depósito tiene que ser rellenado.");
        } else {
            // Si no, indicará que depósito hay que rellenar.
            System.out.println(cafe + descafeinado + chocolate + leche + agua + azucar + sacarina);
        }
    }

    private void menuAdministracionOpcion2() {
        System.out.println(cafetera.getAdministracion().toString());
        System.out.println(cafetera.getDepositoAgua().toString());
        System.out.println(cafetera.getDepositoAzucar().toString());
        System.out.println(cafetera.getDepositoCafe().toString());
        System.out.println(cafetera.getDepositoChocolate().toString());
        System.out.println(cafetera.getDepositoDescafeinado().toString());
        System.out.println(cafetera.getDepositoLeche().toString());
        System.out.println(cafetera.getDepositoSacarina().toString());
    }

    private void menuAdministracionOpcion4() {
        int opcion = 0;
        // Hago un try catch por si el usuario introduce algún tipo de dato que no es válido.
        try {
            // Hago un bucle para que el usuario escoja una de las opciones que se muestran en el System.out.println
            do {
                System.out.println("¿Qué depósito quieres rellenar?\n"
                        + "------------------------\n"
                        + "1.Café\n"
                        + "2.Descafeinado\n"
                        + "3.Chocolate.\n"
                        + "4.Leche.\n"
                        + "5.Agua.\n"
                        + "6.Azúcar.\n"
                        + "7.Sacarina.");
                opcion = teclado.nextInt();
            } while (opcion == 1 && 7 < opcion);
        } catch (InputMismatchException ime) {
            // Imprimo por pantalla un mensaje que le recomienda utilizar números
            System.out.println("Ese valor no es un número... prueba con un número.");
        }

        // Una vez escoge una de las opciones hago un switch
        switch (opcion) {
            // En el primer caso hará:
            case 1:
                // Hago un try catch por si el usuario introduce algún tipo de dato que no es válido.
                try {
                    // Hago un bucle para que el usuario escoja una de las opciones que se muestran en el System.out.println
                    do {
                        System.out.println("¿Cómo lo quieres rellenar?\n"
                                + "------------------------\n"
                                + "1.Con una cantidad específica.\n"
                                + "2.Entero.");
                        opcion = teclado.nextInt();
                    } while (!(opcion == 1 || opcion == 2));
                } catch (InputMismatchException ime) {
                    // Imprimo por pantalla un mensaje que le recomienda utilizar números
                    System.out.println("Ese valor no es un número... prueba con un número.");
                }
                // Después del bucle haré un switch
                switch (opcion) {
                    // En el primer caso rellenará una cantidad específica el depósito del caso 1 del anterior bucle
                    // en el que pregunta que depósito quiere utilizar.
                    case 1:
                        System.out.println("¿Cúanto?");
                        int cantidad = teclado.nextInt();
                        try {
                            cafetera.getDepositoCafe().rellenarCantidad(cantidad);
                        } catch (IllegalArgumentException iae) {
                            System.out.println("La cantidad no puede ser negativa... espera, ¿cómo has conseguido ponerla negativa si no hay signo negativo en el panel númerico?");
                        }

                        break;

                    // En el primer caso rellenará entero el depósito del caso 1 del anterior bucle en el que 
                    // pregunta que depósito quiere utilizar.
                    case 2:
                        cafetera.getDepositoCafe().rellenarEntero();
                        break;
                }
                break;
            case 2:
                // Hago un try catch por si el usuario introduce algún tipo de dato que no es válido.
                try {
                    // Hago un bucle para que el usuario escoja una de las opciones que se muestran en el System.out.println
                    do {
                        System.out.println("¿Cómo lo quieres rellenar?\n"
                                + "------------------------\n"
                                + "1.Con una cantidad específica.\n"
                                + "2.Entero.");
                        opcion = teclado.nextInt();
                    } while (!(opcion == 1 || opcion == 2));
                } catch (InputMismatchException ime) {
                    // Imprimo por pantalla un mensaje que le recomienda utilizar números
                    System.out.println("Ese valor no es un número... prueba con un número.");
                }
                // Después del bucle haré un switch
                switch (opcion) {
                    // En el primer caso rellenará una cantidad específica el depósito del caso 1 del anterior bucle
                    // en el que pregunta que depósito quiere utilizar.
                    case 1:
                        System.out.println("¿Cúanto?");
                        int cantidad = teclado.nextInt();
                        try {
                            cafetera.getDepositoDescafeinado().rellenarCantidad(cantidad);
                        } catch (IllegalArgumentException iae) {
                            System.out.println("La cantidad no puede ser negativa... espera, ¿cómo has conseguido ponerla negativa si no hay signo negativo en el panel númerico?");
                        }
                        break;

                    // En el primer caso rellenará entero el depósito del caso 1 del anterior bucle en el que 
                    // pregunta que depósito quiere utilizar.
                    case 2:
                        cafetera.getDepositoDescafeinado().rellenarEntero();
                        break;
                }
                break;
            case 3:
                // Hago un try catch por si el usuario introduce algún tipo de dato que no es válido.
                try {
                    // Hago un bucle para que el usuario escoja una de las opciones que se muestran en el System.out.println
                    do {
                        System.out.println("¿Cómo lo quieres rellenar?\n"
                                + "------------------------\n"
                                + "1.Con una cantidad específica.\n"
                                + "2.Entero.");
                        opcion = teclado.nextInt();
                    } while (!(opcion == 1 || opcion == 2));
                } catch (InputMismatchException ime) {
                    // Imprimo por pantalla un mensaje que le recomienda utilizar números
                    System.out.println("Ese valor no es un número... prueba con un número.");
                }
                // Después del bucle haré un switch
                switch (opcion) {
                    // En el primer caso rellenará una cantidad específica el depósito del caso 1 del anterior bucle
                    // en el que pregunta que depósito quiere utilizar.
                    case 1:
                        System.out.println("¿Cúanto?");
                        int cantidad = teclado.nextInt();
                        try {
                            cafetera.getDepositoChocolate().rellenarCantidad(cantidad);
                        } catch (IllegalArgumentException iae) {
                            System.out.println("La cantidad no puede ser negativa... espera, ¿cómo has conseguido ponerla negativa si no hay signo negativo en el panel númerico?");
                        }
                        break;

                    // En el primer caso rellenará entero el depósito del caso 1 del anterior bucle en el que 
                    // pregunta que depósito quiere utilizar.
                    case 2:
                        cafetera.getDepositoChocolate().rellenarEntero();
                        break;
                }
                break;
            case 4:
                // Hago un try catch por si el usuario introduce algún tipo de dato que no es válido.
                try {
                    // Hago un bucle para que el usuario escoja una de las opciones que se muestran en el System.out.println
                    do {
                        System.out.println("¿Cómo lo quieres rellenar?\n"
                                + "------------------------\n"
                                + "1.Con una cantidad específica.\n"
                                + "2.Entero.");
                        opcion = teclado.nextInt();
                    } while (!(opcion == 1 || opcion == 2));
                } catch (InputMismatchException ime) {
                    // Imprimo por pantalla un mensaje que le recomienda utilizar números
                    System.out.println("Ese valor no es un número... prueba con un número.");
                }
                // Después del bucle haré un switch
                switch (opcion) {
                    // En el primer caso rellenará una cantidad específica el depósito del caso 1 del anterior bucle
                    // en el que pregunta que depósito quiere utilizar.
                    case 1:
                        System.out.println("¿Cúanto?");
                        int cantidad = teclado.nextInt();
                        try {
                            cafetera.getDepositoLeche().rellenarCantidad(cantidad);
                        } catch (IllegalArgumentException iae) {
                            System.out.println("La cantidad no puede ser negativa... espera, ¿cómo has conseguido ponerla negativa si no hay signo negativo en el panel númerico?");
                        }
                        break;

                    // En el primer caso rellenará entero el depósito del caso 1 del anterior bucle en el que 
                    // pregunta que depósito quiere utilizar.
                    case 2:
                        cafetera.getDepositoLeche().rellenarEntero();
                        break;
                }
                break;
            case 5:
                // Hago un try catch por si el usuario introduce algún tipo de dato que no es válido.
                try {
                    // Hago un bucle para que el usuario escoja una de las opciones que se muestran en el System.out.println
                    do {
                        System.out.println("¿Cómo lo quieres rellenar?\n"
                                + "------------------------\n"
                                + "1.Con una cantidad específica.\n"
                                + "2.Entero.");
                        opcion = teclado.nextInt();
                    } while (!(opcion == 1 || opcion == 2));
                } catch (InputMismatchException ime) {
                    // Imprimo por pantalla un mensaje que le recomienda utilizar números
                    System.out.println("Ese valor no es un número... prueba con un número.");
                }
                // Después del bucle haré un switch
                switch (opcion) {
                    // En el primer caso rellenará una cantidad específica el depósito del caso 1 del anterior bucle
                    // en el que pregunta que depósito quiere utilizar.
                    case 1:
                        System.out.println("¿Cúanto?");
                        int cantidad = teclado.nextInt();
                        try {
                            cafetera.getDepositoAgua().rellenarCantidad(cantidad);
                        } catch (IllegalArgumentException iae) {
                            System.out.println("La cantidad no puede ser negativa... espera, ¿cómo has conseguido ponerla negativa si no hay signo negativo en el panel númerico?");
                        }
                        break;

                    // En el primer caso rellenará entero el depósito del caso 1 del anterior bucle en el que 
                    // pregunta que depósito quiere utilizar.
                    case 2:
                        cafetera.getDepositoAgua().rellenarEntero();
                        break;
                }
                break;
            case 6:
                // Hago un try catch por si el usuario introduce algún tipo de dato que no es válido.
                try {
                    // Hago un bucle para que el usuario escoja una de las opciones que se muestran en el System.out.println
                    do {
                        System.out.println("¿Cómo lo quieres rellenar?\n"
                                + "------------------------\n"
                                + "1.Con una cantidad específica.\n"
                                + "2.Entero.");
                        opcion = teclado.nextInt();
                    } while (!(opcion == 1 || opcion == 2));
                } catch (InputMismatchException ime) {
                    // Imprimo por pantalla un mensaje que le recomienda utilizar números
                    System.out.println("Ese valor no es un número... prueba con un número.");
                }
                // Después del bucle haré un switch
                switch (opcion) {
                    // En el primer caso rellenará una cantidad específica el depósito del caso 1 del anterior bucle
                    // en el que pregunta que depósito quiere utilizar.
                    case 1:
                        System.out.println("¿Cúanto?");
                        int cantidad = teclado.nextInt();
                        try {
                            cafetera.getDepositoAzucar().rellenarCantidad(cantidad);
                        } catch (IllegalArgumentException iae) {
                            System.out.println("La cantidad no puede ser negativa... espera, ¿cómo has conseguido ponerla negativa si no hay signo negativo en el panel númerico?");
                        }
                        break;

                    // En el primer caso rellenará entero el depósito del caso 1 del anterior bucle en el que 
                    // pregunta que depósito quiere utilizar.
                    case 2:
                        cafetera.getDepositoAzucar().rellenarEntero();
                        break;
                }
                break;
            case 7:
                // Hago un try catch por si el usuario introduce algún tipo de dato que no es válido.
                try {
                    // Hago un bucle para que el usuario escoja una de las opciones que se muestran en el System.out.println
                    do {
                        System.out.println("¿Cómo lo quieres rellenar?\n"
                                + "------------------------\n"
                                + "1.Con una cantidad específica.\n"
                                + "2.Entero.");
                        opcion = teclado.nextInt();
                    } while (!(opcion == 1 || opcion == 2));
                } catch (InputMismatchException ime) {
                    // Imprimo por pantalla un mensaje que le recomienda utilizar números
                    System.out.println("Ese valor no es un número... prueba con un número.");
                }
                // Después del bucle haré un switch
                switch (opcion) {
                    // En el primer caso rellenará una cantidad específica el depósito del caso 1 del anterior bucle
                    // en el que pregunta que depósito quiere utilizar.
                    case 1:
                        System.out.println("¿Cúanto?");
                        int cantidad = teclado.nextInt();
                        try {
                            cafetera.getDepositoSacarina().rellenarCantidad(cantidad);
                        } catch (IllegalArgumentException iae) {
                            System.out.println("La cantidad no puede ser negativa... espera, ¿cómo has conseguido ponerla negativa si no hay signo negativo en el panel númerico?");
                        }
                        break;

                    // En el primer caso rellenará entero el depósito del caso 1 del anterior bucle en el que 
                    // pregunta que depósito quiere utilizar.
                    case 2:
                        cafetera.getDepositoSacarina().rellenarEntero();
                        break;
                }
                break;
        }
    }
}
