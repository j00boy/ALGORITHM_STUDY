package boj_1654_랜선자르기;

import java.util.Scanner;

public class Main {

	static int K;
	static int N;
	static int[] lan;
	static long mid;
	static long right;
	static long left;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt(); // 이미 가지고 있는 랜선의 개수
		N = sc.nextInt(); // 필요한 랜선의 개수 ( 기존의 K개의 랜선으로 N개를 가지고 있는 경우는 없게 한다. )
		lan = new int[K];
		right = 0;
		
		for (int i = 0; i < K; i++) {
			lan[i] = sc.nextInt();
			if(right < lan[i]) {
				right = lan[i];
			}
		}

		right = right + 1;
		left = 1;
		
		while (left < right) {
			mid = (left + right) / 2;

			long ans = divide(mid);
			
			if(ans >= N) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}

		System.out.println(left - 1);
		
	}

	public static long divide(long len) {
		long cnt = 0;
		for (int i = 0; i < lan.length; i++) {
			cnt += (lan[i] / len);
		}

		return cnt;
	}

}