package boj_14501_퇴사;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] D;
	static int[] T;
	static int[] P;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		T = new int[N+1];
		P = new int[N+1];
		D = new int[N+2];
		
		for(int i = 1; i <= N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		D[N+1] = 0;
		for(int i = N-1; i >= 0; i--) {
			if(i + T[i] > N+1) {
				D[i] = D[i+1];
			} else {
				D[i] = Math.max(D[i+T[i]] + P[i], D[i+1]);
			}
		}
		
		System.out.println(Arrays.toString(D));
	}
}
