package boj_2206_벽부수고이동하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int[][] time;
	static boolean[][] visited;

	public static void main(String[] args) {

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

		int min = Integer.MAX_VALUE;
		
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 1) {
					map[r][c] = 0;
					time = new int[N][M];
					BFS(0, 0);
					if(time[N-1][M-1] != 0) {
						if(time[N-1][M-1] < min) {
							min = time[N-1][M-1];
						}
					}
					map[r][c] = 1;
				}
			}
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		
	}
	
	public static void BFS(int r, int c) {		// r과 c는 시작점 -> (0, 0)
		Queue<Integer> queue = new LinkedList<>();
		
		// 상 하 좌 우
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
				
				if(check(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
					queue.add(nr);
					queue.add(nc);
					time[nr][nc] = time[now_r][now_c] + 1;
					visited[nr][nc] = true;
				}
			}
		}
		
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
}