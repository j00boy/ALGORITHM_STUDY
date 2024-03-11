package boj_2579_계단오르기;

import java.util.Scanner;

public class Main {
	
	static int N;			// 계단의 개수 <= 300
	static int[] D;		// 10000 * 300 = 3,000,000
	static int[] scores;	// 300
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		D = new int[N+1];
		scores = new int[N+1];
		
		for(int i = N; i >= 1; i--) {
			scores[i] = sc.nextInt();
		}
		
		for(int i = N; i >= 1; i--) {
			if(i == N) {
				D[i] = scores[N];
			} else if(i == N-1) {
				D[i] = scores[N-1] + scores[N];
			} else if(i == N-2) {
				D[i] = Math.max(D[i+2] + scores[i], D[i+2] + scores[i+1]);
			} else {
				D[i] = Math.max(D[i+3] + scores[i+2] + scores[i], D[i+3] + scores[i+1] + scores[i]);
			}
		}
		
		System.out.println(D[1]);
	}
}