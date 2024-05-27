package Queue구현;

public class Queue_by_arr {
	
	// createQueue
	static int[] queue;
	static int front = -1, rear = -1;
	// rear: data가 추가로 들어갈 수 있는지 확인
	// front: 빠져나올 data가 있는지 확인
	
	
	/*
	 * isEmpty()
	 * isFull()
	 * enQueue
	 * deQueue
	 * Qpeek
	 */
	
	// Queue가 비어있는지
	public static boolean isEmpty() {
		return front == rear;
	}
	
	// Queue가 꽉 차있는지
	public static boolean isFull() {
		return rear == queue.length - 1;
	}
	
	// Queue에 data 삽입
	public static void enQueue(int data) {
		if(isFull()) {
			System.out.println("enQueue 불가능");
			return;
		}
		queue[++rear] = data;
	}
	
	// Queue에서 data 삭제
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("deQueue 불가능");
			return Integer.MIN_VALUE;
		}
		return queue[++front];
	}
	
	// Queue에서 맨 앞에 나올 수 있는 값을 확인
	public static int Qpeek() {
		if(isEmpty()) {
			System.out.println("Qpeek 할 원소가 없음");
			return Integer.MIN_VALUE;
		}
		return queue[front+1];
	}
	
	public static void main(String[] args) {
//		queue = new int[100];
//		
//		for(int i = 0; i < queue.length; i++) {
//			enQueue(i);
//		}
//		
//		System.out.println(Qpeek());
//		System.out.println(deQueue());
//		System.out.println(Qpeek());
//		System.out.println(deQueue());
//		System.out.println(Qpeek());
	}
	
}