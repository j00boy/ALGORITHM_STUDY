package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int N;
	static char[][] maze;
	static int[][] time;
	static boolean[][] visited;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		maze = new char[N][N];
		
		
		for(int r = 0; r < N; r++) {
			String str = sc.next();
			for(int c = 0; c < N; c++) {
				maze[r][c] = str.charAt(c);
			}
		}
		
//		print();
		BFS(N-1, 0);
		
		if(time[0][N-1] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(time[0][N-1]);
		}
		
	}
	
	static void BFS(int r, int c) {
		time = new int[N][N];
		visited = new boolean[N][N];
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(r);
		queue.add(c);
		queue.add(1);
		
		time[r][c] = 0;
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int now_r = queue.poll();
			int now_c = queue.poll();
			int now_time = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];
				int ntime = now_time + 1;
				int teleport = now_time + 2;
				
				if(check(nr, nc) && maze[nr][nc] == '.') {
					if(!visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(nr);
						queue.add(nc);
						queue.add(ntime);
						time[nr][nc] = ntime;
					} else {
						if(ntime < time[nr][nc]) {
							queue.add(nr);
							queue.add(nc);
							queue.add(ntime);
							time[nr][nc] = ntime;
						}
					}
					
					// check
					if(time[0][N-1] != 0) {
						return;
					}
					
					// 텔레포트를 할 수 있을 때
					nr = N - 1 - nr;
					nc = N - 1 - nc;
					if(maze[nc][nr] == '.') {
						if(!visited[nc][nr]) {
							visited[nc][nr] = true;
							queue.add(nc);
							queue.add(nr);
							time[nc][nr] = teleport;
							queue.add(teleport);
						} else {
							if(teleport < time[nc][nr]) {
								queue.add(nc);
								queue.add(nr);
								time[nc][nr] = teleport;
								queue.add(teleport);
							}
						}
					}
					
					// check
					if(time[0][N-1] != 0) {
						return;
					}
					
					print();
				}
			}
		}
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	static void print() {
		System.out.println("====================");
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				System.out.print(time[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("====================");
	}
}

/*
.....
..###
.##..
##...
.....

#.#..
#.#.#
#...#
####.
.....
*/