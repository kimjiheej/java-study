package Exception;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int a = 10;
		int b = 10-a;
		
	   System.out.println(" Some Code1...");
		
		
		try {
			System.out.println(" Some Code2...");
			System.out.println(" Some Code3...");
			
			int result = (1+2+3)/10;
			
			System.out.println(" Some Code4...");
			System.out.println(" Some Code5...");
		}catch(ArithmeticException ex) {
			// 예외 처리 
			
			// 1. 로깅 
			System.out.println("error: "+ ex);
			
			// 2. 사과 
			
			System.out.println("미안합니다.");
			
			// 3. 정상종료 
			
			 return;
		} finally { 
			System.out.println("자원 정리: ex) close file, socket, db connection");
		}
		
		System.out.println(" Some Code6...");
		System.out.println(" Some Code7...");
		
	}

}
