package 구현;

public class Stack구현 {
	
	static int top = -1;
	static int size = 0;
	static int[] stack;
	
	public static void main(String[] args) {
		stack = new int[10];
		
		push(10);
		push(10);
		push(10);
		push(10);
		push(10);
		push(10);
		push(10);
		push(10);
		push(10);
		push(10);
		push(11);
		
		System.out.println(isEmpty());
		System.out.println(isFull());
		System.out.println(peek());
	}
	
	public static boolean isEmpty() {
		return size == 0;
	}
	
	public static boolean isFull() {
		return size == stack.length;
	}
	
	public static void push(int data) {
		if(isFull()) {
			System.out.println("stack에 추가할 수 없습니다.");
			return;
		}
		stack[++top] = data;
		size++;
	}
	
	public static int pop() {
		if(isEmpty()) {
			System.out.println("stack에서 값을 빼낼 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		int tmp = stack[top];
		stack[top--] = 0;
		size--;
		return tmp;
	}
	
	public static int peek() {
		if(isEmpty()) {
			System.out.println("stack에서 값을 빼낼 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		return stack[top];
	}
	
	
}