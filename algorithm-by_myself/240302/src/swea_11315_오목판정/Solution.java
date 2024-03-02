package swea_11315_오목판정;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_11315_오목판정/input.txt"));

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			char[][] board = new char[N][N];

			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < N; c++) {
					board[r][c] = str.charAt(c);
				}
			}
			
			// 행 
			boolean flag = true;
			for(int r = 0; r < N; r++) {
				String str = "";
				for(int c = 0; c < N; c++) {
					str += board[r][c];
				}
				if(str.contains("ooooo")) {
					flag = false;
					break;
				}
			}
			
			if(!flag) {
				System.out.printf("#%d %s\n", tc, "YES");
				continue;
			}
			
			// 열 검사
			for(int c = 0; c < N; c++) {
				String str = "";
				for(int r = 0; r < N; r++) {
					str += board[r][c];
				}
				if(str.contains("ooooo")) {
					flag = false;
					break;
				}
			}
			
			if(!flag) {
				System.out.printf("#%d %s\n", tc, "YES");
				continue;
			}
			
			// 좌상 우상 좌하 우하
			int[] dr = {-1, -1, 1, 1};
			int[] dc = {-1, 1, -1, 1};
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					for(int d = 0; d < 4; d++) {
						String str = ""+board[r][c];
						int nr = r + dr[d];
						int nc = c + dc[d];
						while(nr >= 0 && nr < N && nc >= 0 && nc < N) {
							str += board[nr][nc];
							nr += dr[d];
							nc += dc[d];
						}
						
						if(str.contains("ooooo")) {
							flag = false;
							break;
						}
					}
				}
			}
			
			if(!flag) {
				System.out.printf("#%d %s\n", tc, "YES");
			} else {
				System.out.printf("#%d %s\n", tc, "NO");
			}
			

		}
		// test case
	}
}