package TheMillionthFibonacciKata;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TheMillionthFibonacciKataTest {

    private BigInteger parameter;
    private BigInteger expectedOutput;

    public TheMillionthFibonacciKataTest(BigInteger parameter, BigInteger expectedOutput) {
        this.parameter = parameter;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> fibonacciTestCases(){
        return Arrays.asList(new BigInteger[][]{
                {new BigInteger("5"), new BigInteger("5")},
                {new BigInteger("-6"), new BigInteger("-8")},
                {new BigInteger("-96"), new BigInteger("-51680708854858323072")}
        });
    }

    @org.junit.Test
    public void fib2() {
        assertEquals(expectedOutput, TheMillionthFibonacciKata.fib2(parameter));
    }

    @org.junit.Test
    public void fib() {
        assertEquals(expectedOutput, TheMillionthFibonacciKata.fib2(parameter));
    }
}