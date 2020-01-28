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
public enum TiposBebidas {
    CAFE_SOLO(0, 001, 0.80),
    SOLO_LARGO(0, 002, 0.90),
    SOLO_CON_LECHE(0, 003, 1.10),
    CORTADO(0, 004, 1),
    CAFE_SOLO_DESCAFEINADO(0, 102, 0.80),
    SOLO_LARGO_DESCAFEINADO(0, 102, 0.90),
    SOLO_CON_LECHE_DESCAFEINADO(0, 103, 1.10),
    CORTADO_DESCAFEINADO(0, 104, 1),
    CHOCOLATE(0, 201, 1.40),
    LECHE_FRIA(0, 301, 0.50),
    LECHE_CALIENTE(0, 302, 0.50);

    // Sólo van a haber tres valores de cantidad 0-Ninguna, 1-Poco, 2-Mucha
    private int cantidadComplemento;

    // Los códigos de producto son de 3 digitos y no van a poder ser cambiados.
    // Si el código empiza por 0 se tratará de un café
    // Si empieza por 1 se tratará de un café descafeinado
    // Si empiza por 2 se tratará de un chocolate
    // Y si empieza por 3 se tratará de una leche
    private int codBebida;

    // El precio de las bebidas vendrán incluidas.
    private double precio;

    // Hacemos un constructor para que el Enum tenga los atributos creados anteriormente
    private TiposBebidas(int cantidadComplemento, int codBebida, double precio) {
        // Para controlar el tema de las cantidades de sacarina o azúcar es igual a 0,1 o 2, hago un ternario
        // Si la cantidad no es válida, por defecto no echará azúcar o sacarina
        this.cantidadComplemento = (cantidadComplemento >= 0 || cantidadComplemento <= 2) ? cantidadComplemento : 0;
        this.codBebida = codBebida;
        this.precio = precio;
    }

    // Método get para obtener la cantidad del complemento
    public int getCantidadComplemento() {
        return cantidadComplemento;
    }

    // Método set para poder cambiar la cantidad
    public void setCantidadComplemento(int cantidadComplemento) {
        // Vuelve a tener el mismo ternario anteriormente mencionado
        this.cantidadComplemento = (cantidadComplemento >= 0 || cantidadComplemento <= 2) ? cantidadComplemento : 0;
    }

    // Método get para obtener el código de la bebida
    public int getCodBebida() {
        return codBebida;
    }

    // Método get para obtener el precio de la bebida
    public double getPrecio() {
        return precio;
    }

}
