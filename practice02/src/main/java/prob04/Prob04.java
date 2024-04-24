package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		
		char[] ch = str.toCharArray();
		
		for(int i=0; i<str.length()/2; i++) {
			char tmp = ch[i];
			ch[i] = ch[str.length()-1-i];
			ch[str.length()-1-i] = tmp;
		}
		/* 코드를 완성합니다 */
		return ch;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}