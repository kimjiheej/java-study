package tv;

public class WatchTV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		     TV tv = new TV( 7, 20, false);  	
	         
	         tv.status();	
	         
	         tv.power( true ); // 그냥 on off 
	         tv.volume( 120 );
	         tv.status();	
	         
	         // 볼륨이랑 채널은 오버로딩해서 구현하기. 범위는 라운딩 시켜라 
	         // 디지털이랑 아날로그 방식으로 만들게 되는데 최대한 코드 중복을 줄여라 
	         
	         
	         tv.volume( false ); // 볼륨을 내려라 
	         tv.status();
	         
	         tv.channel( 0 );
	         tv.status();		          
	         
	         tv.channel( true );
	         tv.channel( true );
	         tv.channel( true );
	         tv.status();

	         tv.power( false );
	         tv.status();      	

	}

}
