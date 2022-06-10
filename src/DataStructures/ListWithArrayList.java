package DataStructures;

import java.util.ArrayList;

/**
 *
 * @author Sergi
 * @param <T>
 */
public class ListWithArrayList<T> {

    private ArrayList<T> lista;

    /**
     * Constructor
     */
    public ListWithArrayList() {
        lista = new ArrayList<T>();
    }

    /**
     *
     * @param elemento
     */
    public void insertar(T elemento) {
        lista.add(elemento);
    }

    /**
     *
     * @return
     */
    public boolean vacia() {
        return lista.isEmpty();
    }

    /**
     *
     * @param pos
     * @return
     * @throws Exception
     */
    public T extraer(int pos) throws Exception {
        if (((lista.size()) > pos) && (pos >= 0)) {
            return lista.remove(pos);
        } else {
            throw new Exception("non-existent position");
        }
    }

    /**
     *
     * @param pos
     * @return
     * @throws Exception
     */
    public T consultar(int pos) throws Exception {
        if (((lista.size()) > pos) && (pos >= 0)) {
            return lista.get(pos);
        } else {
            throw new Exception("non-existent position");
        }
    }

    /**
     *
     * @param elemento
     * @return
     * @throws Exception
     */
    public int buscarPos(T elemento) throws Exception {
        for (int i = 0; i < lista.size(); i++) {
            if (elemento == lista.get(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param pos1
     * @param pos2
     * @throws Exception
     */
    public void intercambiar(int pos1, int pos2) throws Exception {
        T aux;
        if ((((lista.size()) > pos1) && (pos1 >= 0)) && (((lista.size()) > pos2) && (pos2 >= 0))) {
            aux = lista.get(pos1);
            lista.set(pos1, lista.get(pos2));
            lista.set(pos2, aux);
        } else {
            throw new Exception("non-existent position");
        }
    }

    /**
     *
     * @param elemento
     * @return
     */
    public boolean buscar(T elemento) {
        return lista.contains(elemento);
    }

    /**
     *
     * @return
     */
    public int numElementos() {
        return lista.size();
    }
}
