package thread;

public class AlphabetThread extends Thread {

	@Override
	public void run() {
		// main 에서 돌게 하자 
		for(char c ='a'; c < 'j'; c++) {
			System.out.print(c);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}




