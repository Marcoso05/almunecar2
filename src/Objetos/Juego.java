/**
 * Lo que dice el enunciado
 */
package Objetos;
import java.util.Random;
import Juegos.*;
/**
 *
 * @author Yasín Pérez
 */
public class Juego {
    private String nombre;
    private int creditosNecesarios;
    private Juegos.AdivinaOrden hola; 
    
    public Juego(String nombre, int creditosNecesarios){
        setNombre(nombre);
        setCreditosNecesarios(creditosNecesarios);
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getCreditosNecesarios(){
        return this.creditosNecesarios;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setCreditosNecesarios(int creditosNecesarios){
        this.creditosNecesarios=creditosNecesarios;
    }
    
    public void lectorTarjeta(Tarjeta tarjeta){
        System.out.println(tarjeta.toString());
    }
    /**
     * Clase principal la cual van a utilizar las hijas para jugar
     * 
     * @author Marcos Bermejo Salamanca
     * @param tarjeta con la que se va a jugar
     * @return en número de tickets ganados en el juego
     */
    public int jugar(Tarjeta tarjeta){
        Random azar = new Random();
        int tickets = azar.nextInt(95)+5; // entre 0 y 99
        if(this.creditosNecesarios>tarjeta.getCreditos()){
            System.out.println("\n\t\tNo tiene creditos suficientes");
        }
        else{
            
            tarjeta.setCreditos(tarjeta.getCreditos()-this.creditosNecesarios);
            tarjeta.setTickets(tarjeta.getTickets()+tickets);
        }
        return tickets;
    }
    public boolean comprobarCreditosNecesarios(Tarjeta tar) {
        boolean posible = false;
        if (this.getCreditosNecesarios() <= tar.getCreditos()) {
            posible = true;
        } else {
            posible = false;
        }
        return posible;
    }
    
    public boolean cobrar (Tarjeta tarjeta){
        boolean puede = true;
         if(this.creditosNecesarios>tarjeta.getCreditos()){
            System.out.println("\n\t\tNo tiene creditos suficientes");
            puede = false;
        }
        else{
            tarjeta.setCreditos(tarjeta.getCreditos()-this.creditosNecesarios);
        }
        return puede;
    }
    
    public void sumarTickets (Tarjeta tarjeta, int tickets){
        tarjeta.setTickets(tickets+tarjeta.getTickets());
    }
    
    @Override
    public String toString(){
        return ("El nombre del juego es: " + getNombre()+"\nSe necesitan "+getCreditosNecesarios()+" creditos para jugar");
    }
}
