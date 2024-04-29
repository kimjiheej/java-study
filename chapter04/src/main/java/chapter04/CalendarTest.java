package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	     // Calendar 은 추상으로 만들어져 있다. 추상이 되는 이유는 구현 안된 클래스가 있기 때문이다. 
		// 구현이 안된 클래스가 있나? 
		
	   // i 18 n Locale 을 적어놓으면 많이 잡히게 된다 
		
	   Calendar cal = Calendar.getInstance();
	   
//	   Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
//	   TimeZone tz = TimeZone.getDefault();
	 //  System.out.println(aLocale+":" + tz);
	   
	   System.out.println(cal);
	   
	   printDate(cal);
	   
	   cal.set(Calendar.YEAR, 2024);
	   cal.set(Calendar.MONDAY, 11); // 12월(Month -1) 
	   cal.set(Calendar.DATE, 25);
	   printDate(cal);
	   
	   cal.set(2001, 03, 04);
	   cal.add(Calendar.DATE, 10000);
	}

	private static void printDate(Calendar cal) {
		// TODO Auto-generated method stub
		
		final String[] DAYS = {"일","월","화","수","목","금","토"};
		
		int year = cal.get(Calendar.YEAR);
		
	    int month = cal.get(Calendar.MONDAY);
	    
	    int date = cal.get(Calendar.DATE);
	    
	    int day = cal.get(Calendar.DAY_OF_WEEK);  // 1(일) ~ 7 (
	    
	    int hour = cal.get(Calendar.HOUR);
	    
	    int minute = cal.get(Calendar.MINUTE);
	    
	    int second = cal.get(Calendar.SECOND);
	    
	    System.out.println(year + " 년 " + (month+1) + "월 " + date + "일 " + DAYS[day-1] + "요일 "  + hour + "시 "+ minute + "분 "+ second + "초");
	}

}
