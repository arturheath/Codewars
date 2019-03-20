package find_the_smallest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SmallestTest {

    private String smallestExpectedOutput;
    private long smallestParameter;

    public SmallestTest(String smallestExpectedOutput, long smallestParameter) {
        this.smallestExpectedOutput = smallestExpectedOutput;
        this.smallestParameter = smallestParameter;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> smallestTestCases(){
        return Arrays.asList(new Object[][]{
                {"[126235, 2, 0]", 261235},
                {"[29917, 0, 1]", 209917},
                {"[238565, 3, 1]", 285365},
                {"[26945, 3, 0]", 269045},
                {"[239687, 4, 1]", 296837},
                {"[119989884756, 4, 0]",199819884756L},
                {"[29917, 0, 1]", 209917},
                {"[358557539, 0, 8]", 935855753}
        });
    }

    @Test
    public void smallest(){
        assertEquals(smallestExpectedOutput, Arrays.toString(ToSmallest.smallest(smallestParameter)));
    }


}