package com.arturheath;

import find_the_smallest.ToSmallest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {




        String word = "111";
        List<String> pins = new ArrayList<>();

        int one = word.charAt(0) - '0';
        String oneAndNeighbors = knowYourNeighbors(one);

        int two = word.charAt(1) - '0';
        String twoAndNeighbors = knowYourNeighbors(two);

        int three = word.charAt(2) - '0';
        String threeAndNeighbors = knowYourNeighbors(three);


        for (int j = 0; j < oneAndNeighbors.length(); j++) {
            char c = oneAndNeighbors.charAt(j);
            String pin = "" + c;

            for (int i = 0; i < twoAndNeighbors.length(); i++) {
                char c2 = twoAndNeighbors.charAt(i);
                pin += c2;

                for (int k = 0; k < threeAndNeighbors.length(); k++) {
                    char c3 = threeAndNeighbors.charAt(k);
                    pin += c3;
                    System.out.println(pin);
                    pins.add(pin);
                    pin = pin.substring(0, 2);
                }
                pin = pin.substring(0, 1);
            }
        }
    }



    private static String knowYourNeighbors(int num) {
        switch (num) {
            case 0:
                return "08";
            case 1:
                return "124";
            case 2:
                return "1235";
            case 3:
                return "236";
            case 4:
                return "1457";
            case 5:
                return "24568";
            case 6:
                return "3569";
            case 7:
                return "478";
            case 8:
                return "57890";
            case 9:
                return "689";
            default:
                return null;
        }
    }
}
