package boj_2623_음악프로그램;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	
	static int[] into;
	static boolean[] visited;
	
	static StringBuilder sb = new StringBuilder();
	
	static ArrayList<ArrayList<Integer>> adjList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		into = new int[N+1];
		visited = new boolean[N+1];
		
		adjList = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			int n = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			for(int j = 1; j <= n; j++) {
				int num = sc.nextInt();
				
				if(!list.isEmpty()) {
					for(int k : list) {
						if(!adjList.get(k).contains(num)) {
							adjList.get(k).add(num);
							into[num]++;
						}
					}
				}
				
				list.add(num);
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && into[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			visited[now] = true;
			sb.append(now).append("\n");
			
			if(adjList.get(now).isEmpty()) {
				continue;
			}
			
			for(int i : adjList.get(now)) {
				if(!visited[i]) {
					into[i]--;
					if(into[i] == 0) {
						queue.add(i);
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				sb = new StringBuilder();
				sb.append(0);
				break;
			}
		}
		
		System.out.println(sb);
		
		
//		int count = 0;
//		int idx = 1;
//		while(count < N) {
//			if(idx > N) {
//				idx = 1;
//				continue;
//			}
//			
//			if(!visited[idx] && into[idx] == 0) {
//				
//				visited[idx] = true;
//				count++;
//				sb.append(idx).append("\n");
//				
//				if(adjList.get(idx).isEmpty()) {
//					idx++;
//				} else {
//					for(int i : adjList.get(idx)) {
//						if(!visited[i]) {
//							into[i]--;							
//						}
//					}
//					idx++;
//				}
//				
//			} else {
//				idx++;
//			}
//		}
//		
//		System.out.println(sb);
	}
}
