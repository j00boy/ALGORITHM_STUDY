package swea_2817_부분수열의합;

import java.util.Scanner;

public class Solution {
	
	static int[] arr;
	static int K, N;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			
			count = 0;
			
			N = sc.nextInt();
			K = sc.nextInt();
			
			arr = new int[N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			combination(0, 0);
			
			System.out.printf("#%d %d\n", tc, count);
		}
		// test case
		
	}
	
	public static void combination(int idx, int sum) {
		if(sum == K) {
			count++;
			return;
		}
		
		if(idx >= N) {
			return;
		}
		
		combination(idx + 1, sum + arr[idx]);
		
		combination(idx + 1, sum);
	}
	
}