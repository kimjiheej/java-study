package chapter03;

public class SwapTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 10;
		int j = 20;
		
		System.out.println(i+","+j);
		swap(i,j);
		System.out.println(i+","+j);
	}

	private static void swap(int m, int n) {
		// TODO Auto-generated method stub
	     int temp = m;
	     m = n;
	     n = temp;
	}
}

/*
 
 
 call by value -> 값으로 넘기느냐. 아무 변화가 없게 된다. 
 call by reference -> 레퍼런스로 넘기느냐의 차이이다. -> 그렇기 때문에 객체로 넘겨주어야 한다. 
 
 */
