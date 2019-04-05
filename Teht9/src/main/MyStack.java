package main;

public class MyStack {

	private int[] stack;
	private int pos = 0;

	public MyStack(int size) {
		stack = new int[size];
	}

	public void insert(int value) {
		stack[pos] = value;
		pos++;
	}

	public int pop() {
		pos--;
	 return stack[pos];
	}

	public void print() {
		for (int i = pos - 1; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}
}
