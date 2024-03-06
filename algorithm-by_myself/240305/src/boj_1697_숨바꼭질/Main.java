package boj_1697_숨바꼭질;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int K;
	static int[] count;
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
		
		int min = 0;
		queue.add(start);
		visited[start] = true;
		road[start] = min;
		
		while(!visited[K]) {
			
			min++;
			
			int num = queue.poll();
			
			int[] arr = {num -1, num+1, num*2};
			
			for(int i : arr) {
				if(check(i) && !visited[i]) {
					visited[i] = true;
					queue.add(i);
					road[i] = min;
				}
			}
			min++;
		}
	}

	public static boolean check(int n) {
		return n >= 1 && n <= 100000;
	}
}