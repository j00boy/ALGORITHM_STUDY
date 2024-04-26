package boj_12100_2048Easy;

import java.util.Scanner;

public class Main {
	
	// 상, 하, 좌, 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int max;
	static int count;
	static int N;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		
	}
	
	static void play() {
		for(int d = 0; d < 4; d++) {
			switch(d) {
				case 0:
					for(int c = 0; c < N; c++) {
						int now = -1;
						for(int r = 0; r < N; r++) {
							if(r == 0) {
								now = map[r][c];
							} else {
								if(map[r][c] != now) {
									now = map[r][c];
								} else if(map[r][c] == 0) {
									continue;
								} else {
									map[r-1][c] += map[r][c];
									now = -1;
								}
							}
						}
					}
					break;
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				default:
					
					break;
			}
		}
	}
}