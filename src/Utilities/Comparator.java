/*
 CLASE INTERFACE PARA COMPARAR DOS OBJETOS CON LOS MÉTODOS compara y menorQue

    MÉTODO compara --> DEVUELVE

            -1 SI EL OBJETO ES MENOR QUE EL DADO POR PARÁMETRO
            0 SI EL OBJETO ES IGUAL QUE EL DADO POR PARÁMETRO
            1 SI EL OBJETO ES MAYOR QUE EL DADO POR PARÁMETRO

    MÉTODO menorQue --> DEVUELVE true SI EL OBJETO ES MENOR QUE EL DADO POR 
    PARÁMETRO
 */
package Utilities;

/**
 *
 * @author Sergi
 */
public interface Comparator {

    /**
     *
     * @param objeto
     * @return
     */
    int compara(Comparator objeto);

    /**
     *
     * @param objeto
     * @return
     */
    boolean menorQue(Comparator objeto);
}
