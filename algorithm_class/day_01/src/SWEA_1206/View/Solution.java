package SWEA_1206.View;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = 10;

		// TestCase 시작
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 2; i < N - 2; i++) {
				if (arr[i] >= arr[i - 1] && arr[i] >= arr[i - 2] && arr[i] >= arr[i + 1] && arr[i] >= arr[i + 2]) {
					cnt += Math.min(arr[i] - Math.max(arr[i - 1], arr[i - 2]),
							arr[i] - Math.max(arr[i + 1], arr[i + 2]));
				} else {
					continue;
				}
			}

			System.out.printf("#%d %d\n", testCase, cnt);

		}
		// TestCase 끝

	}

}
