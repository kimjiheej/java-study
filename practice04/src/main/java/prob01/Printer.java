package prob01;

public class Printer {
	
//	public void println(int a) {
//		System.out.println(a);
//	}
//	public void println(boolean check) {
//		System.out.println(check);
//	}
//	public void println(double a) {
//		System.out.println(a);
//	}
//	public void println(String name) {
//		System.out.println(name);
//	}
//	
	
	public <T> void println(T t) { // generic 파라미터를 안 쓰는 것이다 
		System.out.println(t);
	}
	
	public <T> void println(T...ts) {
		for(T t : ts) {
		System.out.println(t);
		}
	}
	
	public int sum(Integer... nums) {
		int s = 0;
		
		for(Integer n : nums) {
			s += n;
		}
		
		return s;
	}
}
