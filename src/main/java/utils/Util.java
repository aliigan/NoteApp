package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static String dateTimeNow(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
