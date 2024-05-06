package prob5;

import java.lang.reflect.Array;

public class MyStack03<T> {

	private int top;
	private T[] buf;

	public MyStack03(int capacity) {
		top = -1;
		buf = (T[]) new Object[capacity];
	
	}
	public void push(T s) {
		if (top == buf.length - 1) {
			resize();
		}

		buf[++top] = s;		
	}

	public T pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("stack is empty");
		}

	    T result = buf[top];
		buf[top--] = null;

		return result;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	private void resize() {
		T[] temp = (T[])new Object[buf.length * 2];
		for (int i = 0; i <= top; i++) {
			temp[i] = buf[i];
		}

		buf = temp;
	}
}