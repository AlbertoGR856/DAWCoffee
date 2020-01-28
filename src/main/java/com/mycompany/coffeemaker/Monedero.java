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
//    private double precios;
//    private int numeroVentas;

    public Monedero(double saldoAcumulado, double saldoCliente, double precios, int numeroVentas) {
        this.saldoAcumulado = saldoAcumulado;
        this.saldoCliente = saldoCliente;

    }

    public double meterDinero(double saldoCliente) {

        this.saldoCliente = this.saldoCliente + saldoAcumulado;
        return saldoAcumulado;

    }
    
    public void sacarDinero(double saldoAcumulado) {
		//evalua si tiene suficiente dinero, con respecto al que quiere sacar, en caso afirmativo 
		//resta el dinero solicitado del dinero disponible, en caso contrario se emite un mensaje indicando 
                // que la cantidad no es suficiente
		if(this.saldoAcumulado>=saldoCliente){
			this.saldoAcumulado=this.saldoAcumulado-saldoCliente;
		}else{
			System.out.println("Se le devuelve "+saldoAcumulado);
		}	
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
