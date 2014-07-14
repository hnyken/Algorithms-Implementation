private static int[] HeapSort(int[] A){
	A = BuildHeap(A);
	int temp = 0;
	for(int i = A.length-1;i>1; i--){
		temp = A[1];
		A[1] = A[i];
		A[i] = temp;
		HeapSize--;
		A = MaxHeapify(A, 1);
	}
	return A;
}

private static int[] BuildHeap(int[] A){
	HeapSize = A.length ;
	for(int i = (A.length-1)/2;i>0;i--)
		A = MaxHeapify(A, i);
	return A;
}

private static int[] MaxHeapify(int[] A, int i) {
	int L = getLeft(i);
	int R = getRight(i);
	int Largest = 0;
	if (L <= HeapSize -1 && A[L] > A[i])
		Largest = L;
	else
		Largest = i;
	if (R <= HeapSize-1 && A[R] > A[Largest])
		Largest = R;
	if (Largest != i) {
		int temp = A[i];
		A[i] = A[Largest];
		A[Largest] = temp;
		MaxHeapify(A, Largest);
	}
	return A;
}

private static int getLeft(int i) {
	return 2 * i;
}

private static int getRight(int i) {
	return 2 * i + 1;
}
