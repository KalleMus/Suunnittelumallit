package main;

import java.util.Arrays;

public class MyList {

	private int[] array;
	private int pos = 0;

	public MyList(int size) {
		array = new int[size];
	}

	public void insert(int value) {
		array[pos] = value;
		pos++;
	}

	public int pop() {
		pos--;
	 return array[pos];
	}

	public void print() {
		for (int i = pos - 1; i >= 0; i--) {
			System.out.println(array[i]);
		}
	}
}
