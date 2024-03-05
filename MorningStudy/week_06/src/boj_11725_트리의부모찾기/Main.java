package boj_11725_트리의부모찾기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int root = 1;
	static int N;
	static int[] parents;
	static boolean[] visited;
	static int[][] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		arr = new int[N + 1][N + 1];
		parents = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 2; i <= N; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			arr[A][B] = B;
			arr[B][A] = A;
		}

		dfs(root);

		for(int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}

//		for(int r = 1; r < N+1; r++) {
//			for(int c = 1; c < N+1; c++) {
//				if(arr[r][c] != 0) {
//					System.out.print(arr[r][c]);
//				}
//			}
//			System.out.println();
//		}

	}

	public static void dfs(int node) {

		visited[node] = true; // 현재 노드 방문체크

		for (int i = 0; i < N + 1; i++) {		// 해당 노드와 인접한 노드 찾기 by 인접 행렬
			// 연결되는게 무조건 있음
			// Why? 방향이 있기 때문에
			if(!visited[i]) {					// 연결 노드가 있는데, 이미 나왔던 게 아니라면 수행, 이미 나왔던 거라면 안함
				parents[i] = node; 				// 방문을 안했다는 뜻 =
												// dfs의 시작이 root노드인 1부터 시작을 해서 깊이 탐색을 하기 때문에, 이미 나왔던 노드가 부모 노드가 되는 것
				
				dfs(i); 						// 자식 노드가 된 노드가 또 다른 노드의 부모가 될 수 있는지 체크
			}
			
		}

	}

}