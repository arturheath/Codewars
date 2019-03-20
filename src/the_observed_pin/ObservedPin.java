//package the_observed_pin;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ObservedPin {
//
//    public static List<String> getPINs(String observed) {
//
//        List<String> neighbors = new ArrayList<>();
//        for (int i = 0; i < observed.length(); i++) {
//            neighbors.add(knowYourNeighbors(observed.charAt(i) - '0'));
//        }
//
//        int index = 0;
//        while (true){
//            String str = "";
//            if (index < neighbors.size()){
//                str += getDig(neighbors.get(index), )
//            }
//        }
//        return null;
//    }
//
//    private static String getDig(String str, int indx){
//        return String.valueOf(str.charAt(indx));
//    }
//
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
//}
