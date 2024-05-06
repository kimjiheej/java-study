package prob5;

public class MainApp02 {

	// resize 해서 
	public static void main(String[] args) {
		try {
			MyStack02 s = new MyStack02(3);
			s.push("Hello");
			s.push("World");
			s.push("!!!");
			s.push("java");
			s.push(".");

			while (s.isEmpty() == false) {
				String str = (String)s.pop();
				System.out.println( str );
			}

			System.out.println("======================================");

			s = new MyStack02(3);
			s.push("Hello");
			
			System.out.println(s.pop());
			System.out.println(s.pop());
		} catch (MyStackException ex) {
			System.out.println(ex);
		}
	}

}
