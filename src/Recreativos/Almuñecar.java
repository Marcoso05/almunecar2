package Recreativos;

import java.util.Scanner;
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
        Juego numero = new Juego("Numero", 2);
        Premio osito = new Premio("Osito", 100, 50);
        Premio pelotas = new Premio("Pelota", 50, 100);
        Premio gominolas = new Premio("Gominolas", 10, 200);
        Scanner teclado = new Scanner(System.in);
        int opcion = 33;
        int contador = 0;
        Tarjeta[] tarjetas = new Tarjeta[50];
        int dineros = 0;

        Terminal terminal = new Terminal(osito, pelotas, gominolas);

        System.out.println("Bienvenido a las recreativas ALMUÑECAR!!!");
        while (opcion != 6) {
            System.out.println("Elija una de las siguientes opciones: \nOpcion 1: Crear tarjeta. \nOpcion 2: Introducir creditos. \nOpcion 3: Ver los datos de su tarjeta. \nOpcion 4: Jugar. \nOpcion 5: Informacion de los premios. \nOpcion 6: Salir del terminal.");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    tarjetas[contador] = new Tarjeta(0);
                    break;
                case 2:
                    System.out.println("Cuanto quieres cargar en su tarjeta?");
                    dineros = teclado.nextInt();
                    terminal.cargarTarjeta(tarjetas[contador], dineros);
                    break;
                case 3:
                    System.out.println(tarjetas[contador].toString());
                    break;
                case 4:
                    System.out.println(numero.toString()+"\n");
                    numero.jugar(tarjetas[contador]);
                    System.out.println(tarjetas[contador].toString());
                    break;
                case 5:
                    while(opcion!=4){
                     System.out.println("Elija una de las siguientes opciones: \nOpcion 1: Ver premios. \nOpcion 2: Canjear premios. \nOpcion 3: Ver Stock. \nOpcion 4: Volver.");
                     opcion = teclado.nextInt();
                     switch (opcion) {
                        case 1:
                            System.out.println(terminal.verPremios());
                            break;
                        case 2:
                            
                            break;
                        case 3:
                            
                            break;
                        case 4:
                            
                            break;
                    }
                     break;
            }
            contador++;
        }
        }
    }
}
