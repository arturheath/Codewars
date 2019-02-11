package HumanReadableDurationFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeFormatter {
    public static String formatDuration(int seconds) {
        if (seconds == 0) return "now";

        int years;
        int months;
        int days;
        int hours;
        int minutes;
        int secsInMin = 60;
        int minsInHour = 60;
        int hoursInDay = 24;
        int daysInMonth = 30;
        int monthsInYear = 12;

        List<String> timeNames = Arrays.asList("year", "month", "day", "hour", "minute", "second");
        List<Integer> time = new ArrayList<>();

        years = seconds / secsInMin / minsInHour / hoursInDay / daysInMonth / monthsInYear;
        time.add(years);
        if (years == 0){
            months = seconds / secsInMin / minsInHour / hoursInDay / daysInMonth;
            time.add(months);
        } else {
            seconds = seconds - years * secsInMin * minsInHour * hoursInDay * daysInMonth * monthsInYear;
            months = seconds / secsInMin / minsInHour / hoursInDay / daysInMonth;
            time.add(months);
        }

        if (months == 0){
            days = seconds / secsInMin / minsInHour / hoursInDay;
            time.add(days);
        } else {
            seconds = seconds - months * secsInMin * minsInHour * hoursInDay * daysInMonth;
            days = seconds / secsInMin / minsInHour / hoursInDay;
            time.add(days);
        }

        if (days == 0){
            hours = seconds / secsInMin / minsInHour;
            time.add(hours);
        } else {
            seconds = seconds - days * secsInMin / minsInHour / hoursInDay;
            hours = seconds / secsInMin / minsInHour;
            time.add(hours);
        }

        if (hours == 0){
            minutes = seconds / secsInMin;
            time.add(minutes);
        } else {
            seconds = seconds - hours * secsInMin * minsInHour;
            minutes = seconds / secsInMin;
            time.add(minutes);
        }

        if (minutes != 0){
            seconds = seconds - minutes * secsInMin;
        }
        time.add(seconds);

        String result = "";
        int countNonZeros = 0;
        for (int i = time.size() - 1; i >= 0; i--) {
            int timeNum = time.get(i);
            String timeName = timeNames.get(i);
            if (timeNum != 0){
                countNonZeros++;
            }
            if (timeNum != 0 && countNonZeros == 1){
                if (timeNum > 1){
                    result = " and " + timeNum + " " + timeName + "s" + result;
                } else {
                    result = " and " + timeNum + " " + timeName + result;
                }
            }else if (timeNum != 0){
                if (timeNum > 1){
                    result = ", " + timeNum + " " + timeName + "s" + result;
                } else {
                    result = ", " + timeNum + " " + timeName + result;
                }

            }
        }

        if (result.charAt(0) == ','){
            return result.substring(2);
        } else if (result.substring(0, 5).equals(" and ")){
            return result.substring(5);
        }
        else return result;
    }
}
