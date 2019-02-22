package StringsMix;

import java.util.*;

public class Mixing {

    public static String mix(String s1, String s2) {
        Map<String, Integer> m1 = new TreeMap<>();
        Map<String, Integer> m2 = new TreeMap<>();

        // transforming s1 into a map where key is a lowercase character
        // and value is a number of its occurrences
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (Character.isLowerCase(c)) {
                String e = "" + c;
                if (m1.containsKey(e)){
                    m1.put(e, m1.get(e) + 1);
                } else {
                    m1.put(e, 1);
                }
            }
        }
        // removing those keys where value is < 2
        m1.entrySet().removeIf(entry -> entry.getValue() < 2);

        // transforming s2 into a map where key is a lowercase character
        // and value is a number of its occurrences
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (Character.isLowerCase(c)) {
                String e = "" + c;
                if (m2.containsKey(e)){
                    m2.put(e, m2.get(e) + 1);
                } else {
                    m2.put(e, 1);
                }
            }
        }
        // removing those keys where value is < 2
        m2.entrySet().removeIf(entry -> entry.getValue() < 2);

        // list that will contain all the strings that will then become an outcome string
        // now list due it is easier to sort
        List<String> list = new ArrayList<>();

        // comparing values for the same keys of both maps while iterating through map1
        // adding the composed string to the list, removing passed elements from both maps
        Iterator<Map.Entry<String, Integer>> iterator1 = m1.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, Integer> entry = iterator1.next();
            String m1key = entry.getKey();
            int m1value = entry.getValue();
            String temp = "";
            if (m2.containsKey(m1key)) {
                int m2value = m2.get(m1key);
                if (m2value > m1value) {
                    temp += "2:" + String.join("", Collections.nCopies(m2value, m1key));
                } else if (m1value > m2value) {
                    temp += "1:" + String.join("", Collections.nCopies(m1value, m1key));
                } else {
                    temp += "=:" + String.join("", Collections.nCopies(m1value, m1key));
                }
                iterator1.remove();
                m2.remove(m1key);
            } else {
                temp += "1:" + String.join("", Collections.nCopies(m1value, m1key));
                iterator1.remove();
            }
            list.add(temp);
        }

        // taking the strings that are left in map2
        for (Map.Entry<String, Integer> entry : m2.entrySet()) {
            String m2key = entry.getKey();
            int m2value = entry.getValue();
            String temp = "2:" + String.join("", Collections.nCopies(m2value, m2key));
            list.add(temp);
        }

        // sorting list in appropriate order
        Collections.sort(list, (str1, str2) -> {
            if (str1.substring(2).length() > str2.substring(2).length()){
                return -1;
            } else if (str1.substring(2).length() < str2.substring(2).length()){
                return 1;
            } else return str1.compareTo(str2);
        });

        return String.join("/", list);
    }
}
