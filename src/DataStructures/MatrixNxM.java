package DataStructures;


/*
Clase MatrizNxM, donde Ny M son enteros y N>=1 y M>=1
 */
public class MatrixNxM implements java.io.Serializable {

    // ATRIBUTOS
    private int dimension1, dimension2;
    private double[][] elementos;

    // MÉTODOS
    // MÉTODOS CONSTRUCTORES 
    public MatrixNxM(int dim1, int dim2) {
        dimension1 = dim1;
        dimension2 = dim2;
        elementos = new double[dimension1][dimension2];
    }

    public MatrixNxM(double[][] a) {
        dimension1 = a.length;
        dimension2 = a[0].length;
        elementos = new double[dimension1][dimension2];
        elementos = a;
    }

    //lleva a cabo la conversión a String de un objeto MatrizNxM con fines
    //de visualización
    @Override
    public String toString() {
        String salida = "";
        for (int fila = 0; fila < dimension1; fila++) {
            for (int columna = 0; columna < dimension2; columna++) {
                salida = salida + elementos[fila][columna] + "\t";
            }
            salida = salida + "\n";
        }
        return salida;
    }

    //método de clase que lleva a cabo la suma de dos objetos MatrizNxM dados por parámetro
    public static MatrixNxM suma(MatrixNxM a, MatrixNxM b) {
        MatrixNxM resultado = null;
        try {
            //verificar si tienen el mismo número de filas y de columnas
            if ((a.dimension1 == b.dimension1)
                    && (a.dimension2 == b.dimension2)) {
                resultado = new MatrixNxM(a.dimension1, a.dimension2);
                for (int fila = 0; fila < a.dimension1; fila++) {
                    for (int columna = 0; columna < a.dimension2; columna++) {
                        resultado.elementos[fila][columna] = a.elementos[fila][columna] + b.elementos[fila][columna];
                    }
                }
            } else {
                //al no tener el mismo número de filas y columnas llevamos a cabo
                //la invocación de la excepción no predefinida matricesIncompatibles
                throw new Exception("INCOMPATIBLE MATRICES FOR THE SUM");
            }
        } catch (Exception error) {
        }
        return resultado;
    }

    //método de objeto que lleva a cabo la suma de un objeto MatrizNxM con otro objeto 
    //MatrixNxM dado por parámetro
    public MatrixNxM suma(MatrixNxM b) {
        MatrixNxM resultado = null;
        try {
            //verificar si tienen el mismo número de filas y de columnas
            if ((dimension1 == b.dimension1)
                    && (dimension2 == b.dimension2)) {
                resultado = new MatrixNxM(dimension1, dimension2);
                for (int fila = 0; fila < dimension1; fila++) {
                    for (int columna = 0; columna < dimension2; columna++) {
                        resultado.elementos[fila][columna] = elementos[fila][columna] + b.elementos[fila][columna];
                    }
                }
            } else {
                //al no tener el mismo número de filas y columnas llevamos a cabo
                //la invocación de la excepción no predefinida matricesIncompatibles
                throw new Exception("INCOMPATIBLE MATRICES FOR THE SUM");
            }
        } catch (Exception error) {
        }
        return resultado;
    }

    //método de clase que lleva a cabo la resta de dos objetos MatrizNxM dados por parámetro
    public static MatrixNxM resta(MatrixNxM a, MatrixNxM b) {
        MatrixNxM resultado = null;
        try {
            //verificar si tienen el mismo número de filas y de columnas
            if ((a.dimension1 == b.dimension1)
                    && (a.dimension2 == b.dimension2)) {
                resultado = new MatrixNxM(a.dimension1, a.dimension2);
                for (int fila = 0; fila < a.dimension1; fila++) {
                    for (int columna = 0; columna < a.dimension2; columna++) {
                        resultado.elementos[fila][columna] = a.elementos[fila][columna] - b.elementos[fila][columna];
                    }
                }
            } else {
                //al no tener el mismo número de filas y columnas llevamos a cabo
                //la invocación de la excepción no predefinida matricesIncompatibles
                throw new Exception("INCOMPATIBLE MATRICES FOR SUBTRACTION");
            }
        } catch (Exception error) {
        }
        return resultado;
    }

