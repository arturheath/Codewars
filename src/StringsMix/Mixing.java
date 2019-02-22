package Mixing;

import java.util.*;

public class Mixing {

    public static String mix(String s1, String s2) {
        Map<String, Integer> m1 = new TreeMap<>();
        Map<String, Integer> m2 = new TreeMap<>();

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
        m1.entrySet().removeIf(entry -> entry.getValue() < 2);

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
        m2.entrySet().removeIf(entry -> entry.getValue() < 2);

        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
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
                m1.remove(m1key);
                m2.remove(m1key);
            } else {
                temp += "1:" + String.join("", Collections.nCopies(m1value, m1key));
                m1.remove(m1key);
            }
            list.add(temp);
        }

        for (Map.Entry<String, Integer> entry : m2.entrySet()) {
            String m2key = entry.getKey();
            int m2value = entry.getValue();
            String temp = "2:" + String.join("", Collections.nCopies(m2value, m2key));
            list.add(temp);
        }

        Collections.sort(list, (str1, str2) -> {
            if (str1.substring(2).length() > str2.substring(2).length()){
                return 1;
            } else if (str1.substring(2).length() < str2.substring(2).length()){
                return -1;
            } else return str1.compareTo(str2);
        });

        return String.join("", list);
    }
}
