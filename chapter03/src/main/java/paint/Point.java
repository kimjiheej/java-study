package paint;

public class Point {
	
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	
	public void show(boolean visible) { // 오버 로딩 
	   if(visible) {
		   show();
	   }
	   else {
		   System.out.println("점(" + x + ", "+ y + ")을 지웠습니다.");
	   }
	}
	
	public void setY(int y) {
		this.y = y;
	}
    public void show() {
    	System.out.println("점("+x+","+y+")을 그렸습니다.");
    }
}
