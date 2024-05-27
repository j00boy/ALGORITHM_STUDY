package swea_7102_준홍이의카드놀이;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static List<Integer> queue1 = new ArrayList<>();
	static List<Integer> queue2 = new ArrayList<>();
	static List<Integer> results = new ArrayList<>();
	
	static int front1, front2, rear1, rear2;
	
	public static void main(String[] args) throws Exception {
		
//		File file = new File("src/swea_7102_준홍이의카드놀이/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case 시작
		for(int tc = 1; tc <= T; tc++) {
			queue1.clear();
			queue2.clear();
			results.clear();
			front1 = -1;
			front2 = -1;
			rear1 = -1;
			rear2 = -1;
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			for(int i = 1; i <= N; i++) {
				enQueue1(i);
			}
			
			for(int i = 1; i <= M; i++) {
				enQueue2(i);
			}
			
//			System.out.println(queue1);
//			System.out.println(queue2);
			
			for(int i = 1; i <= N; i++) {
				int first = deQueue1();
				for(int j = 1; j <= M; j++) {
					int second = deQueue2();
					results.add(first + second);
					enQueue2(second);
				}
			}
			
//			System.out.println(results);
			int size = results.size();
			
			// counting 배열 생성
			int[] counts = new int[400];
			
			// 빈도수 배열 
			for(int i = 0; i < results.size(); i++) {
				counts[results.get(i)]++;
			}
			
			// 최빈값 구하기
			int max_freq = Integer.MIN_VALUE;
			for(int i = 0; i < counts.length; i++) {
				if(counts[i] > max_freq) {
					max_freq = counts[i];
				}
			}
			
			// 최빈값에 해당하는 정수
			String ans = "";
			for(int i = 0; i < counts.length; i++) {
				if(counts[i] == max_freq) {
					ans += i + " ";
				}
			}
			
			System.out.printf("#%d %s\n", tc, ans);
			
			
		}
		// test case 끝
		
	}
	
	public static boolean isEmpty1() {
		return queue1.size() == 0;
	}
	
	public static boolean isEmpty2() {
		return queue2.size() == 0;
	}
	
	public static void enQueue1(int data) {
		queue1.add(data);
		rear1++;
	}
	
	public static void enQueue2(int data) {
		queue2.add(data);
		rear2++;
	}
	
	public static int deQueue1() {
		if(isEmpty1()) {
			System.out.println("값을 뺄 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		return queue1.get(++front1);
	}
	
	public static int deQueue2() {
		if(isEmpty2()) {
			System.out.println("값을 뺄 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		return queue2.get(++front2);
	}
	
	public static int Qpeek1() {
		if(isEmpty1()) {
			System.out.println("값을 얻을 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		return queue1.get(front1+1);
	}
	
	public static int Qpeek2() {
		if(isEmpty2()) {
			System.out.println("값을 얻을 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		return queue2.get(front2+1);
	}
}