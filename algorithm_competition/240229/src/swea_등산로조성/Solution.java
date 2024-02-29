package swea_등산로조성;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_등산로조성/input.txt"));

		int T = sc.nextInt();

		// 상 하 좌 우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		// test case
		for (int tc = 1; tc <= T; tc++) {

			// 산 크기, 최대 공사 가능 깊이
			int N = sc.nextInt(); // 한 변의 길이
			int K = sc.nextInt(); // 최대 공사 가능 깊이

			// 산 만들기
			int[][] mountain = new int[N][N];

			// 입력과 동시에 가장 높은 높이를 찾자.
			int maxHeight = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int n = sc.nextInt();
					mountain[r][c] = n;
					if (n > maxHeight) {
						maxHeight = n;
					}
				}
			}

			int longest = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 가장 높은 산을 만난 경우,
					if (mountain[r][c] == maxHeight) {
						for(int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
						}
						
					}
				}
			}

			System.out.printf("#%d %d\n", tc, longest);
		}
		// test case
	}

}
