package prob5;

public class MyStack {

	private int top;
	private String[] buf;

	public MyStack(int capacity) {
		top = -1;
		buf = new String[capacity];
	}

	public void push(String s) {
		if (top == buf.length - 1) {
			resize();
		}

		buf[++top] = s;		
	}

	public String pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}

		String result = buf[top];
		buf[top--] = null;

		return result;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	private void resize() {
		String[] temp = new String[buf.length * 2];
		for (int i = 0; i <= top; i++) {
			temp[i] = buf[i];
		}

		buf = temp;
	}
}