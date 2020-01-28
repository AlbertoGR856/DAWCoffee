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
public class Prueba {
    
    public static void main(String[] args) {
        Deposito depoCafe = new Deposito(15000, 7500, 15000, "Cafe");
        Deposito depoDesca = new Deposito(15000, 7500, 15000, "Café descafeinado");
        Deposito depoLeche = new Deposito(15000, 7500, 15000, "Leche en polvo");
        Deposito depoChoco = new Deposito(15000, 7500, 15000, "Chocolate en polvo");
        Deposito depoAgua = new Deposito(15000, 7500, 15000, "Agua");
        Monedero monedero = new Monedero();
        
        Cafetera maquina = new Cafetera(depoCafe, depoAgua, depoLeche, depoDesca, depoChoco, monedero);
    }
    
}
