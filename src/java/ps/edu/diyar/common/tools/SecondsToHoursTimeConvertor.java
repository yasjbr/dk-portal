/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Logger
 */
package ps.edu.diyar.common.tools;

import org.apache.log4j.Logger;

public class SecondsToHoursTimeConvertor {
    private static Logger logger = Logger.getLogger((Class)SecondsToHoursTimeConvertor.class);

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
            logger.error((Object)("Error While converting seconds to hour format " + e));
        }
        finally {
            return timeFormat;
        }
    }

    public static int timeFormatConvertorToSeconds(String formatedTime) {
        int timeSeconds = -1;
        try {
            if (formatedTime != null) {
                if (!formatedTime.equals("")) {
                    int hours = Integer.parseInt(formatedTime.substring(0, formatedTime.indexOf(":")));
                    int minutes = Integer.parseInt(formatedTime.substring(formatedTime.indexOf(":") + 1));
                    timeSeconds = hours * 3600 + minutes * 60;
                    return timeSeconds;
                }
            }
        }
        catch (Exception e) {
            logger.error((Object)("Error While converting formated time to seconds " + e));
        }
        finally {
            return timeSeconds;
        }
    }
}