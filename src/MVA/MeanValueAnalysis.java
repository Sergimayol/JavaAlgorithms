package MVA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sergi
 */
public class MeanValueAnalysis {

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

    public MeanValueAnalysis(int[] v, double[] s) throws Exception {
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

    public static void MVA(int N, int Z, int K, double[] Si, int[] Vi) {
        int N = 3 + 1;
        int Z = 5;
        int K = 3;
        double[] Si = {0.03, 0.5, 0.0};
        int[] Vi = {15, 14, 0};
       // MVA.MeanValueAnalysis(N, Z, K, Si, Vi);
        
        Double[] Ni = new Double[K];
        Double[] Ri = new Double[K];
        Double[] Xi = new Double[K];
        double X0 = 0.0;
        double[] Di = new double[K];
        double D = 0;
        double Dmax = -1;
        List<Double> _list_X0 = new ArrayList<Double>();
        List<Double> _list_R = new ArrayList<Double>();
        for (int i = 0; i < K; i++) {
            Di[i] = Si[i] * Vi[i];
            D += Di[i];
            if (Di[i] > Dmax) {
                Dmax = Di[i];
            }
        }
        for (int i = 0; i < K; i++) {
            Ni[i] = 0.0;
            Ri[i] = 0.0;
        }
        for (int n = 0; n < N; n++) {
            for (int i = 0; i < K; i++) {
                Ri[i] = Si[i] * (1 + Ni[i]);
            }
            double R = 0.0;
            for (int i = 0; i < K; i++) {
                R += Ri[i] * Vi[i];
            }
            _list_R.add(R);
            X0 = (n / (R + Z));
            _list_X0.add(X0);
            for (int i = 0; i < K; i++) {
                Ni[i] = (X0 * Vi[i] * Ri[i]);
                Xi[i] = (X0 * Vi[i]);
            }
            System.out.println("Xi: " + Arrays.toString(Xi));
            System.out.println("Ni: " + Arrays.toString(Ni));
            System.out.println("Ri: " + Arrays.toString(Ri));
            System.out.println("X0: " + X0);
            System.out.println("_list_R: " + _list_R);
            System.out.println("_list_X0: " + _list_X0);
            System.out.println("R: " + R);
        }

    }
}
