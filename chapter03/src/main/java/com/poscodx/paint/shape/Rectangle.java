package com.poscodx.paint.shape;

public class Rectangle extends Shape {
	
	private int x1,x2,x3;
	private int y1,y2,y3;
	
	private String lineColor;
	private String fillColor;
	
	
	@Override
	public void draw() {
		System.out.println("사각형을 그렸습니다.");
	}
	
	
	
	
}
