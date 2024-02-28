package swea_4615_재미있는오셀로게임;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File("src/swea_4615_재미있는오셀로게임/sample_input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// 상 하 좌 우 좌상 좌하 우상 우하
		int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
		int[] dc = { 0, 0, -1, 1, -1, -1, 1, 1 };

		// test case
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			map = new int[N][N];

			// 초기값 생성
			// map[c][r]이라고 생각하면 편함
			if (N == 4) {
				map[1][1] = 2;
				map[2][1] = 1;
				map[1][2] = 1;
				map[2][2] = 2;
			} else if (N == 6) {
				map[2][2] = 2;
				map[3][2] = 1;
				map[2][3] = 1;
				map[3][3] = 2;
			} else {
				map[3][3] = 2;
				map[4][3] = 1;
				map[3][4] = 1;
				map[4][4] = 2;
			}

			for (int i = 0; i < M; i++) {
				int col = sc.nextInt() - 1;
				int row = sc.nextInt() - 1;
				int value = sc.nextInt();

				map[row][col] = value;

				// 8방탐색 시작
				for (int d = 0; d < 8; d++) {
					int nr = row + dr[d];
					int nc = col + dc[d];

					int count = 1;
					// 0을 만나면 탈출하고
					// 같은 수를 만나면 그 전까지 다 바꿈

					// 경계조건
					while (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == (3 - value)) {
						// 일단 나는 1이니까 2를 계속 만나면
						nr += dr[d];
						nc += dc[d];
						count++;

						if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0) {
							break;
						}

						if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == value) {
							while (count-- > 0) {
								map[nr][nc] = value;
								nr -= dr[d];
								nc -= dc[d];
							}
						}
					}

				}

			}

			int blackCnt = 0;
			int whiteCnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 1) {
						blackCnt++;
					}

					if (map[r][c] == 2) {
						whiteCnt++;
					}
				}
			}

			System.out.printf("#%d %d %d\n", tc, blackCnt, whiteCnt);

//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < N; c++) {
//					System.out.print(map[r][c]);
//				}
//				System.out.println();
//			}
		}
		// test case
	}
}