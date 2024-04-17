import java.util.Scanner;

public class Solution {

	/*
	 * 왼 아래 오른 위+1 왼 위 오른 아래-1
	 */
	static int[] dr = { 0, 1, 0, -1, 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0, -1, 0, 1, 0 };
	static boolean[][] visited;
	static int[][] map;
	static int R;
	static int C;
	static int num;
	static int d;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			R = sc.nextInt();
			C = sc.nextInt();

			d = 0;
			num = 1;
			map = new int[R][C];
			visited = new boolean[R][C];

			snail(0, C - 1);

			print();
		}
	}

	public static void snail(int r, int c) {
		int count = 0;
		visited[r][c] = true;
		map[r][c] = num++;

		while (num <= R * C) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(count % 8 == 3) {
				if(check(nr, nc) && !visited[nr][nc]) {
					map[nr][nc] = num++;
					visited[nr][nc] = true;
					r += dr[d];
					c += dc[d];
					d = (d+1) % 8;
					count++;
					continue;
				}
			}
			
			if(count % 8 == 7) {
				if(check(nr, nc) && !visited[nr][nc]) {
					map[nr][nc] = num++;
					visited[nr][nc] = true;
					r += dr[d];
					c += dc[d];
					d = (d+1) % 8;
					count++;
					continue;
				}
			}
			
			if (check(nr, nc) && !visited[nr][nc]) {
				visited[nr][nc] = true;
				map[nr][nc] = num++;
				r += dr[d];
				c += dc[d];
			} else {
				d = (d+1) % 8;
				count++;
			}
		}

	}

	public static void print() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
