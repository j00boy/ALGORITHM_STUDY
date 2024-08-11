package boj_14499_주사위굴리기;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	static int x;
	static int y;
	static int K;
	
	static int[] dice;
	
	// 0 동 서 북 남
	static int[] dr = {0, 0, 0, -1, 1};
	static int[] dc = {0, 1, -1, 0, 0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		dice = new int[7];
		
		N = sc.nextInt();
		M = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		for(int k = 0; k < K; k++) {
			
			int d = sc.nextInt();
			
			int nx = x + dr[d];
			int ny = y + dc[d];
			
			if(check(nx, ny)) {
				roll(d);
				
				System.out.println(dice[1]);
				
				x = nx;
				y = ny;
				copy(nx, ny);
			}
		}
		
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	static void roll(int d) {
		int tmp = dice[6];
		
		/*
		 *   2
		 * 4 1 3
		 *   5
		 *   6
		 */
		
		switch(d) {
		case 1: 	// 동
			dice[6] = dice[3];
			dice[3] = dice[1];
			dice[1] = dice[4];
			dice[4] = tmp;
			break;
		case 2:		// 서
			dice[6] = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[3];
			dice[3] = tmp;
			break;
		case 4:		// 남
			dice[6] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[2];
			dice[2] = tmp;
			break;
		case 3:		// 북
			dice[6] = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = tmp;
			break;
		}
	}
	
	static void copy(int r, int c) {
		if(map[r][c] == 0) {
			map[r][c] = dice[6];
		} else {
			dice[6] = map[r][c];
			map[r][c] = 0;
		}
	}
}
