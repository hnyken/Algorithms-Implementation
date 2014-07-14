public class Stack {
	
	private ArrayList<String> stackData;
	private int TOP;
	
	public Stack(){
		stackData = new ArrayList<String>();
		TOP = -1;
	}
	
	public void push(String Element){
		TOP++;
		stackData.add(Element);
	}
	
	public String pop(){
		if (TOP == -1) {
			System.out.println("POP Operation Failed. Stack is empty.");
			return null;
		}
		String Element = stackData.remove(TOP);
		TOP--;
		return Element;
	}
	
}
