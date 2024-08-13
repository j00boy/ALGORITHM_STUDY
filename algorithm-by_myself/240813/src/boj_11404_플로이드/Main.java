package boj_11404_플로이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 987654321;

	static int n;
	static int m;

	static int[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		dist = new int[n + 1][n + 1];

		// 초기값 설정
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					dist[i][j] = 0;
				else
					dist[i][j] = INF;
			}
		}
		
//		print(dist);

		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			dist[start][end] = Math.min(dist[start][end], cost);
		}

//		print(dist);

		// 플로이드 워셜
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
//			System.out.println(k + ": ==========================================");
//			print(dist);
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(dist[i][j] == INF) {
					dist[i][j] = 0;
				}
			}
		}

		print(dist);
	}

	static void print(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				sb.append(dist[r][c]).append(" ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}
