package pagination_helper;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PaginationHelperTest {

    private PaginationHelper<Character> paginationHelper;

    @Before
    public void setUp(){
        List<Character> list = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            list.add(i);
        }
        paginationHelper = new PaginationHelper<>(list, 10);
    }

    @Test
    public void itemCount() {
        assertEquals(26, paginationHelper.itemCount());
    }

    @Test
    public void pageCount() {
        assertEquals(3, paginationHelper.pageCount());
    }

    @Test
    public void pageItemCount() {
        assertEquals(10, paginationHelper.pageItemCount(1));
    }

    @Test
    public void pageIndex() {
        assertEquals(1, paginationHelper.pageIndex(12));
    }
}