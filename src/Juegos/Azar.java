/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

/**
 *
 * @author Marcos Bermejo Salamanca
 */
import java.util.Random;
public class Azar {
    int superior;
    int inferior;
    
    
    //Crear el numero random a encontrar
    Random azar = new Random();
    private int valor = azar.nextInt(100)+1;
    //Metodos
    /**
     * Comprobar si el numero es mayor
     * 
     * @param numero Numero a comprobar
     * @return Boolean si es mayor o no
     */
    public boolean mayor(int numero){
        return (this.valor > numero);
    }
    /**
     * Comprobar si el numero es menor
     * 
     * @param numero Numero a comprobar
     * @return Boolean si es menor
     */
    public boolean menor(int numero){
        return (this.valor < numero);
    }
    /**
     * Comprobar si el numero es igual
     * 
     * @param numero Numero a comprobar
     * @return Boolean si el numero es igual
     */
    public boolean igual(int numero){
        return (this.valor == numero);
    }
    
    
}