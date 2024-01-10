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
import Objetos.Juego;
import Objetos.Tarjeta;
import java.util.Scanner;
import java.util.Random;

public class Piedra extends Juego {

    /**
     * Constructor del jugo de piedra papel tijera
     * 
     * @param Nombre del jugo
     * @param creditosNecesarios numero de creditos que se necesitan para jugar
     * 
     */
    public Piedra(String nombre, int creditosNecesarios) {
        super(nombre, creditosNecesarios);
    }

    @Override
    /**
     * Hija de juego la cual contiene el juego
     * 
     * @param tarjeta Tarjeta con la que se va a jugar
     */
    public int jugar(Tarjeta tarjeta) {
        Scanner teclado = new Scanner(System.in);
        Random azar = new Random();

        String ordenador = null;
        String jugador;
        int eleccionOrdenador;
        String continuar;
        int tickets = 50;
        int contadorOrdenador = 0;
        int contadorJugador = 0;

        if (super.cobrar(tarjeta)) {

            do {
                eleccionOrdenador = azar.nextInt(3);
                switch (eleccionOrdenador) {
                    case 0:
                        ordenador = "TIJERA";
                        break;
                    case 1:
                        ordenador = "PAPEL";
                        break;
                    case 2:
                        ordenador = "PIEDRA";
                        break;
                    default:
                        System.out.println("Eleccion no valida");
                }

                System.out.print("Introduce tu eleccion piedra (i), papel(a) o tijera(t): ");
                jugador = teclado.nextLine();

                switch (jugador) {
                    case "a":
                        jugador = "PAPEL";
                        break;
                    case "i":
                        jugador = "PIEDRA";
                        break;
                    case "t":
                        jugador = "TIJERA";
                        break;
                    default:
                        System.out.println("Eleccion no valida");
                }

                if (jugador.toUpperCase().equals(ordenador.toUpperCase())) {
                    System.out.println("Empate");
                } else {
                    switch (jugador.toUpperCase()) {
                        case "PAPEL":
                            if (ordenador.toUpperCase().equals("PIEDRA")) {
                                System.out.println("El jugador gana");
                                contadorJugador++;
                            } else if (ordenador.toUpperCase().equals("TIJERA")) {
                                System.out.println("El ordenador gana");
                                contadorOrdenador++;
                            }
                            break;
                        case "PIEDRA":
                            if (ordenador.toUpperCase().equals("TIJERA")) {
                                System.out.println("El jugador gana");
                                contadorJugador++;
                            } else if (ordenador.toUpperCase().equals("PAPEL")) {
                                System.out.println("El ordenador gana");
                                contadorOrdenador++;
                            }
                            break;
                        case "TIJERA":
                            if (ordenador.toUpperCase().equals("PIEDRA")) {
                                System.out.println("El ordenador gana");
                                contadorOrdenador++;
                            } else if (ordenador.toUpperCase().equals("PAPEL")) {
                                System.out.println("El jugador gana");
                                contadorJugador++;
                            }
                            break;
                        default:
                            System.out.println("Eleccion no valida");
                            break;
                    }

                    System.out.println("jugador-ordenador: " + (contadorJugador) + "-" + (contadorOrdenador));
                }
            } while (contadorJugador < 3 && contadorOrdenador < 3);

            if (contadorOrdenador == 0) {
                tickets = 50;
            } else if (contadorJugador == 3) {
                System.out.println("GANASTE!!!!!");
                tickets = (int) tickets / (contadorOrdenador + 1);
            } else if (contadorOrdenador == 3) {
                System.out.println("Perdistes");
                tickets = 5;
            } else {
                System.out.println("Ocurrio un error");
                tickets = 0;
            }
            
            super.sumarTickets(tarjeta, tickets);
        } else {
            tickets = 0;
        }
        return tickets;
    }
}
