package boj_2206_벽부수고이동하기;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int[][] time;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		time = new int[N][M];
		visited = new boolean[N][M];

		/*
		 * 0100
		 * 1110
		 * 1000
		 * 0000
		 * 0111
		 * 0000
		 */

		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = Character.getNumericValue(str.charAt(c));
			}
		}


	}
	
	public static void breakWall(int row, int col) {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 1) {
					map[r][c] = 0;
				}
			}
		}
	}
	
	public static void BFS(int r, int c) {
		Queue<Integer> queue = new LinkedList<>();
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		queue.add(r);
		queue.add(c);
		time[r][c] = 1;
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int now_r = queue.poll();
			int now_c = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];
				
				if(check(nr, nc) && map[nr][nc] == 0) {
					time[nr][nc] = time[r][c] + 1;
				}
			}
		}
		
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
}