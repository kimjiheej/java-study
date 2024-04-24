package chapter03;

public class StaticMethod {
	
	int n;
	static int m;
	
	void f1() {
		n = 10;
		
	}
	
	void f2() {
	   StaticMethod.m = 10;
	   
	   
	   // 편의를 봐준다. 원칙적으로는 클래스 이름으로 해야한다.
	   // 같은 클래스의 클래스(static) 변수 접근에서는 클래스 이름 생략 가능 
	   m = 20;
	}
	
    void f3() {
    	f2();
    }
    
    void f4() {
    	StaticMethod.s1();
    	
    	s1();
    }
    
    
    static void s1() {
    	
    	// Error : static method 에서는 instance 변수에 접근이 불가하다. 
    	// n = 10;
    }
    
    static void s2() {
    	// f1(); -> 에러가 발생하게 된다. 
    }
    
    static void s3() {
    	StaticMethod.m = 10;
    	
    	m = 10;
    	
    }
    
    static void s4() {
    	StaticMethod.s1();
    	
    	// 같은 클래스의 클래스 메소드 접근에서는 클래스 이름을 생략 가능하다. 
    	s1();
    }
    
}
