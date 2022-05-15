package MVA;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Sergi
 */
public class MVA {

    //Razones de visita
    private final int[] V;
    //Tiempos de servicio
    private final double[] S;
    //Número de dispositivos
    private final int NUM_DISPOSITIVOS;
    //Tiempos de respuesta de cada dispositivo
    private ArrayList<Double> R_i;
    //Utilización de cada dispositivo
    private ArrayList<Double> U_i;
    //Probabilidades de encaminamiento
    private ArrayList<Double> probs;
    //Productividad de los dispositivos
    private ArrayList<Double> X_i;
    //Número de trabajos en el sistema
    private ArrayList<Double> N_i;

    public MVA(int[] v, double[] s) throws Exception {
        this.V = v;
        this.S = s;
        if (this.S.length != this.V.length) {
            throw new Exception();
        }
        this.NUM_DISPOSITIVOS = v.length;
        this.R_i = new ArrayList();
        this.U_i = new ArrayList();
        this.probs = new ArrayList();
        this.X_i = new ArrayList();
        this.N_i = new ArrayList();
    }

    private void R_i() {
        double aux;
        for (int i = 0; i < this.NUM_DISPOSITIVOS; i++) {
            aux = this.S[i] / (1 - this.U_i.get(i));
            this.R_i.add(aux);
        }
    }

    private double R() {
        double R = 0;
        for (int i = 0; i < this.NUM_DISPOSITIVOS; i++) {
            R += this.V[i] * this.R_i.get(i);
        }
        return R;
    }

    private void N_i() {
        double aux;
        for (int i = 0; i < this.NUM_DISPOSITIVOS; i++) {
            aux = this.X_i.get(0) * this.V[i] * this.R_i.get(i);
            this.N_i.add(aux);
        }
    }

    private void X_i() {
        double aux;
        for (int i = 1; i < this.NUM_DISPOSITIVOS; i++) {
            aux = this.X_i.get(0) * this.probs.get(i);
            this.X_i.add(aux);
        }
    }

    private double X(double D_b) {
        double aux = (1 / D_b) / this.probs.get(0);
        this.X_i.add(aux);
        return aux;
    }

    private void U_i() {
        double aux;
        for (int i = 0; i < this.NUM_DISPOSITIVOS; i++) {
            aux = this.X_i.get(i) * this.S[i];
            this.U_i.add(aux);
        }
    }

    private void calcProbs() {
        for (int i = 0; i < this.NUM_DISPOSITIVOS; i++) {
            double res;
            if (i != 0) {
                res = this.V[i] / this.V[0];
            } else {
                res = 1 / this.V[0];
            }
            this.probs.add(res);
        }
    }

    public void calcMVA() {
        calcProbs();
        double X = X(0.1);
        System.out.println(X);
        X_i();
        U_i();
        R_i();
        double R = R();
        System.out.println(R);
        
        N_i();
        
    }

    public int[] getV() {
        return V;
    }

    public double[] getS() {
        return S;
    }

    public int getNUM_DISPOSITIVOS() {
        return NUM_DISPOSITIVOS;
    }

    public ArrayList<Double> getR_i() {
        return R_i;
    }

    public ArrayList<Double> getU_i() {
        return U_i;
    }

    public ArrayList<Double> getProbs() {
        return probs;
    }

    public ArrayList<Double> getX_i() {
        return X_i;
    }

    public ArrayList<Double> getN_i() {
        return N_i;
    }

    @Override
    public String toString() {
        return "MVA{" + "V=" + Arrays.toString(V) + ",\n S=" + Arrays.toString(S)
                + ",\n NUM_DISPOSITIVOS=" + NUM_DISPOSITIVOS
                + ",\n R_i=" + R_i
                + ",\n U_i=" + U_i
                + ",\n probs=" + probs
                + ",\n X_i=" + X_i
                + ",\n N_i=" + N_i
                + '}';
    }

}
