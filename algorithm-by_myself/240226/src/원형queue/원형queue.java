package 원형queue;

public class 원형queue {
	
	static int[] queue = new int[10];
	static int front = 0, rear = 0;
	
	public static void main(String[] args) {
		
	}
	
	public static boolean isEmpty() {
		return front == rear;
	}
	
	public static boolean isFull() {
		return front == (rear + 1) % queue.length;
	}
	
	public static void enQueue(int data) {
		if(isFull()) {
			System.out.println("Queue가 포화상태입니다.");
			return;
		}
		rear = (rear + 1) % queue.length;
		queue[rear] = data;
	}
	
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("Queue가 비어있습니다.");
			return Integer.MIN_VALUE;
		}
		
		front = (front + 1) % queue.length;
		return queue[front];
	}

}