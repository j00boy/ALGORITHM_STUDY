package swea_1860_진기의최고급붕어빵;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// T: testCase
// N: 손님 수
// M: K개의 붕어빵을 만드는 데 소요되는 시간
// K: 붕어빵 수

public class Solution {
	
//	static int[] queue;
//	static int front, rear;
	
	public static void main(String[] args) throws IOException {
		
//		File file = new File("src/swea_1860_진기의최고급붕어빵/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case 시작
		for(int tc = 1; tc <= T; tc++) {
			
			int[] queue = new int[11112];
//			int front = 0;
//			int rear = 0;
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] customer = new int[11112];
			
			for(int i = 0; i < N; i++) {
				customer[sc.nextInt()] = 1;
			}
			
//			System.out.println(Arrays.toString(customer));
			
			boolean can = true;
			if(queue[0] - customer[0] < 0) {
				can = false;
			}
			
			for(int i = 1; i < queue.length; i++) {
				queue[i] += queue[i-1];
				if(i % M == 0) {
					queue[i] += K;
				}
				
				if(queue[i] - customer[i] >= 0) {
					queue[i] = queue[i] - customer[i];
				} else {
					can = false;
					break;
				}
			}
			
//			System.out.println(Arrays.toString(queue));
			
			
			if(!can) {
				System.out.printf("#%d %s\n", tc, "Impossible");
				continue;
			} else {
			System.out.printf("#%d %s\n", tc, "Possible");
			}
		}
		// test case 끝
		
	}
	
//	public static boolean isEmpty() {
//		return front == rear;
//	}
//	
//	public static boolean isFull() {
//		return front == (rear + 1) % queue.length;
//	}
//	
//	public static void enQueue(int data) {
//		if(isFull()) {
//			System.out.println("값을 추가할 수 없습니다.");
//			return;
//		}
//		rear = (rear+1) % queue.length;
//		queue[rear] = data;
//	}
//	
//	public static int deQueue() {
//		if(isEmpty()) {
//			System.out.println("값을 뺄 수 없습니다.");
//			return Integer.MIN_VALUE;
//		}
//		front = (front+1) % queue.length;
//		return queue[front];
//	}
//	
//	public static int peek() {
//		if(isEmpty()) {
//			System.out.println("값을 뺄 수 없습니다.");
//			return Integer.MIN_VALUE;
//		}
//		return queue[front+1];
//	}
	
}