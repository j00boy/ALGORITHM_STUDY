package Queue구현;

import java.util.ArrayList;
import java.util.List;

public class Queue_by_list {
	
	// createQueue
	static List<Integer> queue = new ArrayList<>();
	static int front = -1, rear = -1;
	
	// isEmpty
	public static boolean isEmpty() {
		return queue.size() == 0;
	}
	
	// enQueue
	public static void enQueue(int data) {
		queue.add(data);
		rear++;
	}
	
	// deQueue
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("값을 빼낼 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		return queue.get(++front);
	}
	
	// Qpeek
	public static int Qpeek() {
		if(isEmpty()) {
			System.out.println("값을 확인할 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		return queue.get(front+1);
	}
	
	public static void main(String[] args) {
		
//		for(int i = 0; i < 10; i++) {
//			enQueue(i);
//		}
//		
//		System.out.println(Qpeek());
//		System.out.println(deQueue());
//		System.out.println(Qpeek());
//		System.out.println(deQueue());
//		System.out.println(queue);
//		System.out.println(Qpeek());
//		System.out.println(Qpeek());
		
	}

}
