package find_the_smallest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MoveCharTest {

    private String expectedOutcome;
    private String strParam;
    private int indexTakeFrom;
    private int indexPutOn;

    public MoveCharTest(String expectedOutcome, String strParam, int indexTakeFrom, int indexPutOn) {
        this.expectedOutcome = expectedOutcome;
        this.strParam = strParam;
        this.indexTakeFrom = indexTakeFrom;
        this.indexPutOn = indexPutOn;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> moveCharTestCases(){
        return Arrays.asList(new Object[][]{
                {"codominnium", "condominium", 2, 7},
                {"conndomiium", "condominium", 7, 2},
                {"codominiumn", "condominium", 2, 10},
                {"ncondomiium", "condominium", 7, 0},
                {"condoimnium", "condominium", 5, 6}
        });
    }

    @Test
    public void moveChar(){
        assertEquals(expectedOutcome, ToSmallest.moveChar(strParam, indexPutOn, indexTakeFrom));
    }
}