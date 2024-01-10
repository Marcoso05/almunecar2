/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Marcos Bermejo Salamanca
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
    /**
     * Constructor del terminal
     * 
     * @param pre1 primer premio del terminal
     * @param pre2 segundo premio del terminal
     * @param pre3 tercer premio del terminal
     */
    public Terminal(Premio pre1, Premio pre2, Premio pre3) {
        setPremio(pre1, 0);
        setPremio(pre2, 1);
        setPremio(pre3, 2);
        numTerminal = contadorTerminal++;
    }

    //GETTER/SETTER
    /**
     * Poner los premios en el terminal
     * 
     * @param pre premio a añadir
     * @param posicion posicion en la que lo quiero añadir
     */
    public void setPremio(Premio pre, int posicion) {
        premiosAsociados[posicion] = pre;
    }

    /**
     * Obtener los premios en forma de string
     * 
     * @return String de los premios asociados al terminal
     */
    public String getPremio() {
        return Arrays.toString(premiosAsociados);
    }
    /**
     * Obtener los premios en forma de array
     * 
     * @return Array con los premios asociados a un termianl
     */
    public Premio[] getPremioArray(){
        return this.premiosAsociados;
    }

    /**
     * Obtener el nuemro de terminal
     * 
     * @return numero de identigicador del terminal
     */
    public int getNumTerminal() {
        return numTerminal;
    }

    /**
     * Obtener el factor de conversion
     * 
     * @return factor de conversion del terminal
     */
    public int getFACTOR_CONVERSION() {
        return FACTOR_CONVERSION;
    }

    //METODOS PRINCIPALES
    
    
    /**
     * Convertir los euros a creditos
     * 
     * @param euros cantidad de euros a convertir a creditos
     * @return creditos 
     */
    private int convertir(int euros) {
        return euros * FACTOR_CONVERSION;
    }
    

    /**
     * Sumar los creditos a la tarjeta
     * 
     * @param tar tarjeta en la que se quieres sumar los creditos
     * @param valorSumar cantidad de creditos a sumar
     */
    private void sumarCreditos(Tarjeta tar, int valorSumar) {
        tar.setCreditos(tar.getCreditos() + valorSumar);
    }
    
    /**
     * Introduce la tarjeta y un valor en euros y se encarga de cargar el valor en creditos en la tarjeta
     * 
     * @param tar Tarjeta en la que se van a cargar los creditos
     * @param euros Cantidad de euros que quieres ingresar a la tarjeta
     * 
     */ 
    public void cargarTarjeta(Tarjeta tar, int euros) {
        if (euros>=0){
            sumarCreditos(tar, convertir(euros));
        }
    }
    
    /**
    * Muestra el saldo de creditos que tiene
    * 
    * @param tar Tarjeta de la que se va a ver el credito
    * @return Un mensaje con el saldo que hay
    */
    public String consultarSaldo(Tarjeta tar) {
        return ("Tiene: " + String.valueOf(tar.getCreditos()) + " creditos");
    }

    /**
     * Muestra los tickets que tiene
     * 
     * @param tar Tarjeta de la que se va a ver los tickets
     * @return 
     */
    public String consultarTickets(Tarjeta tar) {
        return ("Tiene: " + String.valueOf(tar.getTickets()) + " tickets");
    }

    /**
     *Transferir tickets de una tarjeta a otra
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

    /**
     * Transferir creditos de una tarjeta a otra
     * 
     * @param tar1 tarjeta origen
     * @param tar2 tarjeta destino
     * @param transferencia cantidad a transferir
     */
    public void transferirCreditos(Tarjeta tar1, Tarjeta tar2, int transferencia) {
        if (tar1.getCreditos() >= transferencia) {
            tar1.setCreditos(tar1.getCreditos() - transferencia);
            tar2.setCreditos(tar2.getCreditos() + transferencia);
        } else {
            System.out.println("La tarjeta " + tar1.getNumTarjeta() + " no contiene los tickets suficientes");
        }
    }
    
    /**
     * Comprobar si dispone de tickets necesarios para un premio
     * 
     * @param pre Premio que se quiere obtener
     * @param tar Tarjeta con la cual se va a obtener
     * @return Un booblean que indica si dispone de tickets suficientes
     */
    private boolean comprobarTiketsNecesarios(Premio pre, Tarjeta tar) {
        boolean posible = false;
        if (pre.getTicketsNecesarios() <= tar.getTickets()) {
            posible = true;
        } else {
            posible = false;
        }
        return posible;
    }

    /**
     * Compruebar si el premio esta disponible en un terminal
     * 
     * @param pre Premio que se quiere comprobar
     * @return Un boolean de si el premio se encuentra o no disponible
     */
    private boolean premioDisponible(Premio pre) {
        boolean dispo = false;
        for (int i = 0; i < this.premiosAsociados.length; i++) {
            if (this.premiosAsociados[i] == pre) {
                dispo = true;
            }
        }
        return dispo;
    }
    
    /**
     * Canjear un premio de un terminal
     * 
     * @param pre Premio que se quiere obtener
     * @param tar Tarjeta con la que se va a obtener
     */
    public void canjearPremios(Premio pre, Tarjeta tar) {
        try {
            if (premioDisponible(pre) && comprobarTiketsNecesarios(pre, tar) && pre.getRecuentoStock() > 0) {
                tar.setTickets(tar.getCreditos() - pre.getTicketsNecesarios());
                pre.setRecuentoStock(pre.getRecuentoStock() - 1);
                System.out.println("\n\t\t"+Colores.BLUE+"El premio es tuyo"+Colores.RESET);
            } else if (!premioDisponible(pre)) {
                System.out.println("\n\t\t"+Colores.RED + "El premio no se encuentra disponible" + Colores.RESET);
            } else if (!comprobarTiketsNecesarios(pre, tar)) {
                int faltan = pre.getTicketsNecesarios() - tar.getTickets();
                System.out.println("\n\t\t"+Colores.RED + "No dispone de los tickets suficientes le faltan " + faltan + Colores.RESET);
            } else if (pre.getRecuentoStock() <= 0) {
                System.out.println("\n\t\t"+Colores.RED + "El stock no es suficiente" + Colores.RESET);
            }
        } catch (NumeroNegativo ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Crear una tarjeta
     * 
     * @param dinero Dinero con el cual se quiere crear la tarjeta
     * @return Una nueva tarjeta
     */
    public Tarjeta crearTarjeta (int dinero){
        Tarjeta tarjeta = null;
        if (dinero > 0){
            tarjeta = new Tarjeta(convertir(dinero));
        }
        else{
            tarjeta = new Tarjeta(0);
        }
        return tarjeta;
    }
    
    /**
     * Muestra los premios disponibles en un terminal
     * 
     * @return String con los premios disponibles
     */

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
    /**
     * Muestra informacion relevante acerca de un terminal
     */
    public String toString() {
        String premios = verPremios();
        return ("El terminal: " + this.getNumTerminal() + "\nCon factor de conversion " + this.getFACTOR_CONVERSION() + "\nCon los premios: " + premios);
    }

}
