package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		System.out.print("금액 : ");
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		int money = scanner.nextInt();
		
		for(int i=0; i<MONEYS.length; i++) {
			System.out.print(MONEYS[i]+"원 :");
			
			int k = money / MONEYS[i];
			int j = money % MONEYS[i];
			System.out.println(k+"개");
		    money = j;
		}

		scanner.close();
 	}
	
}