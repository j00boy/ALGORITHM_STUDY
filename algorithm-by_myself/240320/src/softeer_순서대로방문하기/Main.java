package softeer_순서대로방문하기;

import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dest;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][N];
		visited = new boolean[N][N];
		dest = new int[M][2];

		// 맵 형성
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == 1)
					map[r][c] = -1;
			}
		}

		// 시작점
		int[] start = new int[] { sc.nextInt() - 1, sc.nextInt() - 1 };

		// 목적지 순서 : 1부터 
		int t = 1;
		for (int i = 1; i < M; i++) {
			map[sc.nextInt() - 1][sc.nextInt() - 1] = t;
			t++;
		}

		DFS(start[0], start[1], 1);

		System.out.println(count);

//		for(int r = 0; r < N; r++) {
//			for(int c = 0; c < N; c++) {
//				System.out.print(map[r][c] + " ");
//			}
//			System.out.println();
//		}

	}

	// row와 col은 시작점
	public static void DFS(int row, int col, int target) {
		// 기저 조건
		if (map[row][col] == M-1) {
			count++;
			return;
		}

		visited[row][col] = true;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];

			// 0인 길만 간다.
			if (check(nr, nc) && !visited[nr][nc]) {
				if (map[nr][nc] == target) {
					visited[nr][nc] = true;
					DFS(nr, nc, target + 1);
					visited[nr][nc] = false;
				} else if (map[nr][nc] == 0) {
					visited[nr][nc] = true;
					DFS(nr, nc, target);
					visited[nr][nc] = false;
				} else {
					continue;
				}
			}
		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
