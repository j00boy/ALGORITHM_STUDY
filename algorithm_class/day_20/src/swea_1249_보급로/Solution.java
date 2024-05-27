package swea_1249_보급로;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	
	static class Node implements Comparable<Node> {
		int r;
		int c;
		int w;
		
		public Node(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] map;
	static int[][] D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			map = new int[N][N];
			D = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				String str = sc.next();
				for(int c = 0; c < N; c++) {
					map[r][c] = Character.getNumericValue(str.charAt(c));
					D[r][c] = INF;
				}
			}
			
			dijkstra(0, 0);
			
			System.out.printf("#%d %d\n", tc, D[N-1][N-1]);
			
		}
		// test case
	}
	
	static void dijkstra(int r, int c) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		boolean[][] visited = new boolean[N][N];
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		D[r][c] = 0;
		
		pq.add(new Node(r, c, D[0][0]));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.r][curr.c]) {
				continue;
			}
			
			visited[curr.r][curr.c]= true;
			for(int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if(check(nr, nc) && !visited[nr][nc] && D[nr][nc] > D[curr.r][curr.c] + map[nr][nc]) {
					D[nr][nc] = D[curr.r][curr.c] + map[nr][nc];
					pq.add(new Node(nr, nc, D[nr][nc]));
				}
			}
		}
		
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
}