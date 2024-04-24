package chapter03;

import mypackage.Value;

public class SwapTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Value i = new Value(10);
		Value j = new Value(20);
		
		System.out.println(i.val+", "+ j.val);
		swap(i,j);
		System.out.println(i.val+", "+ j.val);

	}
	
	private static void swap(Value m, Value n) { // 객체를 넘기게 된다. 
		int temp = m.val;
		m.val = n.val;
		n.val = temp;
	}

}
