package main;

public class InsertionSort implements SortingAlgorithm_IF {

	private int noc;

	@Override
	public int[] sort(int[] array) {
		noc = 0;

		noc++; // Mennäänkö for looppiin?
		for (int i = 0; i < array.length ; i++) {
			int j = i;

			noc+=2; // Mennäänkö while looppiin?
			while (j > 0 && array[j - 1] > array[j]) {
				int temp = array[j - 1];
				array[j - 1] = array[j];
				array[j] = temp;
				j--;
				noc+=2; // Mennäänkö uudestaan while looppiin?
			}

			noc++; // Mennäänkö uudestaan for looppiin?
		}
		return array;
	}

	@Override
	public int getNoc() {
		return noc;
	}
}
