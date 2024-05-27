package swea_2930_힙;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
	
	// 데이터의 범위
	static int[] heap;
	static int heapSize;
	static String ans;
	
	static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
	
	static void heapPush(int data) {
		heap[++heapSize] = data;
		
		int child = heapSize;
		int parent = heapSize / 2;
		
		while(parent > 0 && heap[parent] < heap[child]) {
			swap(parent, child);
			
			child = parent;
			parent = child / 2;
		}
	}
	
	static int heapPop() {
		
		int popItem = heap[1];
		
		heap[1] = heap[heapSize--];
		
		int parent = 1;
		int child = parent * 2;
		
		if(child + 1 <= heapSize && heap[child] < heap[child+1]) {
			child++;
		}
		while(child <= heapSize && heap[parent] < heap[child]) {
			
			swap(parent, child);
			
			parent = child;
			child = parent * 2;
			
			if(child + 1 <= heapSize && heap[child] < heap[child+1]) {
				child++;
			}
		}
		
		return popItem;
	}
	
	public static void main(String[] args) throws IOException {
//		File file = new File("src/swea_2930_힙/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			heapSize = 0;
			StringBuilder ans = new StringBuilder();
			int N = sc.nextInt();	// 연산의 수를 나타내는 자연수 N
			heap = new int[N+1];
			// 연산1: 자연수 x를 삽입
			// - 2개의 자연수 1 x가 주어지며 x를 최대 힙에 추가하는 연산
			
			// 연산2: 최대 힙의 루트 노드의 키값을 출력하고, 해당 노드를 삭제
			// - 1개의 자연수 2가 주어지며, 현재 최대 힙의 루트 노드의 키값을 출력하고, 해당 노드를 삭제
			
			for(int i = 0; i < N; i++) {
				int command = sc.nextInt();
				if(command == 1) {
					int x = sc.nextInt();
					heapPush(x);
				} else {
					if(heapSize == 0) {
						ans.append(" " + "-1");
					} else {
						ans.append(" " + heapPop());
					}
				}
			}
			
			System.out.printf("#%d%s\n", tc, ans);
			
		}
		// test case
	}
	
	
	
}