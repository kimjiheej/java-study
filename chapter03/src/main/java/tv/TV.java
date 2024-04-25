package tv;

public class TV {

	private int channel;
	private int volume;
	private boolean power;
	
	
	public TV() {
	
	}
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void power(boolean on) {
		if(on) {
			power = true;
		}
		else 
		{
			power = false;
		}
	}
	
	
	
	public void channel(int channel) {
		// 1-255 유지
		this.channel = channel;
	}
	
	public void channel(boolean up) {
		// 1-255 유지 1씩 증감
		
		if(up) {
			if(this.channel ==255)
				this.channel = 1;
			else 
				this.channel +=1;
		}
		else {
			if(this.channel == 1)
				this.channel = 255;
			else 
				this.channel -= 1;
		}
		
		
	}
	
	public void volume(int volume) {
		// 0-100 유지 
		this.volume = volume;
	}
	
	public void volume(boolean up) {
		// 0-100 유지. 1씩 증감 
		
		if(up) {
			if(this.volume ==100)
				this.volume = 0;
			else 
				this.volume +=1;
		}
		else {
			if(this.volume ==0)
				this.volume = 0;
			else 
				this.volume -= 1;
		}
	}
	
	
	public void status() {
		System.out.println("TV[power="+power+", channel=" +channel+ ", volume="+ volume+"]");
	}
}
