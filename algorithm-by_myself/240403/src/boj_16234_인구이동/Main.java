package boj_16234_인구이동;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] A;
	static int N;
	static int L;
	static int R;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int count = 0;
	static int day = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 변의 크기
		L = sc.nextInt(); // 인구차이 min
		R = sc.nextInt(); // 인구차이 max

		A = new int[N][N]; // 땅

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				A[r][c] = sc.nextInt();
			}
		}

		while (true) {
			visited = new boolean[N][N];
			count = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(!visited[r][c]) {
						getUnion(r, c);
						count++;
					}
				}
			}
			
			day++;
			if(count == N * N) {
				System.out.println(day-1);
				return;
			}
		}
	}

	public static void getUnion(int r, int c) {

		if (visited[r][c]) {
			return;
		}

		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> row = new ArrayList<>();
		ArrayList<Integer> col = new ArrayList<>();
		int cnt = 1;
		int sum = A[r][c];
		visited[r][c] = true;

		queue.add(r);
		queue.add(c);
		row.add(r);
		col.add(c);

		while (!queue.isEmpty()) {
			int now_r = queue.poll();
			int now_c = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];

				if (check(nr, nc)) {
					int gap = Math.abs(A[now_r][now_c] - A[nr][nc]);

					if (!visited[nr][nc] && gap <= R && gap >= L) {
						queue.add(nr);
						queue.add(nc);
						row.add(nr);
						col.add(nc);
						cnt++;
						sum += A[nr][nc];
						visited[nr][nc] = true;
					}
				}
			}
		}
		
//		System.out.println(row);
//		System.out.println(col);

		int avg = sum / cnt;

		for (int i = 0; i < row.size(); i++) {
			A[row.get(i)][col.get(i)] = avg;
		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
