package swea_1493_수의새로운연산;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_1493_수의새로운연산/input.txt"));
//		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[][] map = new int[300][300];

		int num = 1;
		for (int c = 1; c < 300; c++) {
			map[1][c] = num++;
			int nr = 2;
			int nc = c - 1;
			while (nr >= 1 && nr < 300 && nc >= 1 && nc < 300) {
				map[nr][nc] = num++;
				nr++;
				nc--;
			}

		}

		// tc
		for (int tc = 1; tc <= T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();

			int r1 = 0;
			int c1 = 0;
			int r2 = 0;
			int c2 = 0;

			for (int r = 1; r < 300; r++) {
				for (int c = 1; c < 300; c++) {
					if (map[r][c] == p) {
						r1 = r;
						c1 = c;
					}
					if (map[r][c] == q) {
						r2 = r;
						c2 = c;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, map[r1+r2][c1+c2]);
		}
		// tc
	}

}