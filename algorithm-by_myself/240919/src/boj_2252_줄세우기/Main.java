package boj_2252_줄세우기;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int M;
	
	static ArrayList<ArrayList<Integer>> adjList;
	static int[] into;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		into = new int[N+1];
		visited = new boolean[N+1];
		
		adjList = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adjList.get(A).add(B);
			
			into[B]++;	// 진입차수++
		}
		
		int idx = 1;
		int count = 0;
		while(count < N) {
			if(idx > N) {
				idx = 1;
				continue;
			}
			
			if(!visited[idx] && into[idx] == 0) {
				visited[idx] = true;
				count++;
				sb.append(idx).append(" ");

				if(adjList.get(idx).isEmpty()) {
					idx++;
				} else {
					for(int num : adjList.get(idx)) {
						into[num]--;
					}
					idx = 1;
				}
			} else {
				idx++;
			}
		}
		
		System.out.println(sb);
		
	}
}
