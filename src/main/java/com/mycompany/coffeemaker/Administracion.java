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
    // Creación de los atributos
    private int usuario;
    private int contrasenia;

    // Constructor parametrizado
    public Administracion(int usuario, int contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    
    // Método que comprueba que el usuario que se le pasa por parámetro es correcto
    public boolean comprobarUsuario(int usuario){
        if (this.usuario == usuario){
            return true;
        }else{
            return false;
        }
    }
    
    
    // Método que comprueba que la contrasenia que se le pasa por parámetro es correcto
    public boolean comprobarContrasenia(int contrasenia){
        if (this.contrasenia == contrasenia){
            return true;
        }else{
            return false;
        }
    }

    // Método toString()
    @Override
    public String toString() {
        return "Usuario: " + usuario + "\n"
                + "Contraseña: " + contrasenia;
    }
    
    
    
}
