package boj_1987_알파벳;

import java.util.Scanner;

public class Main {
	
	static int R;
	static int C;
	static String[][] board;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static String str = "";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		board = new String[R+1][C+1];
		
		for(int r = 1; r <= R; r++) {
			String str = sc.next();
			for(int c = 1; c <= C; c++) {
				board[r][c] = str.charAt(c)+"";
			}
		}
		
		str += board[1][1];
		
		
	}
	
	public static void DFS(int r, int c) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(check(nr, nc) && !str.contains(board[nr][nc])) {
				str += board[nr][nc];
				DFS(nr, nc);
			}
		}
	}
	
	public static boolean check(int r, int c) {
		return r >= 1 && c >= 1 && r <= R && c <= C; 
	}
}
