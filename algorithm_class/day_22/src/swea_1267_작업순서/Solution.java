// Queue 구현

package swea_1267_작업순서;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int V;
	static int E;
	static int[] in_degree;
	static Queue<Integer> queue;
	static int[][] adj;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_1267_작업순서/input.txt"));
//		Scanner sc = new Scanner(System.in);
		
		// test case
		for(int tc = 1; tc <= 10; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			in_degree = new int[V+1];
			adj = new int[V+1][V+1];
			queue = new LinkedList<>();
			
			for(int i = 0; i < E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				adj[A][B] = 1;
				in_degree[B]++;
			}
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 1; i <= V; i++) {
				if(in_degree[i] == 0) {
					queue.offer(i);
				}
			}
			
			while(!queue.isEmpty()) {
				int curr = queue.poll();
				sb.append(curr + " ");
				
				for(int i = 1; i <= V; i++) {
					if(adj[curr][i] == 1) {
						in_degree[i]--;
						adj[curr][i] = 0;
						
						if(in_degree[i] == 0) {
							queue.offer(i);
						}
					}
				}
			}
			
			System.out.printf("#%d %s\n", tc, sb);
		}
		// test case
	}
}