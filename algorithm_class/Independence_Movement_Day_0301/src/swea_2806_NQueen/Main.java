package swea_2806_NQueen;

import java.util.Scanner;

public class Main {

	static int N;
	static int[][] board;
	static boolean[] visitedRow;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

			count = 0;						// 전체 가짓 수 
			N = sc.nextInt();
			board = new int[N][N];			// N-QUEEN을 실행할 map
			visitedRow = new boolean[N];	// 전체 map에 대한 체크 -> 행만 따로 체크 시 방문체크가 어려워서 일단

			checkQueen(0);
            System.out.println(count);
	}

	// 재귀 함수 생성
	public static void checkQueen(int idx) {
		if (idx == N) {
			count++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if (visitedRow[idx]) {		// 만약 방문했던 곳이면 다음 싸이클로 이동 
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
				visitedRow[idx] = true; // 보드판에서 내가 자리 방문했으니까 check
				

				checkQueen(idx + 1); // 그 다음 줄 재귀

				board[idx][c] = 0; // 다시 0으로 바꿈
				visitedRow[idx] = false; // 안 간 척
			}

		}
	}
	
}
