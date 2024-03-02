package swea_7236_저수지의물의총깊이구하기;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_7236_저수지의물의총깊이구하기/input.txt"));
		
		int T = sc.nextInt();
		
		// tc
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] field = new char[N][N];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					field[r][c] = sc.next().charAt(0);
				}
			}
			
			// 8방 탐색
			// 상 하 좌 우 좌상 우상 좌하 우하
			int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
			int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
			int deepest = 0;
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(field[r][c] == 'W') {
						int depth = 0;
						for(int d = 0; d < 8; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							
							if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
								continue;
							}
							
							if(field[nr][nc] == 'W') {
								depth++;
							}
						}
						if(deepest < depth) {
							deepest = depth;
						}
					}
				}
			}
			if(deepest == 0) {
				System.out.printf("#%d %d\n", tc, 1);
			} else {
				System.out.printf("#%d %d\n", tc, deepest);
			}
		}
		// tc
	}
}