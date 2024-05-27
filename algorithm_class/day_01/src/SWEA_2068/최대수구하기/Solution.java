package SWEA_2068.최대수구하기;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// testCase 시작
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = 10;
			int max = Integer.MIN_VALUE;
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			for (int num : arr) {
				if (num > max) {
					max = num;
				}
			}

			System.out.printf("#%d %d\n", testCase, max);
		}
		// testCase 끝

	}

}
