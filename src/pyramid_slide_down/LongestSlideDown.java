package pyramid_slide_down;

import java.util.Arrays;

public class LongestSlideDown {

    public static int longestSlideDown(int[][] pyramid) {
        int result = 0;
        int index = 0;
        for (int i = 0; i < pyramid.length; i++) {
            int[] row = pyramid[i];
            if (i == 0) {
                index = 0;
            } else if (row[index] < row[index+1]) {
                index++;
            }
            result += row[index];
        }
        return result;
    }
}
