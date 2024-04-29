package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> s = new HashSet<>();
		
		
		String s1 = new String("둘리");
		s.add("둘리");
		s.add("마이콜");
		s.add("도우너");
		s.add(s1); 

		// 내용만 따지게 된다 자료전환. 데이터 등등 
		System.out.println(s.size());
		System.out.println(s.contains(s1));
		
		// 순회는 가능하다 
		
		for(String str : s) {
			System.out.println(str);
		    // 중복을 허용하지 않도록 한다 
			
		}
	}

}
