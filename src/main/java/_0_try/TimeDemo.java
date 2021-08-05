package _0_try;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeDemo {

	public static void main(String[] args) {

		Time time = new Time(0);
		System.out.println(time);
		
		

	//  直接格式化輸出現在時間的方法
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		Timestamp timestamp = new Timestamp(0);
		System.out.println(sdFormat.format(timestamp));
		
		SimpleDateFormat sdFormat2 = new SimpleDateFormat("HH:mm");
		Timestamp timestamp2 = new Timestamp(3600000);
		System.out.println(sdFormat2.format(timestamp2));
	}

}
