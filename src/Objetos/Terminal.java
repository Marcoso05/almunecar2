/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author developer
 */
import Excepciones.NumeroNegativo;
import java.util.Arrays;
import Diseño.Colores;

public class Terminal {

    //ATRIBUTOS
    //Array para almacenar los premios que va a contener el terminal
    private Premio premiosAsociados[] = new Premio[3];
    //Factor de conversion entre los euros y los creditos
    private final static int FACTOR_CONVERSION = 2;
    //Identificador del terminal
    private int numTerminal;
    private static int contadorTerminal = 1;
    
    //CONSTRUCTOR
    public Terminal(Premio pre1, Premio pre2, Premio pre3) {
        setPremio(pre1, 0);
        setPremio(pre2, 1);
        setPremio(pre3, 2);
        numTerminal = contadorTerminal++;
    }

    //GETTER/SETTER
    public void setPremio(Premio pre, int posicion) {
        premiosAsociados[posicion] = pre;
    }

    public String getPremio() {
        return Arrays.toString(premiosAsociados);
    }
    public Premio[] getPremioArray(){
        return this.premiosAsociados;
    }

    public int getNumTerminal() {
        return numTerminal;
    }

    public int getFACTOR_CONVERSION() {
        return FACTOR_CONVERSION;
    }

    //METODOS PRINCIPALES
    //Convertir los euros a creditos
    private int convertir(int euros) {
        return euros * FACTOR_CONVERSION;
    }
    //Sumar los creditos a la tarjeta

    private void sumarCreditos(Tarjeta tar, int valorSumar) {
        tar.setCreditos(tar.getCreditos() + valorSumar);
    }
    //Introduce la tarjeta y un valor en euros y se encarga de cargar el valor en creditos en la tarjeta

    public void cargarTarjeta(Tarjeta tar, int euros) {
        sumarCreditos(tar, convertir(euros));
    }
    //Consultar los creditos de la tarjeta

    public String consultarSaldo(Tarjeta tar) {
        return ("Tiene: " + String.valueOf(tar.getCreditos()) + " creditos");
    }
    //Consultar los tickets de una tarjeta

    public String consultarTickets(Tarjeta tar) {
        return ("Tiene: " + String.valueOf(tar.getTickets()) + " tickets");
    }
    //Transferir los tickets de una tarjeta a otra

    /**
     *
     * @param tar1 tarjeta origen
     * @param tar2 tarjeta destino
     * @param transferencia cantidad a transferir
     */
    public void transferirTickets(Tarjeta tar1, Tarjeta tar2, int transferencia) {
        if (tar1.getTickets() >= transferencia) {
            tar1.setTickets(tar1.getTickets() - transferencia);
            tar2.setTickets(tar2.getTickets() + transferencia);
        } else {
            System.out.println("La tarjeta " + tar1.getNumTarjeta() + " no contiene los tickets suficientes");
        }
    }
    //Transferir los creditos de una tarjeta a otra

    public void transferirCreditos(Tarjeta tar1, Tarjeta tar2, int transferencia) {
        if (tar1.getCreditos() >= transferencia) {
            tar1.setCreditos(tar1.getCreditos() - transferencia);
            tar2.setCreditos(tar2.getCreditos() + transferencia);
        } else {
            System.out.println("La tarjeta " + tar1.getNumTarjeta() + " no contiene los tickets suficientes");
        }
    }
    //comprobar si dispone de los tickets necesarios para el premio

    private boolean comprobarTiketsNecesarios(Premio pre, Tarjeta tar) {
        boolean posible = false;
        if (pre.getTicketsNecesarios() <= tar.getTickets()) {
            posible = true;
        } else {
            posible = false;
        }
        return posible;
    }

    //Comprobar si el premio se encuentra en este terminal
    private boolean premioDisponible(Premio pre) {
        boolean dispo = false;
        for (int i = 0; i < this.premiosAsociados.length; i++) {
            if (this.premiosAsociados[i] == pre) {
                dispo = true;
            }
        }
        return dispo;
    }
    //Canjear premios

    public void canjearPremios(Premio pre, Tarjeta tar) {
        try {
            if (premioDisponible(pre) && comprobarTiketsNecesarios(pre, tar) && pre.getRecuentoStock() > 0) {
                tar.setTickets(tar.getCreditos() - pre.getTicketsNecesarios());
                pre.setRecuentoStock(pre.getRecuentoStock() - 1);
            } else if (!premioDisponible(pre)) {
                System.out.println(Colores.RED + "El premio no se encuentra disponible" + Colores.RESET);
            } else if (!comprobarTiketsNecesarios(pre, tar)) {
                int faltan = pre.getTicketsNecesarios() - tar.getTickets();
                System.out.println(Colores.RED + "No dispone de los tickets suficientes le faltan " + faltan + Colores.RESET);
            } else if (pre.getRecuentoStock() <= 0) {
                System.out.println(Colores.RED + "El stock no es suficiente" + Colores.RESET);
            }
        } catch (NumeroNegativo ex) {
            System.out.println(ex.getMessage());
        }
    }
    public Tarjeta crearTarjeta (int dinero){
        Tarjeta tarjeta = new Tarjeta(convertir(dinero));
        return tarjeta;
    }

    public String verPremios(){
        String premios = "";
        int contador=0;
        for (int i = 0; i < this.premiosAsociados.length; i++) {
            premios = premios + "\n\t"+ (contador+1) + ": "+ this.premiosAsociados[i];
            premios = premios + " ";
            contador++;
        }
        return premios;
    }
    
    @Override
    public String toString() {
        String premios = verPremios();
        return ("El terminal: " + this.getNumTerminal() + "\nCon factor de conversion " + this.getFACTOR_CONVERSION() + "\nCon los premios: " + premios);
    }

}
