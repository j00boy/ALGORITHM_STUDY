package swea_2806_NQueen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int count;

	public static void main(String[] args) throws FileNotFoundException {
		// Scanner sc = new Scanner(new File("src/swea_2806_NQueen/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {

			count = 0;						// 전체 가짓 수 
			N = sc.nextInt();
			board = new int[N][N];			// N-QUEEN을 실행할 map
			visited = new boolean[N][N];	// 전체 map에 대한 체크 -> 행만 따로 체크 시 방문체크가 어려워서 일단

			checkQueen(0);
			
			System.out.printf("#%d %d\n", tc, count);

//            System.out.println(count);


		}
		// test case
	}

	// 재귀 함수 생성
	public static void checkQueen(int idx) {
		if (idx == N) {
//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < N; c++) {
//					System.out.print(board[r][c] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			count++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if (visited[idx][c]) {		// 만약 방문했던 곳이면 다음 싸이클로 이동 
				continue;
			}

			// 방문했던 곳이 아니면 
			
			// 좌상 상 우상
			int[] dr = { -1, -1, -1 };	
			int[] dc = { -1, 0, 1 };

			// 3방향 중 하나도 퀸이 놓인 자리가 없을 때를 체크하기 위한 flag
			boolean isValid = true;
			for (int d = 0; d < 3; d++) {
				int nr = idx + dr[d];
				int nc = c + dc[d];

				while (nr >= 0 && nr < N && nc >= 0 && nc < N && isValid) {		// 경계 조건
					if (board[nr][nc] != 1) {		// 1이 아니면 계속 탐색 
						nr += dr[d];
						nc += dc[d];
					} else {						// 1이 나오면 해당 방향은 끝 => 해당 자리는 불가능
						isValid = false;
						break;
					}
				}
				
				// for문 종료
				if(!isValid) {
					break;
				}
			}

			// 그 자리가 유효한 자리라면,
			if (isValid) {
				board[idx][c] = 1;		// 퀸 배치
				visited[idx][c] = true; // 보드판에서 내가 자리 방문했으니까 check
				

				checkQueen(idx + 1); // 그 다음 줄 재귀

				board[idx][c] = 0; // 다시 0으로 바꿈
				visited[idx][c] = false; // 안 간 척
			}

		}
	}
	
}
