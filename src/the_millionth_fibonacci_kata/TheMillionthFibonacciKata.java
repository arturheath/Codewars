package the_millionth_fibonacci_kata;

import java.math.BigInteger;

public class TheMillionthFibonacciKata {




    public static BigInteger fib2(BigInteger n) {
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        if (n.equals(zero)) {
            return zero;
        } else if (n.equals(one)) {
            return one;
        } else if (n.compareTo(zero) < 0) {
            for (int i = 0; i >= n.longValue(); i--) {
                BigInteger temp = one.subtract(zero);
                one = zero;
                zero = temp;
            }
        } else {
            for (int i = 2; i <= n.longValue(); i++) {
                BigInteger temp = one.add(zero);
                zero = one;
                one = temp;
            }
        }
        return one;
    }

    public static BigInteger fib(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        } else if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else if (n.compareTo(BigInteger.ZERO) < 0) {
            return fib(new BigInteger(String.valueOf(Long.valueOf(n.toString()) + 2))
                    .subtract(fib(new BigInteger(String.valueOf(Long.valueOf(n.toString()) + 1)))));
        } else {
            return fib(new BigInteger(String.valueOf(Long.valueOf(n.toString()) - 1)))
                    .add(fib(new BigInteger(String.valueOf(Long.valueOf(n.toString()) - 2))));
        }
    }
}
