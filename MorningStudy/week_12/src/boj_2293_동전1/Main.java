package boj_2293_동전1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n;
	static int k;
	static int[] coins;
	static int[][] D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();
		coins = new int[n];

		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}

		Arrays.sort(coins);

		D = new int[n][k + 1];

		for (int c = 0; c < k + 1; c++) {
			D[0][c] = 1;
		}

		for (int r = 1; r < n; r++) {
			for (int c = 1; c < k + 1; c++) {
				if (c < coins[r]) {
					D[r][c] = D[r - 1][c];
				} else {
					D[r][c] = Math.max(D[r - 1][c], D[r][c - 1]);
				}
			}
		}

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < k + 1; c++) {
				System.out.print(D[r][c] + " ");
			}
			System.out.println();
		}

		System.out.println(D[n - 1][k]);

	}
}