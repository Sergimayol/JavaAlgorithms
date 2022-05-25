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

    public void MVA(int N, int Z, int K, double[] Si, int[] Vi) {
        Double[] Ni = new Double[K];
        Double[] Ri = new Double[K];
        Double[] Xi = new Double[K];
        Double[] Ui = new Double[K];
        double X0 = 0.0;
        double[] Di = new double[K];
        double D = 0;
        List<Double> _list_X0 = new ArrayList<Double>();
        List<Double> _list_R = new ArrayList<Double>();
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
            _list_R.add(R);
            X0 = (n / (R + Z));
            _list_X0.add(X0);
            for (int i = 0; i < K; i++) {
                Ni[i] = (X0 * Vi[i] * Ri[i]);
                Ui[i] = (X0 * Vi[i] * Si[i]);
                Xi[i] = (X0 * Vi[i]);
            }
            System.out.println("Xi: " + Arrays.toString(Xi));
            System.out.println("Ni: " + Arrays.toString(Ni));
            System.out.println("Ri: " + Arrays.toString(Ri));
            System.out.println("Ui: " + Arrays.toString(Ui));
            System.out.println("X0: " + X0);
            System.out.println("_list_R: " + _list_R);
            System.out.println("_list_X0: " + _list_X0);
            System.out.println("R: " + R);
        }
    }
}
