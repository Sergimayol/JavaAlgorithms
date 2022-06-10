package MVA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sergi
 */
public class MeanValueAnalysis {

    // Razones de visita
    private final int[] V;
    // Tiempos de servicio
    private final double[] S;
    // Número de dispositivos
    private final int NUM_DISPOSITIVOS;
    // Tiempos de respuesta de cada dispositivo
    private ArrayList<Double> R_i;
    // Utilización de cada dispositivo
    private ArrayList<Double> U_i;
    // Probabilidades de encaminamiento
    private ArrayList<Double> probs;
    // Productividad de los dispositivos
    private ArrayList<Double> X_i;
    // Número de trabajos en el sistema
    private ArrayList<Double> N_i;

    /**
     * Constructor
     */
    public MeanValueAnalysis() {
        this.V = null;
        this.S = null;
        this.NUM_DISPOSITIVOS = 0;
        this.R_i = new ArrayList();
        this.U_i = new ArrayList();
        this.probs = new ArrayList();
        this.X_i = new ArrayList();
        this.N_i = new ArrayList();
    }

    /**
     *
     * @param N
     * @param Z
     * @param K
     * @param Si
     * @param Vi
     */
    public void MVA(int N, int Z, int K, double[] Si, int[] Vi) {
        Double[] Ni = new Double[K];
        Double[] Ri = new Double[K];
        Double[] Xi = new Double[K];
        Double[] Ui = new Double[K];
        double X0 = 0.0;
        double[] Di = new double[K];
        double D = 0;
        for (int i = 0; i < K; i++) {
            Di[i] = Si[i] * Vi[i];
            D += Di[i];
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
            X0 = (n / (R + Z));
            for (int i = 0; i < K; i++) {
                Ni[i] = (X0 * Vi[i] * Ri[i]);
                Ui[i] = (X0 * Vi[i] * Si[i]);
                Xi[i] = (X0 * Vi[i]);
            }
            if (n != 0) {
                System.out.println("Trabajo: " + n);
                System.out.println("Xi: " + Arrays.toString(Xi));
                System.out.println("Ni: " + Arrays.toString(Ni));
                System.out.println("Ri: " + Arrays.toString(Ri));
                System.out.println("Ui: " + Arrays.toString(Ui));
                System.out.println("X0: " + X0);
                System.out.println("R: " + R);
                System.out.println("");
            }
        }
    }
}
