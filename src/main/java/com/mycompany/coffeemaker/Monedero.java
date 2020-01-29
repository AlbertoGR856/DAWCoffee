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
public class Monedero {

    private double saldoAcumulado;
    private double saldoCliente;

    public Monedero() {
    }

    // Método que devuelve la cantidad de dinero introducida por el cliente
    public double meterDinero(double saldoCliente) {

        this.saldoCliente = this.saldoCliente + saldoAcumulado;
        return saldoAcumulado;

    }

    //Método que evalua si se tiene suficiente dinero, con respecto al que quiere sacar, en caso afirmativo 
    // se resta el saldoAcumulado del saldoCLiente, en caso contrario se emite un mensaje indicando 
    // que se le devuelve el saldoAcumulado
    public void sacarDinero(double saldoAcumulado) {

        if (this.saldoAcumulado >= saldoCliente) {
            this.saldoAcumulado = this.saldoAcumulado - saldoCliente;
        } else {
            System.out.println("Se le devuelve " + saldoAcumulado);
        }
    }

    // Método que devuelve el saldo disponible en la cafetera
    public String consultarSaldoDisponible() {
        return "Saldo disponible= " + saldoAcumulado;
    }

    public double getSaldoAcumulado() {
        return saldoAcumulado;
    }

    public void setSaldoAcumulado(double saldoAcumulado) {
        this.saldoAcumulado = saldoAcumulado;
    }

    public double getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    @Override
    public String toString() {
        return "Monedero{" + "saldoAcumulado=" + saldoAcumulado + ", saldoCliente=" + saldoCliente + '}';
    }

}
