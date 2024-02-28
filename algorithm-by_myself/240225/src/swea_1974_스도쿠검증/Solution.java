package swea_1974_스도쿠검증;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			
			int[][] sudoku = new int[9][9];	
			
			for(int r = 0; r < 9; r++) {
				for(int c = 0; c < 9; c++) {
					sudoku[r][c] = sc.nextInt();
				}
			}
			
			boolean flag = true;

			// 행 검사
			for(int r = 0; r < 9; r++) {
				int[] row = new int[10];
				for(int c = 0; c < 9; c++) {
					row[sudoku[r][c]] = 1;
				}
				
				for(int c = 1; c < 10; c++) {
					if(row[c] != 1) {
						flag = false;
						break;
					}
				}
				
				if (flag == false) {
			        break;
				}
			}
			
			if(flag == false) {
				System.out.printf("#%d %d\n", tc, 0);
				continue;
			}
			
			// 열 검사
			for(int c = 0; c < 9; c++) {
				int[] col = new int[10];
				for(int r = 0; r < 9; r++) {
					col[sudoku[r][c]] = 1;
				}
				
				for(int r = 1; r < 10; r++) {
					if(col[r] != 1) {
						flag = false;
						break;
					}
				}
				
				if (flag == false) {
			        break;
				}
			}
			
			if(flag == false) {
				System.out.printf("#%d %d\n", tc, 0);
				continue;
			}
 			
			// 3 by 3 검사
			for(int r = 0; r < 9; r += 3) {
				for(int c = 0; c < 9; c += 3) {
					
					int[] by33 = new int[10];
					
					for(int i = 0; i < 3; i++) {
						for(int j = 0; j < 3; j++) {
							by33[sudoku[r+i][c+j]] = 1;
						}
					}
					
					for(int j = 1; j < 10; j++) {
						if(by33[j] != 1) {
							flag = false;
							break;
						}
					}
					if (flag == false) {
				        break;
					}
				}
				if (flag == false) {
			        break;
				}
			}
			
			if(flag == true) {
				System.out.printf("#%d %d\n", tc, 1);
			} else {
				System.out.printf("#%d %d\n", tc, 0);
			}
			
		}
		// test case
	}

}
