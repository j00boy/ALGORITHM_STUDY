package boj_11726_2xN타일링;

import java.util.Scanner;

public class Main {

	static int N;
	static long[] DP;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		DP = new long[N + 1];	// 길이 N으로 만들 수 있는 타일의 경우의 수의 합

		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				DP[i] = 1;

			} else if (i == 2) {
				DP[i] = 2;
			} else {
				DP[i] = DP[i - 1] + DP[i - 2];
				DP[i] %= 10007;
			}
		}

		System.out.println(DP[N]);
	}
}
