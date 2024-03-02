package swea_11315_오목판정;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_11315_오목판정/input.txt"));

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			char[][] board = new char[N][N];

			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < N; c++) {
					board[r][c] = str.charAt(c);
				}
			}

			// 델타 탐색
			int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
			int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

			boolean isValid = false;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (board[r][c] == 'o') {	// 돌이 있으면
						for (int d = 0; d < 8; d++) {
							int cnt = 0;
							int nr = r;
							int nc = c;
							while (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 'o') {
								cnt++;
								nr += dr[d];
								nc += dc[d];
							}
							if (cnt >= 5) {
								isValid = true;
								break;
							}
						}
						if(isValid) {
							break;
						}
					}
				}
				if(isValid) {
					break;
				}
			}

			if (isValid) {
				System.out.printf("#%d %s\n", tc, "YES");
			} else {
				System.out.printf("#%d %s\n", tc, "NO");
			}

		}
		// test case
	}
}