package 구현;

public class Queue구현 {
	
	static int[] queue;
	static int front = -1;
	static int rear = -1;
	static int size = 0;
	
	public static void main(String[] args) {
		
		queue= new int[10];
		
		System.out.println(isEmpty());
		System.out.println(isFull());		
		
		enQueue(10);
		enQueue(6);
		enQueue(3);
		System.out.println(size);
		
		System.out.println(peek());
		System.out.println(deQueue());
		System.out.println(peek());
	}

	public static boolean isEmpty() {
		return size == 0;
	}
	
	public static boolean isFull() {
		return size == queue.length;
	}
	
	public static void enQueue(int data) {
		if(isFull()) {
			System.out.println("queue에 값을 추가할 수 없습니다.");
			return;
		}
		queue[++rear] = data;
		size++;
	}
	
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("queue에서 값을 빼낼 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		size--;
		return queue[++front];
	}
	
	public static int peek() {
		if(isEmpty()) {
			System.out.println("queue에 값이 없습니다.");
			return Integer.MIN_VALUE;
		}
		return queue[front+1];
	}
	
}