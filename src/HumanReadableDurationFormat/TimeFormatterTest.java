package HumanReadableDurationFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TimeFormatterTest {

    private String expectedOutput;
    private int parameter;

    public TimeFormatterTest(String expectedOutput, int parameter){
        this.parameter = parameter;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> timeFormatterTestCases(){
        return Arrays.asList(new Object[][]{
                {"1 second", 1},
                {"1 minute and 2 seconds", 62},
                {"2 minutes", 120},
                {"1 hour", 3600},
                {"1 hour, 1 minute and 2 seconds", 3662}

        });
    }



    @Test
    public void formatDuration() {
        assertEquals(expectedOutput, TimeFormatter.formatDuration(parameter));
    }
}