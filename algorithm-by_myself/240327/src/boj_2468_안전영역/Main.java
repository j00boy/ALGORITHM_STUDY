package boj_2468_안전영역;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] KOR;		// 맵 
	static int maxHgt = 0;		// 맵의 최고 높이 
	static int minHgt = 100;	// 맵의 최저 높이 
	static boolean[][] visited;	// 방문체크 
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		KOR = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				KOR[r][c] = sc.nextInt();
				maxHgt = Math.max(maxHgt, KOR[r][c]);
				minHgt = Math.min(minHgt, KOR[r][c]);
			}
		}
		
		int maxCount = 0;
		
		for(int i = minHgt; i <= maxHgt; i++) {
			visited = new boolean[N][N];	// 각 limit일 때의 새로운 방문체크 배열 생성
			int count = 0;
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(KOR[r][c] >= i && !visited[r][c]) {
						DFS(r, c, i);
						count++;
					}					
				}
			}
			
			if(maxCount < count) {
				maxCount = count;
			}
		}
		
		System.out.println(maxCount);
		
	}
	
	static void DFS(int r, int c, int limit) {
		if(KOR[r][c] < limit) return;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(check(nr, nc) && !visited[nr][nc]) {
				visited[nr][nc] = true;
				DFS(nr, nc, limit);
			}
		}
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
