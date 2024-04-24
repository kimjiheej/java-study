package chapter03;

public class Goods {

	public static int countOfGoods = 0;
	private String name;
	private int price;
	private int  countStock; // 두 단어가 만나게 되면 뒤에 있는 것이 카멜 케이스이다. 
	private int countSold; // private 을 사용하기 위해서는 정보를 은닉하기 위해서이다. 
	
	public Goods() {
		// 클래스 이름 생략 가능 
	    countOfGoods++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0) {
			price = 0; // 이렇게 해주면 음수의 값을 넣을 수가 없다. 
		}
		
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public void showInfo() {
		// TODO Auto-generated method stub

		System.out.println("상품이름 : " + name + ", 가격 :" + price + ", 재고개수 : " + countStock + ", 팔린 개수 : "+ countSold);
	}
	
	
    public int calcDiscountPrice(float percentage) {
        int result = price -  (int)(price * percentage);
        return result;
    }
    
}
