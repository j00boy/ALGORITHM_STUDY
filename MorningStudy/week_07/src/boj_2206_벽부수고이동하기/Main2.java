/*
 * GOLD 3
 * 나한테 과분한 문제임
 * 가지치기를 잘해야 할 듯
 * 시간초과가 난다는 거 알고 있었지만 생각 안나서 그냥 해봄
 */

package boj_2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

	static int N;
	static int M;
	static int[][] map;
	static int[][] time;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		time = new int[N][M];
		visited = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = Character.getNumericValue(str.charAt(c));
			}
		}

		int min = Integer.MAX_VALUE;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1) {
					map[r][c] = 0;
					time = new int[N][M];
					int result = BFS(0, 0);
					if (result != 0 && result < min) {
						min = result;
					}
					map[r][c] = 1;
				}
			}
		}

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}

	public static int BFS(int r, int c) { // r과 c는 시작점 -> (0, 0)
		Queue<Integer> queue = new LinkedList<>();

		// 상 하 좌 우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		queue.add(r);
		queue.add(c);
		time[r][c] = 1;
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			int now_r = queue.poll();
			int now_c = queue.poll();

			if (now_r == N - 1 && now_c == M - 1) {
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];

				if (check(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
					queue.add(nr);
					queue.add(nc);
					time[nr][nc] = time[now_r][now_c] + 1;
					visited[nr][nc] = true;
				}
			}
		}

		return time[N - 1][M - 1];
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}