/*
 * 연속되는 경우로 생각해야 할 것 같음
 */

package boj_1182_부분수열의합;

import java.util.Scanner;

public class Main2 {

	static int N; // 주어지는 정수의 갯수
	static int S; // 목표 합
	static int count;
	static int[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();

		count = 0;

		nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = i; j < N; j++) {
				sum += nums[j];
				if (sum == S) {
					count++;
				}
			}
		}

		System.out.println(count);

	}
}