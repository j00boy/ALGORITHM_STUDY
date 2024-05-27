package 원형_Queue_구현;

import java.util.Arrays;

public class Solution {

	static int[] queue = new int[10];
	static int front = 0, rear = 0;
	// front와 rear가 0에서 시작하므로, N-1
	
	public static void main(String[] args) {
		
		
		enQueue(1);
		enQueue(2);
		enQueue(3);
		enQueue(4);
		enQueue(5);
		enQueue(6);
		enQueue(7);
		enQueue(8);
		enQueue(9);
		System.out.println(Arrays.toString(queue));
		System.out.println(isFull());
		System.out.println(peek());
		
	}
	
	public static boolean isEmpty() {
		return front == rear;
	}
	
	public static boolean isFull() {
		return front == (rear + 1) % queue.length;
	}
	
	public static void enQueue(int data) {
		if(isFull()) {
			System.out.println("값을 추가할 수 없습니다.");
			return;
		}
		rear = (rear + 1) % queue.length;
		queue[rear] = data;
	}
	
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("값을 빼낼 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		front = (front + 1) % queue.length;
		return queue[front];
	}
	
	public static int peek() {
		return queue[(front+1) % queue.length];
	}
	
}