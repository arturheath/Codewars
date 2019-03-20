package find_the_smallest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ToSmallest {
    public static long[] smallest(long initNumber) {
        String strInitNumber = String.valueOf(initNumber);
        Map<Long, Integer> indexesPutOn = new HashMap<>();
        Map<Long, Integer> indexesTakeFrom = new HashMap<>();
        for (int i = 0; i < strInitNumber.length(); i++) {
            for (int j = 0; j < strInitNumber.length(); j++) {
                if (i == j) continue;
                long newNumber = Long.parseLong(moveChar(strInitNumber, i, j));
                if (newNumber < initNumber) {
                    indexesTakeFrom.putIfAbsent(newNumber, i);
                    indexesPutOn.putIfAbsent(newNumber, j);
                }
            }
        }
        if (!indexesPutOn.isEmpty()) {
            // get smallest found number
            long smallestNumber = Collections.min(indexesPutOn.keySet());
            int indexTakeFrom = indexesTakeFrom.get(smallestNumber);
            int indexPutOn = indexesPutOn.get(smallestNumber);
            // if they go one after another and indexToPut is bigger
            if (indexTakeFrom - indexPutOn == 1) {
                return new long[]{smallestNumber, indexPutOn, indexTakeFrom};
            } else {
                return new long[]{smallestNumber, indexTakeFrom, indexPutOn};
            }
        } else {
            return null;
        }
    }

    public static String moveChar(String string, int indexTakeFrom, int indexPutOn) {
        int end = string.length() - 1;
        String result;
        if (indexPutOn == indexTakeFrom) {
            return string;
        } else if (Math.abs(indexPutOn - indexTakeFrom) == 1) {
            char[] chars = string.toCharArray();
            char temp = chars[indexPutOn];
            chars[indexPutOn] = chars[indexTakeFrom];
            chars[indexTakeFrom] = temp;
            result = new String(chars);
        } else if (indexTakeFrom < indexPutOn) {
            result = string.substring(0, indexTakeFrom)
                    + string.substring(indexTakeFrom + 1, indexPutOn + 1)
                    + string.charAt(indexTakeFrom);
            if (indexPutOn != end) result += string.substring(indexPutOn + 1);
        } else {
            result = string.substring(0, indexPutOn)
                    + string.charAt(indexTakeFrom)
                    + string.substring(indexPutOn, indexTakeFrom);
            if (indexTakeFrom != end) result += string.substring(indexTakeFrom + 1);
        }
        return result;
    }
}
