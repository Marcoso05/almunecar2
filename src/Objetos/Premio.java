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
    
    /**
     * Constructor de los premios
     * @param nombre -> Nombre del premio
     * @param ticketsNecesarios -> Nº de tickets necesarios para canjear el premio
     * @param recuentoStock -> Cantidad de stock del premio
     */
    public Premio (String nombre, int ticketsNecesarios, int recuentoStock) {
        this.nombre = nombre;
        this.ticketsNecesarios = ticketsNecesarios;
        try{
            this.setRecuentoStock(recuentoStock);
        }catch(NumeroNegativo ex){
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Getter del nombre
     * @return nombre
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Getter de ticketsNecesarios
     * @return ticketsNecesarios
     */
    public int getTicketsNecesarios() {
        return this.ticketsNecesarios;
    }
    
    /**
     * Getter de recuentoStock
     * @return recuentoStock
     */
    public int getRecuentoStock() {
        return this.recuentoStock;
    }
    
    /**
     * Setter de recuentoStock
     * @param stock -> Cantidad de stock para el premio
     * @throws NumeroNegativo -> Excepción lanzada en caso de ser inferior a 0
     */
    public void setRecuentoStock(int stock) throws NumeroNegativo{
        if (stock <0) {
            throw (new NumeroNegativo("El valor de stock introducido no es valido"));
        }else{
            this.recuentoStock=stock;
        }
    }
    
    /**
     * toString del premio
     * @return String incluyendo nombre, tickets necesarios y stock restante
     */
    @Override
    public String toString() {
        return ("Nombre: " + getNombre() + ". Tickets necesarios: " + getTicketsNecesarios() + ". Stock: " + getRecuentoStock());
    } 
}

