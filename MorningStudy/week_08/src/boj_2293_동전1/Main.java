package boj_2293_동전1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 코인의 종류
		int K = sc.nextInt(); // 가치의 합

		int[] coins = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			coins[i] = sc.nextInt();
		}

		Arrays.sort(coins);

		int[][] D = new int[N + 1][K + 1];

		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < K + 1; c++) {
				if (r == 1) {
					if (c % coins[r] == 0) {
						D[r][c] = 1;
						continue;
					}
				}
				if (coins[r] > c) {
					D[r][c] = D[r - 1][c];
				} else {
					D[r][c] = D[r - 1][c] + D[r][c - coins[r]];
				}
			}
		}

		for (int r = 0; r < N + 1; r++) {
			for (int c = 0; c < K + 1; c++) {
				System.out.print(D[r][c] + " ");
			}
			System.out.println();
		}
	}
}