

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class SleepTest extends Thread {
    public static void main(String[] args) {
        new SleepTest().start();
    }

    public  void run(){
        Calendar cal = Calendar.getInstance();
        Date da=cal.getTime();
        Date dat;
        for(int i=0;i<1;i++){
            System.out.println(da);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cal=Calendar.getInstance();
            System.out.println(da);

        }
    }

}
