package ps.edu.diyar.common.tools;

import java.io.PrintStream;

public class TimeConvertor {
    public static String timeFormatConvertor(String timeInSeconds) {
        String timeFormat = "--:--";
        try {
            if (timeInSeconds != null) {
                if (!timeInSeconds.equals("")) {
                    long timeValue = Integer.parseInt(timeInSeconds);
                    long minutes = timeValue / 60;
                    long hours = minutes / 60;
                    long remainMinutes = minutes % 60;
                    if (remainMinutes == 0) {
                        timeFormat = "" + hours + ":00";
                    }
                    if (remainMinutes < 10) {
                        timeFormat = "" + hours + ":0" + remainMinutes;
                    }
                    timeFormat = "" + hours + ":" + remainMinutes;
                    return timeFormat;
                }
            }
        }
        catch (Exception e) {
            System.err.println("Error While converting seconds to hour format " + e);
        }
        finally {
            return timeFormat;
        }
    }

    public static String timeFormatConvertor(Long timeInSeconds) {
        String time = "--:--";
        if (timeInSeconds != null) {
            time = TimeConvertor.timeFormatConvertor(String.valueOf(timeInSeconds));
        }
        return time;
    }

    public static String timeFormatConvertor(Integer timeInSeconds) {
        String time = "--:--";
        if (timeInSeconds != null) {
            time = TimeConvertor.timeFormatConvertor(String.valueOf(timeInSeconds));
        }
        return time;
    }
}