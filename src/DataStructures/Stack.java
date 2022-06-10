package DataStructures;

/**
 *
 * @author Sergi
 * @param <T>
 */
public class Stack <T> {
    private final int TAMAÑO;
    private T [] elementos;
    private int indiceUltimoElemento;

    /**
     *
     * @param s
     */
    public Stack(int s) {
        TAMAÑO = s > 0 ? s : 10;
        elementos = (T []) new Object[TAMAÑO];
        indiceUltimoElemento = -1; // pila vacia, índice del elemento de arriba LIFO 
    }

    /**
     *
     * @param item
     */
    public void introducir(T item) { //push
        try {
            if (indiceUltimoElemento == TAMAÑO - 1) {
                throw new PilaLlena("La pila está llena");
            }
            indiceUltimoElemento++;
            elementos[indiceUltimoElemento] = item;            
        }catch (PilaLlena error) {
            System.out.println(error.toString());
        }
    }

    /**
     *
     * @return
     */
    public T extraer() { //pop
        try {
            if (indiceUltimoElemento == -1) {
                throw new PilaVacia("La pila esta vacía");
            }                  
        }catch (PilaVacia error) {
            System.out.println(error.toString());
        }
        return elementos[indiceUltimoElemento--]; 
    }
    
    //método que retorna el elemento cima del objeto pila

    /**
     *
     * @return
     */
    public T cima() {
        try {
            if (indiceUltimoElemento == -1) {
                throw new PilaVacia("La pila esta vacía");
            }                  
        }catch (PilaVacia error) {
            System.out.println(error.toString());
        }
        return elementos[indiceUltimoElemento];         
    }

    //método que devuelve el elemento base (el primero introducido) de un objeto Pila

    /**
     *
     * @return
     */
    public T elementoBase() {
        try {
            if (indiceUltimoElemento == -1) {
                throw new PilaVacia("La pila esta vacía");
            }                  
        }catch (PilaVacia error) {
            System.out.println(error.toString());
        }
        return elementos[0];    
    }
    
    //método que devuelve el número de elementos de un objeto pila

    /**
     *
     * @return
     */
    public int numeroElementos() {
        return indiceUltimoElemento+1;
    }  
    
    //método que elemina del objeto pila tantos elementos como el parámetro dado

    /**
     *
     * @param numero
     */
    public void eliminarElementos(int numero) {
        try {
            if (indiceUltimoElemento+1 < numero) {
                throw new OperacionNoViable("En la pila hay menos elementos de los que se desea eliminar");
            }                  
        }catch (OperacionNoViable error) {
            System.out.println(error.toString());
        }     
        for (int indice=0;indice<numero;indice++) {
            extraer();
        }
    }

    /**
     *
     * @return
     */
    public boolean estaLlena() {
        return indiceUltimoElemento == TAMAÑO -1;
    }

    /**
     *
     * @return
     */
    public boolean estaVacia() {
        return indiceUltimoElemento == -1;
    }
    
    /**
     * Exception
     */
    public static class PilaLlena extends Exception {

        /**
         *
         * @param s
         */
        public PilaLlena(String s) {
            super(s);
        }
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

    /**
     * Exception
     */
    public static class OperacionNoViable extends Exception {

        /**
         *
         * @param s
         */
        public OperacionNoViable(String s) {
            super(s);
        }
    }
 
}
