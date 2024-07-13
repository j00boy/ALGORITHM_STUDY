package boj_14925_목장건설하기;

import java.util.Scanner;

public class Main {
	
	static int M;
	static int N;
	static int[][] map;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[M][N];
		max = 0;
		
		for(int r = 0; r < M; r++) {
			for(int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		
		
	}
}
