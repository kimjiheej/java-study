package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		
		int a = scanner.nextInt();
		boolean flag = true;
		
		if(a % 2 ==0) // 짝수 
			flag = true;
		else 
			flag = false;
		
		int sum;
		
		if(flag) { // 짝수라면 
			sum = 0;
			for(int i=2; i<=a; i++) {
				if(i % 2 ==0)
					sum += i;
			}
		}
		else {
			sum = 0;
			for(int i=1; i<=a; i++) {
				if(i % 2 != 0)
					sum += i;
			}
		}
		
		System.out.println(sum);
		scanner.close();
	}
}
