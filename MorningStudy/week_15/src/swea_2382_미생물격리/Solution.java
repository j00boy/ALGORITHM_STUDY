package swea_2382_미생물격리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static List<int[]> list;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N; // 한 변에 있는 셀의 개수
	static int M; // 격리 시간
	static int K; // 미생물 군집의 개수
	static int[][] map; // 미생물 군집 맵

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {

			list = new ArrayList<>();

			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][N];

			// 미생물 군집 입력받기
			for (int i = 0; i < K; i++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				int count = sc.nextInt();
				int dir = sc.nextInt() - 1;
				list.add(new int[] { row, col, count, dir, count });
				map[row][col] = count;
			}
			
//			print();

			// 시간이 M시간 만큼 흐름
			for (int t = 1; t <= M; t++) {
				// 모든 군집을 돔

				map = new int[N][N];
				
				for (int i = 1; i <= K; i++) {
					
					if(list.get(i-1)[0] == -1) {
						continue;
					}
					
					int r = list.get(i-1)[0];
					int c = list.get(i-1)[1];
					int count = list.get(i-1)[2];
					int d = list.get(i-1)[3];
					int orgCount = list.get(i-1)[4];

					int nr = r + dr[d];
					int nc = c + dc[d];

					if (check(nr, nc)) {
						if(map[nr][nc] == 0) {
							list.set(i-1, new int[] { nr, nc, count, d, orgCount});
							map[nr][nc] = i;
						} else {
							if(list.get(map[nr][nc]-1)[4] < orgCount) {	// 내가 더 군집이 크다면
								list.set(i-1, new int[] { nr, nc, count + list.get(map[nr][nc]-1)[2], d, orgCount});
								list.set(map[nr][nc] - 1, new int[] {-1});
								map[nr][nc] = i;
							} else {		// 내가 더 작다면
								list.set(map[nr][nc] - 1, new int[] { nr, nc, count + list.get(map[nr][nc]-1)[2], list.get(map[nr][nc]-1)[3], list.get(map[nr][nc]-1)[4] });
								list.set(i-1, new int[] {-1});
							}
						}
					} else {
						if(d == 0) {
							d = 1;
						} else if(d == 1) {
							d = 0;
						} else if(d == 2) {
							d = 3;
						} else {
							d = 2;
						}
						
						if(count / 2 == 0) {
							list.set(i-1, new int[] {-1});
						} else {
							list.set(i - 1, new int[] { nr, nc, count / 2, d, count / 2 });
						}
					}
					
				}
				
				// 다시 시간이 지난 후 비교를 위한 orgCount 초기화
				for(int i = 0; i < K; i++) {
					if(list.get(i)[0] != -1) {
						int orgCount = list.get(i)[2];
						list.set(i, new int[] {list.get(i)[0], list.get(i)[1], list.get(i)[2], list.get(i)[3], orgCount});
					}
				}

//				print();
			}
			
			int sum = 0;
			
			for(int i = 0; i < K; i++) {
				if(list.get(i)[0] != -1) {
					sum += list.get(i)[2];
				}
			}
			
			System.out.println("#" + tc + " " + sum);
		}
		// test case

	}

	

	static void print() {
		System.out.println("-----------------");
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}

	static boolean check(int r, int c) {
		return r >= 1 && r < N - 1 && c >= 1 && c < N - 1;
	}
}