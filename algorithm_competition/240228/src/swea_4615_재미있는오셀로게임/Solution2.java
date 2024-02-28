package swea_4615_재미있는오셀로게임;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

	static int N;
	static int[][] map;
	static int M;

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/swea_4615_재미있는오셀로게임/sample_input.txt");
		Scanner sc = new Scanner(file);

		int T = sc.nextInt();

		// 상 하 좌 우 좌상 좌하 우상 우하
		int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
		int[] dc = { 0, 0, -1, 1, -1, -1, 1, 1 };

		// test case
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			map = new int[N][N];

			// 초기값 생성
			// map[c][r]이라고 생각하면 편함
			if (N == 4) {
				map[1][1] = 2;
				map[2][1] = 1;
				map[1][2] = 1;
				map[2][2] = 2;
			} else if (N == 6) {
				map[2][2] = 2;
				map[3][2] = 1;
				map[2][3] = 1;
				map[3][3] = 2;
			} else {
				map[3][3] = 2;
				map[4][3] = 1;
				map[3][4] = 1;
				map[4][4] = 2;
			}

			for (int i = 0; i < M; i++) {
				int col = sc.nextInt() - 1;
				int row = sc.nextInt() - 1;
				int t = sc.nextInt();

				map[row][col] = t;

				int nr = row;
				int nc = col;
				// 흑돌일 때
				if(t == 1) {
					for (int d = 0; d < 8; d++) {
						// 범위 안에 있을 때만 한 번 움직여 본다.
						if(nr + dr[d] >= 0 && nr + dr[d] < N && nc + dc[d] >= 0 && nc + dc[d] < N) {
							nr += dr[d];
							nc += dc[d];
							
							// 그 다음값이 2일 때만 탐색 시작
							if(map[nr][nc] == 2) {
								int count = 1;
								nr += dr[d];
								nc += dc[d];
								while(nr >= 0 && nr < N && nc >= 0 && nc < N) {
									if(map[nr][nc] == 2) {
										nr += dr[d];
										nc += dc[d];
										count++;
									} else if(map[nr][nc] == 0) {
										break;
									} else {
										while(count-- > 0) {
											nr -= dr[d];
											nc -= dc[d];
										}
									}
								}
							} else {
								break;
							}
						} else {
							break;
						}
						
					}
				}
 
			}
			
		for(int r= 0; r < N; r++) {
			for(int c= 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
			
		}
		// test case

	}

}
