package paint;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	Point point = new Point(10,20);
	//	point.setX(10);
	//	point.setY(20);
	//	drawPoint(point);
	//	point.show(false);
		
	//	draw(point);
	//ColorPoint point2 = new ColorPoint(100,200,"red");
	//  drawPoint(point2); 
	  
	//  drawTriangle(new Triangle());
	  //drawRectangle(new Rectangle());
	  
	//  draw(point2);
	  //   drawShape(new Triangle());
	 //    drawShape(new Rectangle());
	 //    drawShape(new Circle());
	 // draw(new Triangle());
	//  draw(new Rectangle());
//	  draw(new Circle());
	  
		Circle c = new Circle();
		System.out.println(c instanceof Circle);
		System.out.println(c instanceof Shape);
		System.out.println(c instanceof Object);
		
		// 오류 : 연산자 우측항이 클래스인 경우 
		// 레퍼런스 하고 있는 class 타입의 hierachy 상의 하위 상위만 
		// instanceof 연산자를 사용할 수 있다. -> 부모랑 자식만 물어볼 수 있다. 
		
		Object o = new Circle();
		System.out.println(o instanceof String);
	
		// 연산자의 우측항이 인터페이스인 경우 
		// Hierachy 상관없이 instanceof 연산자를 사용할 수 있다. 
		
		System.out.println(c instanceof Drawable);
		System.out.println(c instanceof Runnable);
	
		
		
	  draw(new GraphicText("Hello World"));
	}

	private static void drawPoint(Point point) {
		point.show(); 
	}
	
	private static void drawShape(Shape shape) {
		shape.draw();
	}
	
	/*
	private static void drawColorPoint(ColorPoint colorPoint) {
		colorPoint.show();
	}
	*
	*/
	
	public static void draw(Drawable drawable) {
		drawable.draw();
	}


	
	
}
