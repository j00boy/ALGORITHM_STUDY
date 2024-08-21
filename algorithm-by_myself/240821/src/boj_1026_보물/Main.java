package boj_1026_보물;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] A = new int[N];
		int[] B = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		
		Arrays.sort(B);
		Arrays.sort(A);
		
		int S = 0;
		
		for(int i = 0; i < N; i++) {
			S += B[i] * A[N-1-i];
		}
		
		System.out.println(S);
	}
}
