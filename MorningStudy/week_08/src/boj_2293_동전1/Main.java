package boj_2293_동전1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 	// 코인의 종류
		int K = sc.nextInt();	// 가치의 합
		
		int[] coins = new int[N];
		
		for(int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}
		
		
	}
}