package SWEA_1984.중간평균값구하기;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = 10;
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				sum += arr[i];
				cnt++;
				if (arr[i] > max) {
					max = arr[i];
				}

				if (arr[i] < min) {
					min = arr[i];
				}
			}

			for (int num : arr) {
				if (max == num) {
					sum -= num;
					cnt--;
				}

				if (min == num) {
					sum -= num;
					cnt--;
				}
			}

			int result = (int) Math.round((double) sum / (double) cnt);

			System.out.printf("#%d %d\n", testCase, result);
		}

	}

}
