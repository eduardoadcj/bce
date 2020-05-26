
package com.eacj.bceapi.util.tools;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class BasicDateOperator {
    
    /**
     * This method returns the date input on the begining of the day
     * @param input input date
     * @return date on begining of the day
     */
    public static Date getDayBegin(Date input){

        if(input == null)
            return input;

        Calendar i = Calendar.getInstance();
        i.setTime(input);
        i.set(Calendar.HOUR_OF_DAY, 0);
        i.set(Calendar.MINUTE, 0);
        i.set(Calendar.SECOND, 0);
        i.set(Calendar.MILLISECOND, 0);

        return i.getTime();

    }

    /**
     * This method returns the date input on the end of the day
     * @param input input date
     * @return date on end of the day
     */
    public static Date getDayEnd(Date input){

        if(input == null)
            return input;

        Calendar i = Calendar.getInstance();
        i.setTime(input);
        i.set(Calendar.HOUR_OF_DAY, 23);
        i.set(Calendar.MINUTE, 59);
        i.set(Calendar.SECOND, 59);
        i.set(Calendar.MILLISECOND, 59);

        return i.getTime();

    }

    /**
     * Calculates the days between two time periods
     * @param start start date
     * @param end end date
     * @return days between
     */
    public static long getDaysBetween(Date start, Date end){
        return getDaysBetween(start.getTime(), end.getTime());
    }

    /**
     * Calculates the days between two time periods
     * @param start start Calendar date
     * @param end end Calendar date
     * @return days between
     */
    public static long getDaysBetween(Calendar start, Calendar end){
        return getDaysBetween(start.getTimeInMillis(), end.getTimeInMillis());
    }

    /**
     * Calculates the days between two time periods
     * @param start start date in milliseconds
     * @param end end date in milliseconds
     * @return days between
     */
    public static long getDaysBetween(long start, long end){
        return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
    }
    
}
