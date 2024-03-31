package boj_1149_RGB거리;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] rgb;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;
	static int sum = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		rgb = new int[N][3];
		visited = new boolean[N][3];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < 3; c++) {
				rgb[r][c] = sc.nextInt();
			}
		}
		
		int sum  = 0;
		for(int c = 0; c < 3; c++) {
			visited[0][c] = true;
			sum += rgb[0][c];
			permutation(1);
			visited[0][c] = false;
			sum -= rgb[0][c];
		}
		
		System.out.println(min);
		
		
	}
	
	public static void permutation(int idx) {
		if(idx >= N) {
			int sum = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < 3; c++) {
					if(visited[r][c]) {
						sum += rgb[r][c];
					}
				}
			}
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			if(!visited[idx-1][i]) {
				visited[idx][i] = true;
				permutation(idx + 1);
				visited[idx][i] = false;
			}
		}
	}
}
