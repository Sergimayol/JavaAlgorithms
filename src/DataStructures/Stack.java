package DataStructures;

public class Stack <T> {
    private final int TAMAÑO;
    private T [] elementos;
    private int indiceUltimoElemento;

    public Stack(int s) {
        TAMAÑO = s > 0 ? s : 10;
        elementos = (T []) new Object[TAMAÑO];
        indiceUltimoElemento = -1; // pila vacia, índice del elemento de arriba LIFO 
    }

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
    public int numeroElementos() {
        return indiceUltimoElemento+1;
    }  
    
    //método que elemina del objeto pila tantos elementos como el parámetro dado
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

    public boolean estaLlena() {
        return indiceUltimoElemento == TAMAÑO -1;
    }

    public boolean estaVacia() {
        return indiceUltimoElemento == -1;
    }
    
    
    public static class PilaLlena extends Exception {
         public PilaLlena(String s) {
            super(s);
        }
    }

    public static class PilaVacia extends Exception {
        public PilaVacia(String s) {
            super(s);
        }
    }

    public static class OperacionNoViable extends Exception {
        public OperacionNoViable(String s) {
            super(s);
        }
    }
 
}
