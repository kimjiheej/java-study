package prob5;

public class MyStack02 {

	private int top;
	private Object[] buf;

	public MyStack02(int capacity) {
		top = -1;
		buf = new String[capacity];
	}

	public void push(Object s) {
		if (top == buf.length - 1) {
			resize();
		}

		buf[++top] = s;		
	}

	public Object pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}

		Object result = buf[top];
		buf[top--] = null;

		return result;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	private void resize() {
		Object[] temp = new Object[buf.length * 2];
		for (int i = 0; i <= top; i++) {
			temp[i] = buf[i];
		}

		buf = temp;
	}
}