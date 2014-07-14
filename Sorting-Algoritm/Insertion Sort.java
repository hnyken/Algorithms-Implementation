public int[] InsertionSort(int[] Array) {
	int key = 0;
	for (int j = 0; j < Array.length; j++) {
		key = Array[j];
		int i = j - 1;
		while (i >= 0 && Array[i] > key) {
			Array[i + 1] = Array[i];
			i--;
		}
		Array[i + 1] = key;
	}
	return Array;
}
