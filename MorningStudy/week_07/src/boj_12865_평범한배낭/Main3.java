package boj_12865_평범한배낭;

import java.util.Scanner;

public class Main3 {

	static int N; // 물품의 수
	static int K; // 배낭이 버틸 수 있는 무게
	static int[][] D; // 점화식 배열 -> [1~N번째 물건까지 사용할 수 있는 경우] * [1~K까지 가방이 버틸 수 있는 최대 무게] 라서 2차원 배열 형태의
						// DP 테이블
	static int[][] info; // [i][0]에는 무게, [i][1]에는 가치

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		D = new int[N + 1][K + 1];
		info = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			info[i][0] = sc.nextInt(); // weight
			info[i][1] = sc.nextInt(); // value
		}

		/*
		 * Top-down 방식 - 재귀함수
		 */
		System.out.println(getMaxValue(N, K));

//		for(int r = 0; r < N+1; r++) {
//			for(int c = 0; c < K+1; c++) {
//				System.out.printf("%3d", D[r][c]);
//			}
//			System.out.println();
//		}


	}

	public static int getMaxValue(int r, int c) { // r: 1~r번째 물건, c: 가방이 버티는 최대 무게

		// 기저 조건
		// r이나 c가 하나라도 0이면 return 0
		if (r == 0 || c == 0) {
			return 0;
		}

		// 재귀 조건
		if (info[r][0] > c) {
			D[r][c] = getMaxValue(r - 1, c);
		} else {
			D[r][c] = Math.max(getMaxValue(r - 1, c), getMaxValue(r - 1, c - info[r][0]) + info[r][1]);
		}

		return D[r][c];
	}
}
