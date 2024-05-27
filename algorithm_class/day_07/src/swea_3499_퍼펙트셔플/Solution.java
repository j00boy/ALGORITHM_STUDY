package swea_3499_퍼펙트셔플;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static List<String> queue1 = new ArrayList<>();
	static List<String> queue2 = new ArrayList<>();
	static List<String> queue = new ArrayList<>();
	static int front1, rear1, front2, rear2, front, rear;
	
	public static void main(String[] args) throws IOException {
		
//		File file = new File("src/swea_3499_퍼펙트셔플/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			queue.clear();
			queue1.clear();
			queue2.clear();
			
			front = -1;
			front1 = -1;
			front2 = -1;
			rear = -1;
			rear1 = -1;
			rear2 = -1;
			
			
			if(N % 2  == 0) {
				for(int i = 0; i < N/2; i++) {
					enQueue1(sc.next());
				}
				for(int i = N/2; i < N; i++) {
					enQueue2(sc.next());
				}
			} else {
				for(int i = 0; i <= N/2; i++) {
					enQueue1(sc.next());
				}
				for(int i = N/2 + 1; i < N; i++) {
					enQueue2(sc.next());
				}
			}
			
//			System.out.println(queue1);
//			System.out.println(queue2);
			
			
			
			for(int i = 0; i < N; i++) {
				if(i % 2 == 0) {
					if(isEmpty1()) continue;
					enQueue(deQueue1());
				} else {
					if(isEmpty2()) continue;
					enQueue(deQueue2());
				}
			}
			
//			System.out.println(queue);
			
			String ans = "";
			for(String s : queue) {
				ans += s + " ";
			}
			
			System.out.printf("#%d %s\n", tc, ans);
		}
		
	}
	
	
	public static boolean isEmpty() {
		return front == rear;
	}
	
	public static boolean isEmpty1() {
		return front1 == rear1;
	}
	
	public static boolean isEmpty2() {
		return front2 == rear2;
	}  
	
	public static void enQueue(String str) {
		queue.add(str);
		rear++; 
	}
	
	public static void enQueue1(String str) {
		queue1.add(str);
		rear1++; 
	}
	
	public static void enQueue2(String str) {
		queue2.add(str);
		rear2++;
	}
	
	public static String deQueue() {
		if(isEmpty()) {
			System.out.println("값을 빼낼 수 없습니다.");
			return "";
		}
		return queue.get(++front);
	}
	
	public static String deQueue1() {
		if(isEmpty1()) {
			System.out.println("값을 빼낼 수 없습니다.");
			return "";
		}
		return queue1.get(++front1);
	}
	
	public static String deQueue2() {
		if(isEmpty2()) {
			System.out.println("값을 빼낼 수 없습니다.");
			return "";
		}
		return queue2.get(++front2);
	}
	
	public static String peek() {
		if(isEmpty()) {
			System.out.println("값을 얻을 수 없습니다.");
			return null;
		}
		return queue.get(front + 1);
	}
	
	public static String peek1() {
		if(isEmpty1()) {
			System.out.println("값을 얻을 수 없습니다.");
			return null;
		}
		return queue1.get(front1 + 1);
	}
	
	public static String peek2() {
		if(isEmpty2()) {
			System.out.println("값을 얻을 수 없습니다.");
			return null;
		}
		return queue2.get(front2 + 1);
	}
}