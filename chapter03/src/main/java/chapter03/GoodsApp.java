package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 객체를 만들어서 데이터를 넣어보고 메서드를 호출해봐라 
		
		Goods camera =  new Goods(); // 생성자 만들지 않아도 사용할 수 있다. 자동으로 생성해준다 
		
		camera.setName("nikon");
		camera.setPrice(400000);
		camera.setCountSold(10);
		camera.setCountStock(20);
		
		camera.showInfo();
		
		// 정보 은닉 ( 데이터의 보호) 
		
		camera.setPrice(-400000);
		
		// static 변수 (클래스 변수) 
		Goods goods2 = new Goods();
		Goods goodds3 = new Goods();
		System.out.println(Goods.countOfGoods);
		
		camera.setPrice(400000);
		System.out.println(camera.calcDiscountPrice(0.5f));
		System.out.println(camera);
		
	
	}
}
