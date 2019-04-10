package main;

public class SelectionSort implements SortingAlgorithm_IF {

	private int noc;

	@Override
	public int getNoc() {
		return noc;
	}


	public int[] sort(int[] array) {
		noc = 0;

		noc++; // Aloita for looppi1?
		for (int i = 0; i < array.length - 1; i++) {

			int min_idx = i;

			noc++; // Aloita for looppi2?
			for (int j = i + 1; j < array.length; j++) {

				noc++; // Ehtolause ?
				if (array[j] < array[min_idx]) {
					min_idx = j;
				}
				noc++; // Toista for looppi2?
			}
			int temp = array[min_idx];
			array[min_idx] = array[i];
			array[i] = temp;

			noc++; // Jatka for looppia1?
		}
		return array;
	}

}
