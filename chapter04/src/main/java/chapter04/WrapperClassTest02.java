package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "123456";
		
	int i = 	Integer.parseInt(s);
		
	// cf1. 반대로 
	
	String s1 =  String.valueOf(i);
	
	// cf2. 반대로 
	
	String s2 = "" + i;
	
	
		
		System.out.println(s+ ":" + s1 + ":" + s2);

		int a = Character.getNumericValue('A'); // 
		System.out.println(a); // 16 진수를 출력 
		
		// cf : ASCII 코드값 출력 
		char c = 'A';
		System.out.println((int)c);
		
		// 2진수 
	String s4 = Integer.toBinaryString(-15); // 정수가 메모리상에 어떻게 저장이 되는 지를 잘 봐야한다 
	
	System.out.println(s4);
	
	
	// 16 진수 
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
		
		
		
		
	}

}
