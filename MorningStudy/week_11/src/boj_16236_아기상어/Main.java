package boj_16236_아기상어;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 0, 1, 0 }; // 상 좌 하 우
	static int[] dc = { 0, -1, 0, 1 }; // 상 좌 하 우
	static int N;
	static int[][] pool;
	static int init_r; // 아기상어 첫 위치 저장
	static int init_c; // 아기상어 첫 위치 저장
	static int size; // 아기상어 크기
	static int exp; // 아기상어 레벨업 경험치
	static int total_distance; // 총 이동거리
	static boolean canHunt;
	static ArrayList<int[]> list; // 최단 거리 내 가능한 좌표들 저장값
	static int depth;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		pool = new int[N][N];
		size = 2;
		exp = 2;
		total_distance = 0;

		// 아기상어 위치 저장 변수
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				pool[r][c] = sc.nextInt();
				if (pool[r][c] == 9) {
					init_r = r;
					init_c = c;
				}
			}
		}

		// 사냥을 계속 할 수 있는지에 대한 flag 변수
		canHunt = true;
		while (canHunt) {
			hunt(init_r, init_c);
			if(!list.isEmpty()) {
				kill(list.get(0));
			}
			
			print();
			System.out.println(size);
			System.out.println(exp);
			System.out.println();
		}

		System.out.println(total_distance);
	}

	public static void hunt(int r, int c) {
		depth = 0;

		list = new ArrayList<>();

		Queue<Integer> queue = new LinkedList<>();

		boolean[][] visited = new boolean[N][N];

		visited[r][c] = true;

		queue.add(r);
		queue.add(c);
		queue.add(0);

		while (!queue.isEmpty()) {
			int now_r = queue.poll();
			int now_c = queue.poll();
			int now_dist = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];

				if (check(nr, nc) && !visited[nr][nc] && pool[nr][nc] <= size) {
					if (pool[nr][nc] < size && pool[nr][nc] != 0) {
						visited[nr][nc] = true;
						queue.add(nr);
						queue.add(nc);
						queue.add(now_dist + 1);
						if (now_dist + 1 != depth) {
							if (!list.isEmpty()) {
								return;
							}
							depth++;
							list.add(new int[] { r, c });
						} else {
							list.add(new int[] { r, c });
						}
					} else {
						visited[nr][nc] = true;
						queue.add(nr);
						queue.add(nc);
						queue.add(now_dist + 1);
					}
				}
			}
		}

		canHunt = false;
	}

	public static void kill(int[] arr) {
		Collections.sort(list, new Comparator<int []>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[1]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
			
		});
		
		total_distance += depth;
		pool[arr[0]][arr[1]] = 9;
		pool[init_r][init_c] = 0;
		exp--;
		init_r = arr[0];
		init_c = arr[1];
		if(exp == 0) {
			size++;
			exp = size;
		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	public static void print() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(pool[r][c] + " ");
			}
			System.out.println();
		}
	}
}
