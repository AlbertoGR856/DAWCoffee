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

    private Deposito depositoCafe, depositoAgua, depositoLeche,
            depositoDescafeinado, depositoChocolate, depositoSacarina, depositoAzucar;
    private Usuario administracion;
    private TiposBebidas bebidas;
    private double saldoAcumulado;
    private double saldoCliente;
    private static int numVenta;

    public Cafetera(Deposito depositoCafe, Deposito depositoAgua, Deposito depositoLeche, Deposito depositoDescafeinado, Deposito depositoChocolate, Deposito depositoSacarina, Deposito depositoAzucar, Usuario administracion) {
        this.depositoCafe = depositoCafe;
        this.depositoAgua = depositoAgua;
        this.depositoLeche = depositoLeche;
        this.depositoDescafeinado = depositoDescafeinado;
        this.depositoChocolate = depositoChocolate;
        this.depositoSacarina = depositoSacarina;
        this.depositoAzucar = depositoAzucar;
        this.administracion = administracion;
    }

    // Este método permite vender una bebida
    public void venta(TiposBebidas bebida) {
        this.saldoAcumulado += this.saldoCliente;
        setSaldoCliente(getSaldoCliente() - bebida.getPrecio());
        numVenta++;       
    }
    

    public Usuario getAdministracion() {
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

    public Deposito getDepositoSacarina() {
        return depositoSacarina;
    }

    public Deposito getDepositoAzucar() {
        return depositoAzucar;
    }

    public double getSaldoAcumulado() {
        return saldoAcumulado;
    }

    public double getSaldoCliente() {
        return saldoCliente;
    }

    private void setSaldoCliente(double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public static int getNumVenta() {
        return numVenta;
    }

    

}
