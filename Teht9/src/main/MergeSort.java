package main;

public class MergeSort implements SortingAlgorithm_IF {

	private int noc = 0;

	@Override
	public int[] sort(int[] array) {

		// If list is empty; no need to do anything
		noc++; // Vertailu.
		if (array.length <= 1) {
			return array;
		}

		// Create 2 lists to hold 1st half and 2nd half of original list.
		int[] first = new int[array.length / 2];
		int[] second = new int[array.length - first.length];

		// Split the array in half and populate above lists.
		System.arraycopy(array, 0, first, 0, first.length);
		System.arraycopy(array, first.length, second, 0, second.length);

		// Sort each half recursively
		sort(first);
		sort(second);

		// Merge both halves together, overwriting original array
		merge(first, second, array);
		return array;
	}

	private void merge(int[] first, int [] second, int[] result) {

		// Index Position in first array - starting with first element
		int iFirst = 0;

		// Index Position in second array - starting with first element
		int iSecond = 0;

		// Index Position in merged array - starting with first position
		int iMerged = 0;

		// Compare elements at iFirst and iSecond,
		// and move smaller element at iMerged
		noc += 2; // While alku. Kaksi vertailua.
		while (iFirst < first.length && iSecond < second.length) {
			noc++;
			if (first[iFirst] < second[iSecond]) {
				result[iMerged] = first[iFirst];
				iFirst++;
			}
			else {
				result[iMerged] = second[iSecond];
				iSecond++;
			}
			iMerged++;
			noc+=2;
		}
		// copy remaining elements from both halves - each half will have already sorted
		// elements
		System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
		System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
	}

	@Override
	public int getNoc() {
		return noc;
	}
}
