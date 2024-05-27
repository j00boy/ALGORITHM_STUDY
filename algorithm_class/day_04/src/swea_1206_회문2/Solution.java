package swea_1206_회문2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {

//		File file = new File("src/swea_1206_회문2/input.txt");
//		Scanner sc = new Scanner(file);

		Scanner sc = new Scanner(System.in);
		int T = 10;

		// test case
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();

			char[][] chars = new char[100][100];

			for (int i = 0; i < 100; i++) {
				String str = sc.next();
				char[] list = str.toCharArray();
				for (int j = 0; j < 100; j++) {
					chars[i][j] = list[j];
				}
			}

			// 여기서부터 코드 구현

			// 행 검사
			int row_max = 0;

			for (int r = 0; r < 100; r++) {
				char[] row_line = new char[100]; // 행 하나를 담을 1차원 배열 생성
				for (int c = 0; c < 100; c++) {
					row_line[c] = chars[r][c];
				}

				int max_len_by_One = 0;

				// 한 싸이클
				for (int c = 0; c < 100; c++) {
					int row_len = 0;
					for (int l = 100; l >= 2; l--) {
						StringBuffer sb = new StringBuffer();
						if (c + l - 1 < 100) {
							for (int i = c; i <= c + l - 1; i++) {
								sb.append(row_line[i]);
							}
						}
						// 회문 조건 확인
						if (sb.toString().equals(sb.reverse().toString())) {
							row_len = sb.length();
							if (row_len > max_len_by_One) {
								max_len_by_One = row_len;
							}
						}
					}
				}

				if (max_len_by_One > row_max) {
					row_max = max_len_by_One;
				}

			}
			// 행 검사 종료

			// 열 검사
			int col_max = 0;

			for (int c = 0; c < 100; c++) {
				char[] col_line = new char[100]; // 행 하나를 담을 1차원 배열 생성
				for (int r = 0; r < 100; r++) {
					col_line[r] = chars[r][c];
				}

				int max_len_by_One = 0;

				// 한 싸이클
				for (int r = 0; r < 100; r++) {
					int col_len = 0;
					for (int l = 100; l >= 2; l--) {
						StringBuffer sb = new StringBuffer();
						if (r + l - 1 < 100) {
							for (int i = r; i <= r + l - 1; i++) {
								sb.append(col_line[i]);
							}
						}
						// 회문 조건 확인
						if (sb.toString().equals(sb.reverse().toString())) {
							col_len = sb.length();
							if (col_len > max_len_by_One) {
								max_len_by_One = col_len;
							}
						}
					}
				}

				if (max_len_by_One > col_max) {
					col_max = max_len_by_One;
				}

			}
			// 행 검사 종료
			

			System.out.printf("#%d %d\n", test_case, Math.max(row_max, col_max));

		}
		// test case
	}
}