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

    private Deposito depositoCafe, depositoAgua, depositoLeche, depositoDescafeinado;
    private Monedero monedero;
    //private TiposCafe tiposCafe;

    public Cafetera(Deposito depositoCafe, Deposito depositoAgua, Deposito depositoLeche, Deposito depositoDescafeinado, Monedero monedero) {
        this.depositoCafe = depositoCafe;
        this.depositoAgua = depositoAgua;
        this.depositoLeche = depositoLeche;
        this.depositoDescafeinado = depositoDescafeinado;
        this.monedero = monedero;
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

    public Monedero getMonedero() {
        return monedero;
    }

}
