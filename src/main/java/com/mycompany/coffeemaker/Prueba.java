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
        Deposito depoCafe = new Deposito(15000, 7500, 15000);
        Deposito depoDesca = new Deposito(15000, 7500, 15000);
        Deposito depoLeche = new Deposito(15000, 7500, 15000);
        Deposito depoChoco = new Deposito(15000, 7500, 15000);
        Deposito depoAgua = new Deposito(15000, 7500, 15000);
        Monedero monedero = new Monedero();      
        Cafetera maquina = new Cafetera(depoCafe, depoAgua, depoLeche, depoDesca, depoChoco, monedero);
        Administracion admin = new Administracion(535,51932);  
        Interfaz i1 = new Interfaz(maquina, admin);
        
        i1.menuInicial();
    }
    
}
