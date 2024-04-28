package prob6;

public class RectTriangle extends Shape {

	private double w;
	private double h;
	
	public RectTriangle(double w, double h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public double getArea() {
	   return (w*h)/2;
	}

	@Override
	public double getPerimeter() {
		return(w+h+Math.sqrt(w*w+h*h));
	}
	
	

}
