package 蓝桥;

import java.util.Calendar;

public class 世纪末的星期 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        for (int i = 1999; i < 10000; i+=100) {
            calendar.set(i,11,31);
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            if (week == 1) {
                System.out.println(i);
                break;
            }
        }
    }
}
