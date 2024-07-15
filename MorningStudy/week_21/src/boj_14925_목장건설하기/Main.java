package boj_14925_목장건설하기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int M;
	static int N;
	static int[][] map;
	static int max;
	
	static int[][] D;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[M][N];
		D = new int[M][N];
		max = 0;
		
		for(int r = 0; r < M; r++) {
			for(int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		// 첫 열
		int can = 1;
		for(int c = 0; c < N; c++) {
			if(map[0][c] == 0) {
				D[0][c] = can;
				can++;
			} else {
				D[0][c] = 0;
				can = 1;
			}
		}
		
//		System.out.println(Arrays.toString(D[0]));
		
		// 첫 행
		can = 1;
		for(int r = 0; r < M; r++) {
			if(map[r][0] == 0) {
				D[r][0] = can;
				can++;
			} else {
				D[r][0] = 0;
				can = 1;
			}
		}
		
		for(int r = 1; r < M; r++) {
			for(int c = 1; c < N; c++) {
				if(map[r][c] == 1) {
					D[r][c] = 0;
				} else if(map[r][c] == 2) {
					D[r][c] = 0;
				} else {	// 목장을 지을 수 있을 때
					D[r][c] = Math.min(Math.min(D[r-1][c] + 1, D[r][c-1] + 1), D[r-1][c-1] + 1);
				}
			}
		}
		
//		System.out.println(max);
		
		for(int r = 0; r < M; r++) {
			for(int c = 0; c < N; c++) {
				System.out.print(D[r][c] + " ");
			}
			System.out.println();
		}
		
	}
}
