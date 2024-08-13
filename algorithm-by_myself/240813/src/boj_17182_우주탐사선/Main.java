package boj_17182_우주탐사선;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int answer;
	
	static int N;	// ana호가 탐색할 행성의 수
	static int K;	// ana호가 발사되는 행성의 위치
	
	static int[][] dist;	// ana호가 발사되는 행성의 위치와 ana호가 행성 간 이동하는데 걸리는 시간
	static StringTokenizer st;
	
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dist = new int[N][N];
		answer = Integer.MAX_VALUE;
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				dist[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
//		print();
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
//			print();
		}
		
		visited = new boolean[N];
		visited[K] = true;
		dfs(0, K, 0);
		
		System.out.println(answer);
		
	}
	
	static void dfs(int level, int start, int sum) {
		// 기저조건
		if(level == N-1) {
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(level + 1, i, sum + dist[start][i]);
				visited[i] = false;
			}
		}
	}
	
	static void print() {
		System.out.println("=====================");
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				System.out.print(dist[r][c] + " ");
			}
			System.out.println();
		}		
	}
	
	
}
