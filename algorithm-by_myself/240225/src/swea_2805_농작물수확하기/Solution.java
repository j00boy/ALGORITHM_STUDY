package swea_2805_농작물수확하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();

			int[][] farm = new int[N][N];

			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < N; c++) {
					farm[r][c] = Character.getNumericValue(str.charAt(c));
				}
			}

			int mid = N / 2;

			int profit = 0;
			int d = 0;
			for (int r = 0; r < N; r++) {
				for (int c = mid - d; c <= mid + d; c++) {
					profit += farm[r][c];
				}
				if(r < mid) {
					d++;
				} else {
					d--;
				}
			}

			System.out.printf("#%d %d\n", tc, profit);
		}
		// test case
	}
}
