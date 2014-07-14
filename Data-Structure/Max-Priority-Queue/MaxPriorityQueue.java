public class MaxPriorityQueue {
	private static Map<Integer, String> Data;
	private int[] Keys;
	private int HeapSize;

	public MaxPriorityQueue(int size) {
		Keys = new int[size +1];
		HeapSize = 0;
		Data = new HashMap<Integer, String>();
	}

	private int getLeft(int i) {
		return 2 * i;
	}

	private int getRight(int i) {
		return 2 * i + 1;
	}

	private int[] MaxHeapify(int[] A, int i) {
		int L = getLeft(i);
		int R = getRight(i);
		int Largest = 0;
		if (L <= HeapSize  && A[L] > A[i])
			Largest = L;
		else
			Largest = i;
		if (R <= HeapSize  && A[R] > A[Largest])
			Largest = R;
		if (Largest != i) {
			int temp = A[i];
			A[i] = A[Largest];
			A[Largest] = temp;
			A = MaxHeapify(A, Largest);
		}
		return A;
	}

	public String getMaximum() {
		return Data.get(Keys[1]);
	}

	private int getParent(int i) {
		return i / 2;
	}
	
	public String ExtractMaximum(){
		if(HeapSize <1)
			System.out.println("Queue Empty");
		String Max = Data.get(Keys[1]);
		Keys[1] = Keys[HeapSize];
		HeapSize --;
		Keys = MaxHeapify(Keys, 1);
		return Max;
	}

	public void changePriority(int oldKey, int newKey) {
		int index = 1;
		if (newKey < oldKey)
			System.out.println("Invalid Key Change");
		for (int i = 1; i <= HeapSize; i++)
			if (Keys[i] == oldKey) {
				Keys[i] = newKey;
				index = i;
			}
		while (index > 1 && Keys[getParent(index)] < Keys[index]) {
			int temp = Keys[getParent(index)];
			Keys[getParent(index)] = Keys[index];
			Keys[index] = temp;
			index = getParent(index);
		}
	}

	public void Insert(int key, String value) {
		for (int i = 1; i <= HeapSize; i++)
			if (Keys[i] == key) {
				System.out.println("Priority Mismatch");
				return;
			}
		Data.put(key, value);
		HeapSize++;
		Keys[HeapSize] = -99999;
		changePriority(Keys[HeapSize], key);
	}

}
