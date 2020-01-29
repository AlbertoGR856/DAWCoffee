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
        Deposito depoCafe = new Deposito(1500, 750, 1500,"café");
        Deposito depoDesca = new Deposito(1500, 750, 1500, "descafeinado");
        Deposito depoLeche = new Deposito(1500, 750, 1500, "leche");
        Deposito depoChoco = new Deposito(1500, 750, 1500, "chocolate");
        Deposito depoAgua = new Deposito(1500, 750, 1500, "agua");
        Deposito depoSacarina = new Deposito(550, 275, 50, "sacarina");
        Deposito depoAzucar = new Deposito(550, 275, 550, "azúcar");
        Administracion admin = new Administracion(535,51932);  
        Cafetera maquina = new Cafetera(depoCafe, depoAgua, depoLeche, depoDesca, depoChoco, depoSacarina, depoAzucar, admin);
        Interfaz i1 = new Interfaz(maquina);
        
        i1.menuInicial();
    }
    
}
