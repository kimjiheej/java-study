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
		
	   Calendar.getInstance();
	   
//	   Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
//	   TimeZone tz = TimeZone.getDefault();
	 //  System.out.println(aLocale+":" + tz);
	   
	   System.out.println();
	   
	   
	}

}
