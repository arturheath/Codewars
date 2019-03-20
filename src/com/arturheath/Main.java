package com.arturheath;

import find_the_smallest.ToSmallest;
import pagination_helper.PaginationHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Character> list = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            list.add(i);
        }
        PaginationHelper<Character> paginationHelper = new PaginationHelper<>(list, 10);

        System.out.println(paginationHelper.pageIndex(12));
//        paginationHelper.pageItemCount()


    }



//    private static String knowYourNeighbors(int num) {
//        switch (num) {
//            case 0:
//                return "08";
//            case 1:
//                return "124";
//            case 2:
//                return "1235";
//            case 3:
//                return "236";
//            case 4:
//                return "1457";
//            case 5:
//                return "24568";
//            case 6:
//                return "3569";
//            case 7:
//                return "478";
//            case 8:
//                return "57890";
//            case 9:
//                return "689";
//            default:
//                return null;
//        }
//    }
}
