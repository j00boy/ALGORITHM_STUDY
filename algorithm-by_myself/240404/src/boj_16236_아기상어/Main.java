package boj_16236_아기상어;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] pool;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		pool = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				pool[r][c] = sc.nextInt();
			}
		}
		
		
	}
}
