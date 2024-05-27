package stack;

public class Stack {
	static int size;
	static int[] stack;
	static int top;
	
	// 성진이 아이디어 추가
	public Stack(int size) {
		this.size = size;
		this.top = -1;
		stack = new int[size];
	}
	
	
	public static void push(int data) {
		if(isFull()) {
			System.out.println("데이터를 추가할 수 없습니다.");
			return;
		}
		stack[++top] = data;
	}
	
	public static int pop() {
		if(isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return stack[top--];
	}
	
	public static boolean isEmpty() {
		return top == -1;
	}
	
	public static boolean isFull() {
		return top == stack.length-1;
	}
	
	public static int peek() {
		return stack[top];
	}
	
	
}