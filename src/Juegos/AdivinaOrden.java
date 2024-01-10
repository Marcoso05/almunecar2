package Juegos;

import Objetos.Juego;
import Objetos.Tarjeta;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Marcos Bermejo Salamanca
 */
public class AdivinaOrden extends Juego {

    /**
     * Constructor del jugo Adivina el orden
     * 
     * @param Nombre del jugo
     * @param creditosNecesarios numero de creditos que se necesitan para jugar
     * 
     */
    public AdivinaOrden(String nombre, int creditosNecesarios) {
        super(nombre, creditosNecesarios);
    }

    @Override
    /**
     * Hija de juego la cual contiene el juego
     * 
     * @param tarjeta Tarjeta con la que se va a jugar
     */
    public int jugar(Tarjeta tarjeta) {
        Scanner sc = new Scanner(System.in);
        Random azar = new Random();
        int cont = 0;

        if (super.cobrar(tarjeta)) {

            int input;
            int[] a = new int[10];
            int[] c = new int[10];

            a[0] = azar.nextInt(1001);
            a[1] = azar.nextInt(1001);
            a[2] = azar.nextInt(1001);
            a[3] = azar.nextInt(1001);
            a[4] = azar.nextInt(1001);
            a[5] = azar.nextInt(1001);
            a[6] = azar.nextInt(1001);
            a[7] = azar.nextInt(1001);
            a[8] = azar.nextInt(1001);
            a[9] = azar.nextInt(1001);

            System.arraycopy(a, 0, c, 0, a.length);

            Arrays.sort(c);

            System.out.println("Escribe la posición en la que crees que irá el número (1-10) en la serie de 10 números del 1 al 1000.");
            for (int i = 0; i < 10; i++) {
                System.out.println(a[i] + "\n");
                input = sc.nextInt();
                if (a[i] == c[input - 1]) {
                    cont++;
                }
            }

            System.out.println("Has acertado: " + cont + "/10.");
            super.sumarTickets(tarjeta, cont * 10);
        }
        return cont * 10;
    }
}
