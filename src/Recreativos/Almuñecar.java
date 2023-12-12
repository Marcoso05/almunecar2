package Recreativos;

import Excepciones.NumeroNegativo;
import Objetos.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Diseño.Colores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author developer
 */

public class Almuñecar {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Juego numero = new Juego("Numero",2);
        Premio osito = new Premio("Osito",100,50);
        Premio pelotas = new Premio("Pelota",50,100);
        Premio gominolas = new Premio("Gominolas",10,200);
        
        Terminal terminal = new Terminal (osito,pelotas,gominolas);
        
        Tarjeta tarjeta = terminal.crearTarjeta(5);
        System.out.println(tarjeta.toString());
        
        Tarjeta tarjeta2 = terminal.crearTarjeta(5);
        System.out.println(tarjeta2.toString());
        
        

    }
    
}
