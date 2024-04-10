package boj_1107_리모컨;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	static int N;
	static int M;
	static int[] button = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int minCnt = Integer.MAX_VALUE;
	static int subin = 100;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int wrong = sc.nextInt();
			button[wrong] = -1;
		}

		minCnt = Math.min(Math.abs(N - subin), minCnt);

		char[] NArr = String.valueOf(N).toCharArray();
		int leng = String.valueOf(N).length();
//		System.out.println(Arrays.toString(button));

		int[] minNum = new int[leng];
		int[] maxNum = new int[leng];
		int sum = 0;
		int standard = 0;

		// target 이상의 채널로 누를 수 있는 최소 채널
		boolean flag = true;
		for (int i = 0; i < leng; i++) {
			if (i == 0) {
				int min = 11;
				for (int j = NArr[i] - '0'; j < 10; j++) {
					if (NArr[i] - '0' <= button[j] && button[j] != -1) {
						min = button[j];
						break;
					}
				}
				if (min == 11) {
					flag = false;
					break;
				}
				minNum[i] = min;
				sum = 10 * sum + min;
				standard = 10 * standard + NArr[i] - '0';
			} else {
				int min = 11;
				if (sum > standard) {
					for (int j = 0; j < 10; j++) {
						if (button[j] != -1) {
							min = button[j];
							break;
						}
					}
					minNum[i] = min;
					sum = 10 * sum + min;
					standard = standard * 10 + NArr[i] - '0';
				} else {
					for (int j = NArr[i] - '0'; j < 10; j++) {
						if (NArr[i] - '0' <= button[j] && button[j] < min && button[j] != -1) {
							min = button[j];
						}
					}
					minNum[i] = min;
					sum = 10 * sum + min;
					standard = standard * 10 + NArr[i] - '0';
				}
			}
		}
		if (flag) {
			minCnt = Math.min(minCnt, Math.abs(N - sum) + leng);
		}
//		System.out.println(Arrays.toString(NArr));
//		System.out.println(Arrays.toString(minNum));
//		System.out.println(sum);

		// target 이하의 채널로 누를 수 있는 최대 채널
		sum = 0;
		flag = true;
		
		standard = 0;
		for (int i = 0; i < leng; i++) {
			if (i == 0) {
				int max = -2;
				for (int j = NArr[i] - '0'; j >= 0; j--) {
					if (NArr[i] - '0' >= button[j] && button[j] != -1) {
						max = button[j];
						break;
					}
				}
				if(max == -2) {
					flag = false;
					break;
				}
				maxNum[i] = max;
				sum = 10 * sum + max;
				standard = standard * 10 + NArr[i] - '0';
			} else {
				int max = -2;
				if (sum <= standard) {
					for (int j = 9; j >= 0; j--) {
						if (button[j] != -1) {
							max = button[j];
							break;
						}
					}
					maxNum[i] = max;
					sum = 10 * sum + max;
					standard = standard * 10 + NArr[i] - '0';
				} else {
					for (int j = NArr[i] - '0'; j >= 0; j--) {
						if (NArr[i] - '0' >= button[j] && button[j] != -1) {
							max = button[j];
							break;
						}
					}
					maxNum[i] = max;
					sum = 10 * sum + max;
					standard = standard * 10 + NArr[i] - '0';
				}
			}
		}
		if(flag) {
			minCnt = Math.min(minCnt, Math.abs(N - sum) + leng);
		}
//		System.out.println(Arrays.toString(NArr));
//		System.out.println(Arrays.toString(maxNum));
//				System.out.println(sum);


		System.out.println(minCnt);
	}
}