package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1974_스도쿠검증 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) { // Test Case의 시작

			// 스도쿠 배열 생성
			int[][] arr = new int[9][9];

			// 스도쿠 배열 입력받기
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			boolean flag = true;
			
			// 가로 확인
			for(int r = 0; r < 9; r++) {
				int[] row = new int[10];
				for(int c = 0; c < 9; c++) {
					row[arr[r][c]] = 1;
					}
				
				for(int k = 1; k < row.length; k++) {
					if(row[k] != 1) {
						flag = false;
						break;
					}
				}
			}
			
			if(flag == false) {
				System.out.printf("#%d %d\n", i, 0);
				continue;
			}
			
			// 세로 확인
			for(int c = 0; c < 9; c++) {
				int[] col = new int[10];
				for(int r = 0; r < 9; r++) {
					col[arr[r][c]] = 1;
				}
				
				for(int k = 1; k < col.length; k++) {
					if(col[k] != 1) {
						flag = false;
						break;
					}
				}
			}
			
			if(flag == false) {
				System.out.printf("#%d %d\n", i, 0);
				continue;
			}
			
			// 3*3 배열 확인
			for(int r = 0; r < 9; r += 3) {
				for(int c= 0; c < 9; c += 3) {
					int[] part = new int[10];
					for(int n1 = 0; n1 < 3; n1++) {
						for(int n2 = 0; n2 < 3; n2++) {
							part[arr[r+n1][c+n2]] = 1;
						}
					}
					
					for(int k = 1; k < part.length; k++) {
						if(part[k] != 1) {
							flag = false;
							break;
						}
					}
				}
			}
			
			if(flag == true) {
				System.out.printf("#%d %d\n", i, 1);
			} else {
			System.out.printf("#%d %d\n", i, 0);
			}

		} // Test Case의 끝

	}
}