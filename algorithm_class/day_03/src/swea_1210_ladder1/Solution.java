package swea_1210_ladder1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {

//		File file = new File("src/swea_1210_ladder1/input.txt");
//		Scanner sc = new Scanner(file);
		
		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int test_case = 1; test_case <= 10; test_case++) {

			int N = sc.nextInt();

			int[][] map = new int[100][100];

			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			int start = 0;

			// 2에 해당하는 start 구하기
			for (int i = 0; i < 100; i++) {
				if (map[99][i] == 2) {
					start = i;
				}
			}

			int[] dc = { -1, 1 }; // 좌 우

			for (int r = 98; r >= 0; r--) { // 아래에서 위로
				if(r == 0) {
					break;
				}
				
				for (int d = 0; d < 2; d++) {
					if (start + dc[d] >= 0 && start + dc[d] < 100) {
						int nc = start + dc[d];

						if (map[r][nc] == 1) { // 좌우 탐색에서 1을 만나면
							// &&: 앞에서 조건이 틀려버리면, 뒤에 조건은 연산하지 않음
							// map[r][nc+dc[d] == 1이 앞에 온다면, nc+dc[d]의 크기 연산보다 작은 연산이므로 IndexOut이 나온다.
							// 같이 쓸거면 맨 뒤로,
							// 아니면 nc + dc[d] 범위 안에 또 if문을 넣어 주면 좋을 것 같다.
							while (nc + dc[d] >= 0 && nc + dc[d] < 100 && map[r][nc+dc[d]] == 1) { // nc가 1일 때까지
								
								nc += dc[d]; // 계속 직진
							}
							start = nc;
							break;
						}
					}
				}
			}

			System.out.printf("#%d %d\n", test_case, start);

		}

	}
}