package paint;

public class GraphicText implements Drawable {

	private String text;
	
	public GraphicText(String text) {
		this.text = text;
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("텍스트 ' "+ text + "그렸습니다");
	}
	
	// instanceOf 연산자 
	
  

}
