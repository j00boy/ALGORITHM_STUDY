package swea_2005_파스칼의삼각형;

import java.util.Scanner;

public class Solution {

	static int N;
	static int map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];

			System.out.println("#" + tc);
			pascal(N);
		}
	}

	public static void pascal(int n) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c <= r; c++) {
				if (c == 0)
					map[r][c] = 1;
				else
					map[r][c] = map[r - 1][c - 1] + map[r - 1][c];
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] != 0)
					System.out.print(map[r][c] + " ");
				else
					System.out.print("");
			}
			System.out.println();
		}

	}
}