    //método de objeto que lleva a cabo la suma de un objeto MatrizNxM con otro objeto 
    //MatrixNxM dado por parámetro
    public MatrixNxM resta(MatrixNxM b) {
        MatrixNxM resultado = null;
        try {
            //verificar si tienen el mismo número de filas y de columnas
            if ((dimension1 == b.dimension1)
                    && (dimension2 == b.dimension2)) {
                resultado = new MatrixNxM(dimension1, dimension2);
                for (int fila = 0; fila < dimension1; fila++) {
                    for (int columna = 0; columna < dimension2; columna++) {
                        resultado.elementos[fila][columna] = elementos[fila][columna] - b.elementos[fila][columna];
                    }
                }
            } else {
                //al no tener el mismo número de filas y columnas llevamos a cabo
                //la invocación de la excepción no predefinida matricesIncompatibles
                throw new Exception("INCOMPATIBLE MATRICES FOR SUBTRACTION");
            }
        } catch (Exception error) {
        }
        return resultado;
    }

    //método de clase que lleva a cabo el producto de dos objetos MatrixNxM dados
    //por parámetro
    public static MatrixNxM producto(MatrixNxM a, MatrixNxM b) {
        MatrixNxM resultado = null;
        try {
            //verificar si las dos matrices son compatibles para el producto
            if ((a.dimension1 == b.dimension2)
                    && (a.dimension2 == b.dimension1)) {
                resultado = new MatrixNxM(a.dimension1, b.dimension2);
                for (int fila = 0; fila < a.dimension1; fila++) {
                    for (int columna = 0; columna < b.dimension2; columna++) {
                        resultado.elementos[fila][columna] = 0;
                        for (int indice = 0; indice < a.dimension2; indice++) {
                            resultado.elementos[fila][columna] = (a.elementos[fila][indice] * b.elementos[indice][columna])
                                    + resultado.elementos[fila][columna];
                        }
                    }
                }

            } else {
                //al no ser compatibles para el producto llevamos a cabo la invocación
                //de la excepción no predefinida matricesIncompatibles
                throw new Exception("COMPATIBLE MATRICES FOR THE PRODUCT");
            }
        } catch (Exception error) {
        }
        return resultado;
    }

    //método de objeto que lleva a cabo el producto de dos objetos MatrixNxM dados
    //por parámetro
    public MatrixNxM producto(MatrixNxM b) {
        MatrixNxM resultado = null;
        try {
            //verificar si las dos matrices son compatibles para el producto
            if ((dimension1 == b.dimension2)
                    && (dimension2 == b.dimension1)) {
                resultado = new MatrixNxM(dimension1, b.dimension2);
                for (int fila = 0; fila < dimension1; fila++) {
                    for (int columna = 0; columna < b.dimension2; columna++) {
                        resultado.elementos[fila][columna] = 0;
                        for (int indice = 0; indice < dimension2; indice++) {
                            resultado.elementos[fila][columna] = (elementos[fila][indice] * b.elementos[indice][columna])
                                    + resultado.elementos[fila][columna];
                        }
                    }
                }

            } else {
                //al no ser compatibles para el producto llevamos a cabo la invocación
                //de la excepción no predefinida matricesIncompatibles
                throw new Exception("COMPATIBLE MATRICES FOR THE PRODUCT");
            }
        } catch (Exception error) {
        }
        return resultado;
    }

    //método de clase que lleva a cabo la comparación a nivel de igualdad de dos
    //objetos MatrixNxM dados por parámetro
    public static boolean iguales(MatrixNxM a, MatrixNxM b) {
        //verificar si tienen las mismas dimensiones
        if ((a.dimension1 == b.dimension2)
                && (a.dimension2 == b.dimension2)) {
            //verificar si son iguales elemento a elemento
            for (int fila = 0; fila < a.dimension1; fila++) {
                for (int columna = 0; columna < a.dimension2; columna++) {
                    if (a.elementos[fila][columna] != b.elementos[fila][columna]) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

    //método de objeto que lleva a cabo la comparación a nivel de igualdad un objeto MatrixNxM
    //con otro objeto MatrixNxM dado por parámetro
    public boolean iguales(MatrixNxM b) {
        //verificar si tienen las mismas dimensiones
        if ((dimension1 == b.dimension2)
                && (dimension2 == b.dimension2)) {
            //verificar si son iguales elemento a elemento
            for (int fila = 0; fila < dimension1; fila++) {
                for (int columna = 0; columna < dimension2; columna++) {
                    if (elementos[fila][columna] != b.elementos[fila][columna]) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

    //método que lleva a cabo el cálculo de la matriz traspuesta de un objeto
    //MatrixNxM
    public MatrixNxM traspuesta() {
        MatrixNxM resultado = new MatrixNxM(dimension1, dimension2);
        for (int fila = 0; fila < dimension1; fila++) {
            for (int columna = 0; columna < dimension2; columna++) {
                resultado.elementos[fila][columna] = elementos[columna][fila];
            }
        }
        return resultado;
    }

}
