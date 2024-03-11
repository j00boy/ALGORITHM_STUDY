package boj_2193_이친수;

import java.util.Scanner;

public class Main {

	static int N;
	static long[] D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
//		D = new long[N + 1];
//
//		// bottom-UP 방식
//
//		for (int i = 1; i <= N; i++) {
//			if (i == 1 || i == 2) {
//				D[i] = 1;
//			}
//			if (i >= 3) {
//				D[i] = D[i - 1] + D[i - 2];
//			}
//		}
//
//		System.out.println(D[N]);

		long[][] DP = new long[N+1][2];
		
		for(int i = 1; i <= N; i++) {
			
			if(i == 1) {
				DP[1][0] = 0;
				DP[1][1] = 1;
			}
			
			if(i == 2) {
				DP[2][0] = 1;
				DP[2][1] = 0;
			}
			
			if(i >= 3) {
				DP[i][0] = DP[i-1][0] + DP[i-1][1];
				DP[i][1] = DP[i-1][0];
			}
		}
		
		System.out.println(DP[N][0] + DP[N][1]);
	}
}
