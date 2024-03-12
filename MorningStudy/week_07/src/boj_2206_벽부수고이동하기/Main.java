package boj_2206_벽부수고이동하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] leng;
	static boolean[][] visited;
	static boolean[][] breakVisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		leng = new int[N][M];
		visited = new boolean[N][M];
		breakVisited = new boolean[N][M];
		
		for(int r = 0; r < N; r++) {
			String str = sc.next();
			for(int c = 0; c < M; c++) {
				map[r][c] = Character.getNumericValue(str.charAt(c));
			}
		}

		int min = Integer.MAX_VALUE;
		
		// 안 부수는 BFS
		int peace = peacefulBFS(0, 0);
		if (peace != 0 && peace < min) {
			min = peace;
		}
		
		
		// 부수는 BFS
		leng = new int[N][M];
		int cruel = cruelBFS(0, 0, 0);
		if (cruel != 0 && cruel < min) {
			min = cruel;
		}
		
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		
		
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
	
	public static int cruelBFS(int r, int c, int breakWall) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(r);
		queue.add(c);
		queue.add(breakWall);
		
		leng[r][c] = 1;
		breakVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			
			boolean flag = true;
			
			int now_r = queue.poll();
			int now_c = queue.poll();
			int now_breakWall = queue.poll();
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			
			for(int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];
				
				if(check(nr, nc) && map[nr][nc] == 0 && !breakVisited[nr][nc]) {
					queue.add(nr);
					queue.add(nc);
					queue.add(now_breakWall);
					leng[nr][nc] = leng[now_r][now_c] + 1;
					if(nr == N-1 && nc == M-1) {
						flag = false;
						break;
					}
				} else if(check(nr, nc) && map[nr][nc] == 1 && !breakVisited[nr][nc] && now_breakWall == 0) {
					map[nr][nc] = 0;
					queue.add(nr);
					queue.add(nc);
					queue.add(1);
					breakVisited[nr][nc] = true;
					leng[nr][nc] = leng[now_r][now_c] + 1;
					if(nr == N-1 && nc == M-1) {
						flag = false;
						break;
					}
					map[nr][nc] = 1;
				} 
			}
			if(!flag) break;
		}
		
		return leng[N-1][M-1];
	}
	
	public static int peacefulBFS(int r, int c) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(r);
		queue.add(c);
		leng[r][c] = 1;
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			boolean flag = true;
			
			int now_r = queue.poll();
			int now_c = queue.poll();
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			
			for(int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];
				
				if(check(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
					queue.add(nr);
					queue.add(nc);
					visited[nr][nc] = true;
					leng[nr][nc] = leng[now_r][now_c] + 1;
					if(nr == N-1 && nc == M-1) {
						flag = false;
						break;
					}
				}
			}
			if(!flag) break;
		}
		
		return leng[N-1][M-1];
	}
	
}