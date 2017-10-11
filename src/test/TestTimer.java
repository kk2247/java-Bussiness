package test;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String[] args){
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i=10;
            public void run() {
                System.out.println(i--);
                if(i<0){
                    timer.cancel();
                }
            }
        }, 0, 1000);

//        timer.schedule(new TimerTask() {
//            public void run() {
//                System.out.println("-------设定要指定任务--------");
//                System.out.println(timer.purge());
//            }
//        }, 2000,1000);// 设定指定的时间time,此处为2000毫秒
    }
}
