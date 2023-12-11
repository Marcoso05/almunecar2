package Objetos;

import Excepciones.NumeroNegativo;

/**
 *
 * @author Aarón Lozano
 */

public class Premio {
    
    
    private String nombre;
    private int ticketsNecesarios;
    private int recuentoStock;
    
    public Premio (String nombre, int ticketsNecesarios, int recuentoStock) {
        this.nombre = nombre;
        this.ticketsNecesarios = ticketsNecesarios;
        this.recuentoStock = recuentoStock;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getTicketsNecesarios() {
        return this.ticketsNecesarios;
    }
    
    public int getRecuentoStock() {
        return this.recuentoStock;
    }
    
    public void setRecuentoStock(int stock) throws NumeroNegativo{
        if (stock <0) {
            throw (new NumeroNegativo("El valor de stock introducido no es valido"));
        }else{
            this.recuentoStock=stock;
        }
    }
    
    @Override
    public String toString() {
        return ("Nombre: " + getNombre() + ". Tickets necesarios: " + getTicketsNecesarios() + ". Stock: " + getRecuentoStock());
    } 
}

