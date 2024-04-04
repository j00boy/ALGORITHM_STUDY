package swea_2105_디저트카페;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	static int N;
	static int[][] map;
	static int count;
	static int maxCnt;
	static boolean[][] visited;
	static ArrayList<Integer> list;
	static int[] dr = { 1, 1, -1, -1 };		// 우하 좌하 좌상 우상
	static int[] dc = { 1, -1, -1, 1 };		// 우하 좌하 좌상 우상
	static int now_r;
	static int now_c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			maxCnt = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 1; c < N - 1; c++) {
					visited = new boolean[N][N];
					now_r = r;	// 현재 꼭짓점 저장
					now_c = c;	// 현재 꼭짓점 저장
					count = 1;
					list = new ArrayList<>();
					list.add(count-1, map[r][c]);
					visited[r][c] = true;
					DFS(r, c, 0, count);	// 여기가 꼭짓점인 최대 가능 디저트 종류를 찾음
				}
			}
			
			if (maxCnt == 0) {
				System.out.printf("#%d %d\n", tc, -1);
			} else {
				System.out.printf("#%d %d\n", tc, maxCnt);
			}
		}
		// test case
	}

	// 카페 찾기
	public static void DFS(int r, int c, int dir, int cnt) {
		for(int d = dir; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr == now_r && nc == now_c && cnt >= 4) {	// 가능한 싸이클은 최소가 4임 // 그 외에는 갔다가 다시 오는거 -> 싸이클 형성 X
				maxCnt = Math.max(maxCnt, cnt);
				return;
			}
			
			if (check(nr, nc) && !list.contains(map[nr][nc]) && !visited[nr][nc]) {
				visited[nr][nc] = true;
				list.add(cnt, map[nr][nc]);	
				DFS(nr, nc, d, cnt + 1);
				visited[nr][nc] = false;	// 딴 방향으로 가는 것도 있기 때문에
				list.set(cnt, -1);	// 딴 방향으로 가는 것도 있기 때문에
			}
		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
