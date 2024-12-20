package boj_1012_유기농배추;

import java.util.Scanner;

public class Main {

	static boolean[][] visited;
	static int[][] map;
	static int N;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt(); // col 개수
			M = sc.nextInt(); // row 개수
			int K = sc.nextInt(); // 배추 개수

			// 순서 뒤바뀜
			map = new int[M][N];
			visited = new boolean[M][N];

			for (int i = 0; i < K; i++) {
				
				int A = sc.nextInt();
				int B = sc.nextInt();

				map[B][A] = 1;
			}

//			for (int r = 0; r < M; r++) {
//				for (int c = 0; c < N; c++) {
//					System.out.print(map[r][c]);
//				}
//				System.out.println();
//			}

			// 지렁이 카운트
			int count = 0;
			
			// 전체 맵을 순회하면서
			// 이미 1을 발견한 곳에서는 DFS -> 완탐 되었을 거임
			// 따라서 main 함수에서 재귀에 의한 실행이 아닌, DFS가 처음으로 실행되는 구역은 새로운 구역
			// count++;
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 1) {			
						if (!visited[r][c]) {
							DFS(r, c);
							count++;
						}
					}
				}
			}

			System.out.println(count);

		}
		// test case
	}

	public static void DFS(int row, int col) {

		// 중복 탐색 X
		if (visited[row][col]) {
			return;
		}

		visited[row][col] = true;

		// 상 하 좌 우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];

			// 허용되는 범위 안이라면
			if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
				if (!visited[nr][nc]) { // 방문했던 적이 없고
					if (map[nr][nc] == 1) { // 1이면
						DFS(nr, nc); // 깊이 탐색
					}
				}
			}
		}
	}

}