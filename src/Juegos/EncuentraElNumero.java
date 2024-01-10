/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos;

/**
 *
 * @author developer
 */
import Objetos.Juego;
import Objetos.Tarjeta;
import java.util.Scanner;

public class EncuentraElNumero extends Juego {

    public EncuentraElNumero(String nombre, int creditosNecesarios) {
        super(nombre, creditosNecesarios);
    }

    /**
     * @param args the command line arguments
     */
    @Override
    public int jugar(Tarjeta tarjeta) {
        Azar aleatorio = new Azar();
        Scanner teclado = new Scanner(System.in);
        int tickets = 50;
        int i = 1;
        if (super.cobrar(tarjeta)) {
            int numero;

            System.out.println("Intenta adivianr el numero entre 1 y 100");
            do {
                System.out.print("Introcuce intento " + i + ": ");
                numero = teclado.nextInt();

                if (numero > 100 || numero < 0) {
                    System.out.println("El numero introducido no es correcto");
                } else if (aleatorio.mayor(numero)) {
                    System.out.println("El numero es mayor");
                } else if (aleatorio.menor(numero)) {
                    System.out.println("El numero es menor");
                }
                i++;

            } while (!aleatorio.igual(numero));

            super.sumarTickets(tarjeta, tickets);
            System.out.println("Correcto el numero es: " + numero + "\nHas necesitado: " + i + " intentos");
        } else {
            tickets = 0;
        }
        return tickets / i;
    }

}
