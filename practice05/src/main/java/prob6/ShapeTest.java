package prob6;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		List<Shape> list = new ArrayList<Shape>();
		
		
		
		list.add( new Rectangle(5, 6) );
		list.add( new RectTriangle( 6, 2) );
		
		
		
		for( Shape shapes : list ) {
			System.out.println( "area: " + shapes.getArea() );
			System.out.println( "perimeter: " + shapes.getPerimeter() );
			
			
			
			if( shapes instanceof Resizable ) {
				Resizable resizable = (Resizable) shapes;
				resizable.resize( 0.5 );
				System.out.println( "new area: " + shapes.getArea() );
				System.out.println( "new perimeter: " + shapes.getPerimeter() );
			}
		}
	}
}

