
package DataStructures;

import java.util.ArrayList;

/**
 *
 * @author Sergi
 * @param <T>
 */
public class StackArrayList <T> {
    Exception PilaVacia;
    private final ArrayList <T> pila;
 
    /**
     * Constructor
     */
    public StackArrayList() {
            pila = new ArrayList <T> ();
    }

    /**
     *
     * @param valor
     */
    public void introducir(T valor) {
            pila.add(valor);
    }

    /**
     *
     * @return
     * @throws PilaVacia
     * @throws Exception
     */
    public T extraer() throws PilaVacia, Exception {
            T elemento;
            if (!pila.isEmpty()) {
                return pila.remove(pila.size()-1);
            }
            else throw PilaVacia;
    }
        
    /**
     *
     * @return
     */
    public int numElementos() {
           return pila.size();
   }
   
    /**
     * Exception
     */
    public static class PilaVacia extends Exception {

        /**
         *
         * @param s
         */
        public PilaVacia(String s) {
            super(s);
        }
    }

}
