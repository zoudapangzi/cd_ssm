package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 时间到字符串
     * @param date
     * @param patten
     * @return
     */
    public static String date2String(Date date,String patten){
        SimpleDateFormat format=new SimpleDateFormat(patten);
        String time = format.format(date);
        return time;
    }

    /**
     * 字符串到时间
     * @param date
     * @param patten
     * @return
     */
    public static Date string2Date(String date,String patten){

        SimpleDateFormat format=new SimpleDateFormat(patten);
        Date parse = null;
        try {
            parse = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

}
