/**
 * [GOLD 5]
 * [토마토]
 * - BFS로 풀며, 모든 칸이 다 차는데 걸리는 최소 시간을 계산
 */

package boj_7576_토마토;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[][] tomatoes;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		tomatoes = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				tomatoes[r][c] = sc.nextInt();
			}
		}
		
		
	}
	
	public static void BFS(int r, int c) {
		
	}

}