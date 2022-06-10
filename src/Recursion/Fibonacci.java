package Recursion;

/**
 *
 * @author Sergi
 */
public class Fibonacci {

    private final int result;

    /**
     *
     * @param max
     * @throws Exception
     */
    public Fibonacci(int max) throws Exception {
        if (max < 0) {
            throw new Exception("Cannot be negative values");
        }
        this.result = fib(max);
    }

    /**
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     *
     * @return
     */
    public int getResult() {
        return result;
    }

}
