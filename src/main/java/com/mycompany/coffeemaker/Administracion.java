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
public class Administracion {
    
    private int usuario;
    private int contraseña;

    public Administracion(int usuario, int contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getUsuario() {
        return usuario;
    }

    public int getContraseña() {
        return contraseña;
    }
    
    
    
}
