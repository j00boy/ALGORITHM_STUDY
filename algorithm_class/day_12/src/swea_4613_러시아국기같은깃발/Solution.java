package swea_4613_러시아국기같은깃발;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/swea_4613_러시아국기같은깃발/input.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();    // 행의 개수
            int M = sc.nextInt();    // 열의 개수

            char[][] flag = new char[N][M];

            // 2차원 배열 완성
            for (int r = 0; r < N; r++) {
                String str = sc.next();
                for (int c = 0; c < M; c++) {
                    flag[r][c] = str.charAt(c);
                }
            }

            int min = Integer.MAX_VALUE;

            // 파랑색 시작경계 탐색
            for (int b_upper = 1; b_upper < N - 1; b_upper++) {
                int total_change = 0;

                // 흰색 탐색
                int white_by_1 = 0;
                for (int w = 0; w < b_upper; w++) {
                    for (int c = 0; c < M; c++) {
                        if (flag[w][c] != 'W') {
                            white_by_1++;
                        }
                    }
                }

                // 파랑 탐색
                int blue_by_1 = 0;
                for (int b = b_upper; b < N - 1; b++) {
                    for (int c = 0; c < M; c++) {
                        if (flag[b][c] != 'B') {
                            blue_by_1++;
                        }
                    }

                    // 빨강 탐색
                    int red_by_1 = 0;
                    for (int r = b + 1; r < N; r++) {
                        for (int c = 0; c < M; c++) {
                            if (flag[r][c] != 'R') {
                                red_by_1++;
                            }
                        }
                    }

                    total_change = white_by_1 + blue_by_1 + red_by_1;
                    min = Math.min(min, total_change);
                }
            }

            // 전체 탐색 종료
            System.out.printf("#%d %d\n", tc, min);

        }
        // test case 끝
	}
}