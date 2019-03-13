package human_readable_duration_format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeFormatter {

    public static final int secsInMin = 60;
    public static final int minsInHour = 60;
    public static final int hoursInDay = 24;
    public static final int daysInYear = 365;

    public static int countYears(int secs){
        return secs / secsInMin / minsInHour / hoursInDay / daysInYear;
    }

    public static int countDays(int secs){
        return secs / secsInMin / minsInHour / hoursInDay;
    }

    public static int countHours(int secs){
        return secs / secsInMin / minsInHour;
    }

    public static int countMinutes(int secs){
        return secs / secsInMin;
    }

    public static int getSecondsInYear(int years){
        return years * secsInMin * minsInHour * hoursInDay * daysInYear;
    }

    public static int getSecondsInDay(int days){
        return days * secsInMin * minsInHour * hoursInDay;
    }

    public static int getSecondsInHour(int hours){
        return hours * secsInMin * minsInHour;
    }

    public static int getSecondsInMinute(int minutes){
        return minutes * secsInMin;
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0) return "now";

        int years;
        int days;
        int hours;
        int minutes;

        List<String> timeNames = Arrays.asList("year", "day", "hour", "minute", "second");
        List<Integer> time = new ArrayList<>();

        years = countYears(seconds);
        time.add(years);
        if (years == 0){
            days = countDays(seconds);
            time.add(days);
        } else {
            seconds = seconds - getSecondsInYear(years);
            days = countDays(seconds);
            time.add(days);
        }

        if (days == 0){
            hours = countHours(seconds);
            time.add(hours);
        } else {
            seconds = seconds - getSecondsInDay(days);
            hours = countHours(seconds);
            time.add(hours);
        }

        if (hours == 0){
            minutes = countMinutes(seconds);
            time.add(minutes);
        } else {
            seconds = seconds - getSecondsInHour(hours);
            minutes = countMinutes(seconds);
            time.add(minutes);
        }

        if (minutes != 0){
            seconds = seconds - getSecondsInMinute(minutes);
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
