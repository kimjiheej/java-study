package prob06;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while( true ) {
			/*  코드를 완성 합니다 */
			System.out.print( ">> " );
			String expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				break;
			}
			String[] tokens = expression.split( " " );
			
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt( tokens[ 0 ] );
			int rValue = Integer.parseInt( tokens[ 2 ] );
			
			
			Arith arith = null;
			
			switch( tokens[ 1 ] ) {
				case "+" : {
					
					/*
					 arith = new Add()
					 
					 */
					arith = new Add();
					arith.setValue( lValue, rValue );
					int result = arith.calculate();
					System.out.println( ">> " + result );
					
					break;
				}
				case "-" : {
					arith = new Sub();
					arith.setValue( lValue, rValue );
					int result = arith.calculate();
					System.out.println( ">> " + result );
					
					break;
				}
				case "*" : {
					arith = new Mul();
				    arith.setValue( lValue, rValue );
					int result = arith.calculate();
					System.out.println( ">> " + result );
					
					break;					
				}
				case "/" : {
					arith = new Div();
					arith.setValue( lValue, rValue );
					int result = arith.calculate();
					System.out.println( ">> " + result );
					
					break;
				}
				default :  {
					System.out.println( ">> 알 수 없는 연산입니다.");
				}
			}
		}
		
		/*
		 if(arith != null)
		    refactoring 을 해보아라...! setValue 는 구현이 되어야 한다 
		 */
		
		scanner.close();

	}

}
