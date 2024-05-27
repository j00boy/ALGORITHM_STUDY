package swea_1954_달팽이숫자;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {

		File file = new File("src/swea_1954_달팽이숫자/input.txt");
		Scanner sc = new Scanner(file);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

			int[][] snail = new int[N][N];

			int[] dr = { 0, 1, 0, -1 }; // 우 하 좌 상
			int[] dc = { 1, 0, -1, 0 }; // 우 하 좌 상

			int r = 0;
			int c = 0;
			int d = 0;

			for (int i = 1; i <= N * N; i++) {

				snail[r][c] = i;

				if (r + dr[d] < 0 || r + dr[d] >= N || c + dc[d] < 0 || c + dc[d] >= N
						|| snail[r + dr[d]][c + dc[d]] != 0) {
					d = (d + 1) % 4;
				}
				r += dr[d];
				c += dc[d];

			}

			System.out.printf("#%d\n", test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}

		}
	}
}