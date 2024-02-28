package swea_4613_러시아국기같은깃발;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
//		File file = new File("src/swea_4613_러시아국기같은깃발/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			char[][] flag = new char[N][M];
			
			// 국기 만들기
			for(int r = 0; r < N; r++) {
				String str = sc.next();
				for(int c = 0; c < M; c++) {
					flag[r][c] = str.charAt(c);
				}
			}

			int minCount = Integer.MAX_VALUE;
			// white
			int totalCount = 0;
			int whiteCount = 0;
			for(int w = 0; w < N-2; w++) {
				for(int c = 0; c < M; c++) {
					if(flag[w][c] != 'W') {
						whiteCount++;
					}
				}
				// blue
				int blueCount = 0;
				for(int bu = w+1; bu < N - 1; bu++) {
					for(int c = 0; c < M; c++) {
						if(flag[bu][c] != 'B') {
							blueCount++;
						}
					}
					// red
					int redCount = 0;
					for(int r = bu + 1; r < N; r++) {
						for(int c = 0; c < M; c++) {
							if(flag[r][c] != 'R') {
								redCount++;
							}
						}
					}
					totalCount = whiteCount + blueCount + redCount;
					
					if(totalCount < minCount) {
						minCount = totalCount;
					}
				}
			}
			
//			for(int bu = 1; bu < N-1; bu++) {
//				int total = 0;
//				// white
//				int whiteCount = 0;
//				for(int w = 0; w < bu-1; w++) {
//					for(int c = 0; c < M; c++) {
//						if(flag[w][c] != 'W') {
//							whiteCount++;
//						}
//					}
//					// blue
//					int blueCount = 0;
//					for(int bl = bu; bl < N-1; bl++) {
//						for(int c = 0; c < M; c++) {
//							if(flag[bl][c] != 'B') {
//								blueCount++;
//							}
//						}
//						
//						// red
//						int redCount = 0;
//						for(int r = bl + 1; r < N; r++) {
//							for(int c = 0; c < M; c++) {
//								if(flag[r][c] != 'R') {
//									redCount++;
//								}
//							}
//						}
//						total = whiteCount + blueCount + whiteCount;
//						if(minCount > total) {
//							minCount = total;
//						}
//					}
//				}
//				
//			}
			
			System.out.printf("#%d %d\n", tc, minCount);
			
		}
		// test case
	}
}
