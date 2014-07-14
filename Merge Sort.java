public int[] MergeSort(int A[], int p, int r) {
	if (p < r) {
		int q = (p + r) / 2;
		A = MergeSort(A, p, q);
		A = MergeSort(A, q + 1, r);
		A = Merge(A, p, q, r);
	}
	return A;
}

private int[] Merge(int[] A, int p, int q, int r) {
	int n1 = q - p + 1;
	int n2 = r - q;
	ArrayList<Integer> L = new ArrayList<Integer>();
	for (int i = 0; i < n1; i++)
		L.add(A[p + i]);
	ArrayList<Integer> R = new ArrayList<Integer>();
	for (int i = 0; i < n2; i++)
		R.add(A[q + 1 + i]);
	L.add(99999);
	R.add(99999);
	int i = 0;
	int j = 0;
	for (int k = p; k <= r; k++) {
		if(L.get(i) <=R.get(j)){
			A[k] = L.get(i);
			i++;
		}
		else{
			A[k] = R.get(j);
			j++;
		}
	}
	return A;
}

	
