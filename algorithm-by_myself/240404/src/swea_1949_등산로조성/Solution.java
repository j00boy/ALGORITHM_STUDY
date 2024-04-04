package swea_1949_등산로조성;

import java.util.Scanner;

public class Solution {

	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int canDig;
	static int longest;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 맵 크기
			K = sc.nextInt(); // 최대 공사 가능 깊이
			map = new int[N][N];

			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
					if (max < map[r][c]) {
						max = map[r][c];
					}
				}
			}

			longest = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == max) {
						visited = new boolean[N][N];
						canDig = 1;
						DFS(r, c, 1, max, canDig);
					}
				}
			}

			System.out.printf("#%d %d\n", tc, longest);
		}
		// test case
	}
	
	// 정상 진행
	public static void DFS(int r, int c, int leng, int hgt, int dig) {
		if(leng > longest) {
			longest = leng;
		}
		
		visited[r][c] = true;
		
		if(dig == 0) {
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(check(nr, nc) && !visited[nr][nc]) {
					if(hgt > map[nr][nc]) {
						DFS(nr, nc, leng + 1, map[nr][nc], dig);
					}
				}
			}
		} else if(dig == 1) {
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(check(nr, nc) && !visited[nr][nc]) {
					if(hgt <= map[nr][nc] && hgt > map[nr][nc] - K) {
						DFS(nr, nc, leng + 1, map[r][c]-1, dig - 1);
					} else if(hgt > map[nr][nc]) {
						DFS(nr, nc, leng + 1, map[nr][nc], dig);
					}
				}
			}
		}
		
		visited[r][c] = false;
	}
	

	// 경계조건 체크
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
