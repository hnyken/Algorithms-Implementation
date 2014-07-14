public class Queue {
	private ArrayList<String> queueData;
	private int HEAD;
	private int TAIL;

	public Queue() {
		queueData = new ArrayList<String>();
		HEAD = -1;
		TAIL = -1;
	}

	public void Insert(String Element) {
		HEAD = 0;
		TAIL++;
		queueData.add(Element);
	}

	public String Delete() {
		if (TAIL == -1) {
			System.out.println("Delete Operation Failed. Queue is empty.");
			return null;
		}
		String Element = queueData.remove(HEAD);
		if (TAIL == 0)
			HEAD = -1;
		TAIL--;
		return Element;
	}
}
