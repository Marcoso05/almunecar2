
package Excepciones;

/**
 * Excepcion si el numero es menor que 0
 * 
 * @author Marcos Bemrejo Salamanca
 */
public class NumeroNegativo extends Exception {
        public NumeroNegativo(String mensaje) {
          super(mensaje);
        }
    }