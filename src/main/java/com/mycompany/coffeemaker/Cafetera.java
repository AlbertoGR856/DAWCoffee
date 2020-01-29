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
public class Cafetera {

    private Deposito depositoCafe, depositoAgua, depositoLeche, depositoDescafeinado, depositoChocolate;
    private Monedero monedero;    
    private Administracion administracion;
    private TiposBebidas bebidas;

    public Cafetera(Deposito depositoCafe, Deposito depositoAgua, Deposito depositoLeche, Deposito depositoDescafeinado, Deposito depositoChocolate, Monedero monedero, Administracion administracion) {
        this.depositoCafe = depositoCafe;
        this.depositoAgua = depositoAgua;
        this.depositoLeche = depositoLeche;
        this.depositoDescafeinado = depositoDescafeinado;
        this.depositoChocolate = depositoChocolate;
        this.monedero = monedero;
        this.administracion = administracion;
    }

    public Administracion getAdministracion() {
        return administracion;
    }

    
    public Deposito getDepositoCafe() {
        return depositoCafe;
    }

    public Deposito getDepositoAgua() {
        return depositoAgua;
    }

    public Deposito getDepositoLeche() {
        return depositoLeche;
    }

    public Deposito getDepositoDescafeinado() {
        return depositoDescafeinado;
    }

    public Deposito getDepositoChocolate() {
        return depositoChocolate;
    }

    public Monedero getMonedero() {
        return monedero;
    }

    

}
