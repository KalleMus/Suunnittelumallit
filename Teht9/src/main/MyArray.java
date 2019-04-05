package main;

import java.util.Arrays;

public class MyArray {

	private int size = 0;
	private int[] array;
	private SortingAlgorithm_IF sortingStrategy;

	public MyArray() {
		array = new int[size];
	}

	public void setSortingStrategy(SortingAlgorithm_IF sortingStrategy) {
		this.sortingStrategy = sortingStrategy;
	}

	public void insert(int value, int index) {
		size++;
		array = Arrays.copyOf(array, size);
		array[index] = value;
	}

	public void remove(int index) {
	}

	public void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public int[] sort() {
		return sortingStrategy.sort(array);
	}

	public int numberOfComparisonsDoneByTheAlgorithm() {
		return sortingStrategy.getNoc();
	}
}
