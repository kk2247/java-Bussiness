package test;

import java.util.Calendar;

public class DateCount {
    public static void main(String[] args){
        Calendar calendar=Calendar.getInstance();
        calendar.set(2016,12,1);
        calendar.add(Calendar.MONTH, 12);
        String deadline=calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DATE);
        System.out.println(deadline);
    }
}
