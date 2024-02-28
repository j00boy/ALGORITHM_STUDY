package 구현;

public class 원형Queue구현 {
	
	static int[] queue;
	static int size;
	static int front = 0, rear = 0;
	
	public static void main(String[] args) {
		
		queue = new int[4];
		
		enQueue(1);
		enQueue(2);
		enQueue(3);
		
		System.out.println(peek());
		System.out.println(deQueue());
		System.out.println(peek());
		System.out.println(deQueue());
		enQueue(4);

		
	}
	
	public static boolean isEmpty() {
		return front == rear;
	}
	
	public static boolean isFull() {
		return front == (rear+1) % queue.length;
	}
	
	public static void enQueue(int data) {
		if(isFull()) {
			System.out.println("queue가 꽉 찼습니다.");
			return;
		}
		rear = (rear + 1) % queue.length;
		queue[rear] = data;
	}
	
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("queue가 비어있습니다.");
			return Integer.MIN_VALUE;
		}
		front = (front+1) % queue.length;
		return queue[front];
	}
	
	public static int peek() {
		if(isEmpty()) {
			System.out.println("queue가 비어있습니다.");
			return Integer.MIN_VALUE;
		}
		return queue[(front+1) % queue.length];
	}
	
}
