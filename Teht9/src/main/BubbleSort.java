package main;

public class BubbleSort implements SortingAlgorithm_IF {

	public int noc = 0;

	@Override
	public int getNoc() {
		return noc;
	}

	@Override
	public int[] sort(int[] array) {
		noc = 0;
		boolean swapped = true;

		noc++; // Aloitetaanko while loop?
		while (swapped) {
			swapped = false;

			noc++; // Aloitetaanko for loop?
			for (int i = 0; i < array.length - 1; i++) {

				noc++; // If vertailu.
				if (array[i] > array[i + 1]) {
					swapped = true;
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
				noc++; // Toistetaanko for loop?

			}
			noc++; // Mennäänkö takaisin while looppiin?.
		}
		return array;
	}
}
