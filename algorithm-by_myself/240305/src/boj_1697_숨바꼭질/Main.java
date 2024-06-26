package boj_1697_숨바꼭질;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;		// 수빈이
	static int K;		// 수빈이 동생
	static int[] road;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		road = new int[100001];
		visited = new boolean[100001];

		N = sc.nextInt();
		K = sc.nextInt();
		
		BFS(N);
		
		System.out.println(road[K]);
		
		
		
	}
	
	public static void BFS(int start) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = true;
		road[start] = 0;
		
		while(!visited[K]) {
			int num = queue.poll();
			
			int[] arr = {num-1, num+1, num*2};
			
			for(int i : arr) {
				if(check(i) && !visited[i]) {
					visited[i] = true;
					queue.add(i);
					road[i] = road[num]+1;
				}
			}
		}
	}

	public static boolean check(int n) {
		return n >= 1 && n <= 100000;
	}
}