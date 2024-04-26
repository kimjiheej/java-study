package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode() + " : "+ s2.hashCode()); // 같을 것이다 
	    System.out.println(System.identityHashCode(s1)+" : "+ System.identityHashCode(s2));
		
                     // hashCode 는 내용이 같은 것을 보는 것이다. 
	    
	    System.out.println("==========================================");
	    
	    String s3 = "hello";
	    String s4 = "hello";
	    
	    System.out.println(s3 == s4);
	    System.out.println(s3.equals(s4));
	    System.out.println(s3.hashCode()+":"+s3.hashCode());
	    System.out.println(System.identityHashCode(s3)+": "+ System.identityHashCode(s4));
	    
	}
}
