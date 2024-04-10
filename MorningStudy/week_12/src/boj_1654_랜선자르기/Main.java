package boj_1654_랜선자르기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int K;
	static int N;
	static int[] lan;
	static int mid;
	static int right;
	static int left;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt(); // 이미 가지고 있는 랜선의 개수
		N = sc.nextInt(); // 필요한 랜선의 개수 ( 기존의 K개의 랜선으로 N개를 가지고 있는 경우는 없게 한다. )
		lan = new int[K];

		for (int i = 0; i < K; i++) {
			lan[i] = sc.nextInt();
		}

		right = 1000000;
		left = 1;
		
		while (left < right) {
			mid = (left + right) / 2;

			int ans = divide(mid);
			
			if(ans >= N) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}

		System.out.println(right - 1);
	}

	public static int divide(int len) {
		int cnt = 0;
		for (int line : lan) {
			cnt += line / len;
		}

		return cnt;
	}

}