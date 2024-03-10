/**
 * [GOLD 4]
 * [연구소]
 */

package boj_14502_연구소;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {

	static int N;
	static int M;
	static int[][] map;
	static int zeroMax = 0;
	static int wall = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 세로 길이
		M = sc.nextInt(); // 가로 길이
		map = new int[N][M]; // 맵 초기화

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		wallDFS(0, 0);
		
		System.out.println(zeroMax);

	}

	public static void BFSandGetMaxCount() {

		Queue<Integer> queue = new LinkedList<Integer>();
		// 현재 맵을 먼저 복사
		int[][] copiedMap = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				copiedMap[r][c] = map[r][c];

				// 바이러스 근원지가 여러 개이면, 동시다발적으로 퍼지기 때문에 먼저 queue에 삽입
				if (copiedMap[r][c] == 2) {
					queue.add(r);
					queue.add(c);
				}
			}
		}

		// 상 하 좌 우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int now_r = queue.poll();
			int now_c = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];

				// 경계조건 + 0인 지점으로만 바이러스가 퍼질 수 있음
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && copiedMap[nr][nc] == 0) {
					queue.add(nr);
					queue.add(nc);
					copiedMap[nr][nc] = 2;
				}
			}
		}

		// 0의 갯수를 체크
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (copiedMap[r][c] == 0) {
					cnt++;
				}
			}
		}

		// max값과 비교 & 크면 갱신
		if (zeroMax < cnt) {
			zeroMax = cnt;
		}
	}

	
	public static void wallDFS(int row, int col) {		// row, col은 탐색 시작점
		/*
		 * 기저 조건
		 * : 3만큼 벽을 세우면, 그때 BFS를 실시한다.
		 */
		if (wall == 0) {
			BFSandGetMaxCount();
			return;
		}
		
		// 재귀 조건
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					map[r][c] = 1;		// 1로 바꾸고
					wall--;				// 벽 카운트 --
					if (c + 1 < M) {	
						wallDFS(r, c + 1);
					} else {			// c+1이 경계조건 밖이면, 줄바꿈
						wallDFS(r + 1, 0);
					}
					map[r][c] = 0;		// 다시 벽 원래대로 돌리고 
					wall++;				// 벽 카운트 ++
				}
			}
		}

	}

}