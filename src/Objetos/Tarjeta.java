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
public class Tarjeta {
    private int creditos;
    private int tickets;
    private int numTarjeta;
    private static int contador=1;
    
    public Tarjeta(int creditos){
        this.creditos = creditos;
        this.tickets = 0;
        this.numTarjeta = contador++;
    }
    
    public int getCreditos(){
        return this.creditos;
    }
    
    public int getTickets(){
        return this.tickets;
    }
    
    public int getNumTarjeta(){
        return this.numTarjeta;
    }
    
    public void setTickets(int tickets){
        if(tickets>=0){
        this.tickets = tickets;
        }
    }
    
    public void setCreditos(int creditos){
        if(creditos>=0){
        this.creditos = creditos;
        }
    }
    
    @Override
    public String toString(){
        return ("Numero de tarjeta: "+getNumTarjeta()+"\nNumero de creditos: "+getCreditos()+"\nNumero de tickets: "+getTickets());
    }
}
