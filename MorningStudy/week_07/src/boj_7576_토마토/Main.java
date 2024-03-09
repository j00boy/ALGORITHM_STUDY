/**
 * [GOLD 5]
 * [토마토]
 * - BFS로 풀며, 모든 칸이 다 차는데 걸리는 최소 시간을 계산
 */

package boj_7576_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] tomatoes;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		tomatoes = new int[N][M];

		// 토마토가 여러 개 일수 있으므로 먼저 queue에 넣기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				tomatoes[r][c] = sc.nextInt();
				if(tomatoes[r][c] == 1) {
					queue.add(r);
					queue.add(c);
				}
			}
		}

		BFS();
		
		/*
		 * 시작점이 1이므로, 최댓값을 찾고 max -1 return
		 * 만약에 0이 있으면 -1에 가로 막혀서 못돈거기 때문에, 즉시 for문 종료
		 */
		int max = 0;
		
		boolean flag = true;
		for(int r = 0; r < N; r++) {
			if(!flag) break;
			for(int c = 0; c < M; c++) {
				if(tomatoes[r][c] == 0) {
					max = 0;
					flag = false;
					break;
				}
				
				if(max < tomatoes[r][c]) {
					max = tomatoes[r][c];
				}
			}
		}

		System.out.println(max-1);
	}

	public static void BFS() {

		// 토마토는 상 하 좌 우 로 뻗어 나간다.
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {

			int now_r = queue.poll();
			int now_c = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];

				if (check(nr, nc) && tomatoes[nr][nc] == 0) {
					queue.add(nr);
					queue.add(nc);
					tomatoes[nr][nc] = tomatoes[now_r][now_c] + 1;
				}
			}
		}

	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}