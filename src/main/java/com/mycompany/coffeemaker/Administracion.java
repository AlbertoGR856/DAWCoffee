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
    
    // Método que comprueba que el usuario que se le pasa por parámetro es correcto
    public boolean comprobarUsuario(int usuario){
        if (this.usuario == usuario){
            return true;
        }else{
            return false;
        }
    }
    
    
    // Método que comprueba que la contraseña que se le pasa por parámetro es correcto
    public boolean comprobarContraseña(int contraseña){
        if (this.contraseña == contraseña){
            return true;
        }else{
            return false;
        }
    }
    
}
