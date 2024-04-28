package chapter04;

public class StringTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// immutability(불변성) 

		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		
		s2 =  s1.toUpperCase(); // upperCase 된 새로운 애를 만들어서 return 을 해주는 아이이다. 
		String s4 = s2.concat("??");
		
	    String temp = "@";
	    
	    String s5 = "!".concat(s2).concat(temp);
	    
	    
	    System.out.println(s1);
	    System.out.println(s2);
	    System.out.println(s3);
	    System.out.println(s4);
	    System.out.println(s5);
	    
	    System.out.println(equalsHello("hello"));
	    
	    
	}

	private static boolean equalsHello(String s) {
		return "hello".equals(s);
	}
	
	
}
