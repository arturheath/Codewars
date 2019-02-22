package Mixing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MixingTest {

    private String firstStrParam;
    private String secondStrParam;
    private String expectedOutcome;

    public MixingTest(String firstStrParam, String secondStrParam, String expectedOutcome) {
        this.firstStrParam = firstStrParam;
        this.secondStrParam = secondStrParam;
        this.expectedOutcome = expectedOutcome;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> mixTestCases(){
        return Arrays.asList(new Object[][]{
                {"Are they here", "yes, they are here", "2:eeeee/2:yy/=:hh/=:rr"},
                {"looping is fun but dangerous", "less dangerous than coding",
                        "1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg"},
                {" In many languages", " there's a pair of functions", "1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt"},
                {"Lords of the Fallen", "gamekult", "1:ee/1:ll/1:oo"},
                {"codewars", "codewars", ""},
                {"A generation must confront the looming ", "codewarrs", "1:nnnnn/1:ooooo/1:tttt/1:eee/1:gg/1:ii/1:mm/=:rr"}
        });
    }

    @Test
    public void mix() {
        assertEquals(expectedOutcome, Mixing.mix(firstStrParam, secondStrParam));
    }
}