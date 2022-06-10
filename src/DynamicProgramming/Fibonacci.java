package DynamicProgramming;

/**
 *
 * @author Sergi
 */
public class Fibonacci {

    private final int MAX;
    private long[] sequence;

    /**
     *
     * @param max
     * @throws Exception
     */
    public Fibonacci(int max) throws Exception {
        if (max < 0) {
            throw new Exception("Cannot be negative values");
        }
        this.MAX = max - 1;
        this.sequence = new long[max];
    }

    private int fib(int n) {
        int f[] = new int[n + 2];
        int i;
        f[0] = 0;
        f[1] = 1;
        sequence[0] = 0;
        sequence[1] = 1;
        for (i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            sequence[i] = f[i];
        }
        return f[n];
    }

    /**
     *
     * @return
     */
    public long[] getSequence() {
        fib(this.MAX);
        return sequence;
    }

}
