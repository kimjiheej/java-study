package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			/* 게임 작성 */

			// 정답 램덤하게 만들기
	
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			System.out.println(correctNumber);
			
			
			
			int ans = 0;
			int start = 1;
			int finish = 100;
			int count = 1;
			do {
				
				System.out.println(start+"-"+finish);
				System.out.print(count+++">>");
				ans = scanner.nextInt();
				
			   if(ans > correctNumber) {
				   System.out.println("더 낮게");
				   finish = ans;
			   }
			   else if(ans < correctNumber) {
				   System.out.println("더 높게");
				   start = ans;
			   
			   }
			
			}while(ans != correctNumber);

			System.out.println("맞았습니다.");
			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		
		scanner.close();
	}

}