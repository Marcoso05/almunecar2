/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;
import java.util.Random;
/**
 *
 * @author developer
 */
public class Juego {
    private String nombre;
    private int creditosNecesarios;
    
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
    
    public void lectorTarjeta(Tarjeta x){
        System.out.println(x.toString());
    }
    
    public void jugar(Tarjeta x){
        Random r = new Random();
        if(this.creditosNecesarios>x.getCreditos()){
            System.out.println("No tiene creditos suficientes");
        }
        else{
            x.setCreditos(x.getCreditos()-this.creditosNecesarios);
            x.setTickets(x.getTickets()+r.nextInt(95)+5);
        }
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
    
    @Override
    public String toString(){
        return ("El nombre del juego es: " + getNombre()+"\nSe necesitan "+getCreditosNecesarios()+" creditos para jugar");
    }
}
