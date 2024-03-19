package boj_15486_퇴사2;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	static int N;
	static int[] T;
	static int[] P;
	static int[] DP;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		T = new int[N + 1]; // 진행일
		P = new int[N + 1]; // 수익
		DP = new int[N + 2]; // i번쨰까지 일을 했을 때 얻을 수 있는 최대 수익 memoization
		int dDay = N + 1; // 퇴사일

		for (int i = 1; i <= N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}

		// 바텀-업 방식
		// 이거는 다시 봐도 어렵
		DP[0] = 0;
		DP[1] = 0;
		for(int i = 1; i <= N+1; i++) {
			for(int j = 0; j < i; j++) {
				// 전꺼가 현재꺼에 유효한 수치라면(물려받을 수 있다면)
				if(j + T[j] <= i) {
					// j번째 일을 하는 경우 vs 하지 않는 경우
					DP[i] = Math.max(DP[j] + P[j], DP[i]);
				}
			}
		}

//		System.out.println(Arrays.toString(DP));
		System.out.println(DP[N+1]);
	}
}