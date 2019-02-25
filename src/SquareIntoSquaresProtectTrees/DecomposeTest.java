package SquareIntoSquaresProtectTrees;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class DecomposeTest {

    private static Decompose decompose;
    private String expectedOutcome;
    private long parameter;

    public DecomposeTest(String expectedOutcome, long parameter) {
        this.expectedOutcome = expectedOutcome;
        this.parameter = parameter;
    }

    @BeforeClass
    public static void setUp(){
        decompose = new Decompose();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> decomposeTestCases(){
        return Arrays.asList(new Object[][]{
                {"1 2 4 10", 11},
                {"1 2 3 7 9", 12},
                {"2 5 14", 15}
        });
    }

    @Test
    public void decompose() {
        assertEquals(expectedOutcome, decompose.decompose(parameter));
    }
}