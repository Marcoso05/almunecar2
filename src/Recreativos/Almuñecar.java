package Recreativos;

import java.util.Scanner;
import Excepciones.NumeroNegativo;
import Objetos.*;
import Diseño.Colores;
import java.util.InputMismatchException;

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
        //Variables y objetos para el uso programa
        //Variable para la seleccion de funciones del programa
        int opcion;
        //Variable para almacenar las tarjetas creadas en el array de tarjetas
        int contadorTarjetas = 0;
        //Cantidad de dinero que se desea cargar en las tarjetas
        int dineroCargar = 0;
        //Esta variable sustituye a la accion de introducir las tarjetas intruduciendo su posicion en el array
        int tarjetaSeleccionada;
        //Objeto para leer datos por teclado
        Scanner teclado = new Scanner(System.in);

        //Arrays para el almacen de los objetos que va a disponer nuestro recreativo
        Tarjeta tarjetas[] = new Tarjeta[100];
        Juego juegos[] = new Juego[20];
        Terminal terminales[] = new Terminal[10];
        Premio premios[] = new Premio[50];

        //Creacion de los pobjetos
        //Juegos
        Juego numero = new Juego("Numero", 2);
        //Premios
        Premio osito = new Premio("Osito", 100, 50);
        Premio pelotas = new Premio("Pelota", 50, 100);
        Premio gominolas = new Premio("Gominolas", 10, 200);
        //Terminales
        Terminal terminal = new Terminal(osito, pelotas, gominolas);

        System.out.println(Colores.FONDO_MORADO + Colores.WHITE + "Bienvenido a las recreativas ALMUÑECAR!!!" + Colores.RESET);

        System.out.print("\nEstas son las opciones: ");
        do {
            System.out.println("\nOpcion 1: Crear tarjeta. \nOpcion 2: Introducir creditos. \nOpcion 3: Ver los datos de su tarjeta.\nOpcion 4: Coste de la partida \nOpcion 5: Jugar. \nOpcion 6: Informacion de los premios. \nOpcion 7: Salir del terminal.");
            System.out.print("Que opcion desea: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    tarjetas[contadorTarjetas] = new Tarjeta(0);
                    contadorTarjetas++;
                    break;
                case 2:
                    try {
                        System.out.println("Introduzca su tarjeta");
                        tarjetaSeleccionada = teclado.nextInt();
                        
                        if (tarjetas[tarjetaSeleccionada] == null) {
                            System.out.println(Colores.RED + "La tarjeta seleccionada no es valida" + Colores.RESET);
                        } else {
                            System.out.println("Cuanto quieres cargar en su tarjeta?");
                            dineroCargar = teclado.nextInt();
                            terminal.cargarTarjeta(tarjetas[tarjetaSeleccionada], dineroCargar);
                        }
                } catch (InputMismatchException ex) {
                    System.out.println(Colores.RED + "El valor introducido no es correcto" + Colores.RESET);
                }
                break;
                case 3:
                    System.out.println("Introduzca su tarjeta");
                    tarjetaSeleccionada = teclado.nextInt();
                    System.out.println(tarjetas[tarjetaSeleccionada].toString());
                    break;
                case 4:
                    System.out.println("Introduzca su tarjeta");
                    tarjetaSeleccionada = teclado.nextInt();
                    System.out.print("Se necesitan " + numero.getCreditosNecesarios() + " para jugar, usted posee " + tarjetas[tarjetaSeleccionada].getCreditos());
                    if (numero.getCreditosNecesarios() > tarjetas[tarjetaSeleccionada].getCreditos()) {
                        System.out.println(" no dispone de los creditos necesarios");
                    }
                    break;
                case 5:
                    System.out.println(numero.toString() + "\n");
                    numero.jugar(tarjetas[contadorTarjetas]);
                    System.out.println(tarjetas[contadorTarjetas].toString());
                    break;
                case 6:
                    while (opcion != 4) {
                        System.out.println("Elija una de las siguientes opciones: \nOpcion 1: Ver premios. \nOpcion 2: Canjear premios. \nOpcion 3: Ver Stock. \nOpcion 4: Volver.");
                        opcion = teclado.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println(terminal.verPremios());
                                break;
                            case 2:
                                System.out.println("Que premio desea obtener");
                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                        }
                        break;
                    }
                case 7:
                    break;
                default:
                    System.out.println(Colores.RED + "Opcion seleccionada no valida" + Colores.RESET);

            }
        } while (opcion != 7);
    }
}
