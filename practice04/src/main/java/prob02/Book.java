package prob02;

public class Book {

	int bookNo; // 번호 
	String title; // 제목
	String author; // 작가 
	int stateCode; // 상태 코드 (대여 유무를 나타내는 상태 코드) 
	
	public Book(int bookNo, String title, String author) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		stateCode = 1;
	}
	
	public void rent() {
		this.stateCode = 0;
		System.out.println(title+"가 대여 됐습니다");
	}
	
	public void print() {
		if(stateCode ==1) {
			System.out.println("재고있음");
		}
		else 
		{
			System.out.println("대여중");
		}
		
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	
	
	
	
}
