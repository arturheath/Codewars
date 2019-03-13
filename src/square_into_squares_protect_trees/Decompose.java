package square_into_squares_protect_trees;

import java.util.*;

public class Decompose {
    public String decompose(long n) {
        StringBuilder result = new StringBuilder();
        for (long i = n; i > 0; i--) {
            long addendOfN = i - 1;
            long nSquare = (long) Math.pow(n, 2);
            List<Long> addends = new ArrayList<>();
            long sumOfNAddendsSquares = 0;
            while (nSquare != sumOfNAddendsSquares) {
                addends.add(addendOfN);
                sumOfNAddendsSquares += (long) Math.pow(addendOfN, 2);
                addendOfN = (long) Math.sqrt(nSquare - sumOfNAddendsSquares);
                if (addendOfN == 1) {
                    addends.add(addendOfN);
                    sumOfNAddendsSquares += addendOfN;
                    break;
                }
            }
            if (sumOfNAddendsSquares == nSquare) {
                Set<Long> set = new HashSet<>(addends);
                if (set.size() == addends.size()) {
                    Collections.sort(addends);
                    addends.forEach(number -> {
                        result.append(" ");
                        result.append(number);
                    });
                    return result.toString().trim();
                }
            }
        }
        return null;
    }
}