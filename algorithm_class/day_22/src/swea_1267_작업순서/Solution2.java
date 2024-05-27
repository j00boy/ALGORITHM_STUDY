// Stack 구현

package swea_1267_작업순서;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
	
	static int V;
	static int E;
	static int[] in_degree;
	static boolean[] visited;
	static int[][] adj;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_1267_작업순서/input.txt"));
//		Scanner sc = new Scanner(System.in);
		
		// test case
		for(int tc = 1; tc <= 10; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			in_degree = new int[V+1];
			visited = new boolean[V+1];
			stack = new Stack<>();
			adj = new int[V+1][V+1];
			
			for(int i = 0; i < E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				adj[A][B] = 1;
				in_degree[B]++;
			}
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 1; i <= V; i++) {
				if(in_degree[i] == 0) {		// 0인거만 DFS
					DFS(i);
				}
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop() + " ");
			}
			
			
			System.out.printf("#%d %s\n", tc, sb);
		}
		// test case
	}
	
	public static void DFS(int v) {
		visited[v] = true;		// 해당 노드 방문 처리
		
		for(int i = 1; i <= V; i++) {
			if(adj[v][i] == 1 && !visited[i]) {		// 인접했으면서 방문하지 않았다면
				DFS(i);		// DFS
			}
		}
		
		stack.add(v);		// 해당 함수가 끝나기 전에 stack에 넣기
	}
}