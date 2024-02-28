package SWEA_1979_어디에단어가들어갈수있을까;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) { // TEST CASE START
			
			int N = sc.nextInt(); // 맵의 크기
			int[][] arr = new int[N][N];
			int K = sc.nextInt(); // 문자의 길이

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			int sum = 0; // 문자가 들어갈 수 있는 방법의 수


			// row에서 찾기
//			for (int r = 0; r < N; r++) {
//				String str = "";
//				for (int c = 0; c < N; c++) {
//					str += arr[r][c];
//				}
//				
//				if (K + 1 <= N) {
//					if (str.contains("1".repeat(K)) && !str.contains("1".repeat(K + 1))) {
//						cnt++;
//					}
//				}
				
//				String strRow = "";
//				for(int n = 1; n <= K; n++) {
//					strRow += 1;
//				}
//				
//				while(str.contains(strRow))
//					if(str.contains(strRow) && !str.contains(strRow+1)) {
//						cnt++;
//						str = str.replaceFirst(strRow, "");
//						continue;
//					} else {
//						break;
//					}
//			}
//			
//			// column에서 찾기
//			for (int c = 0; c < N; c++) {
//				String str = "";
//				for (int r = 0; r < N; r++) {
//					str += arr[r][c];
//				}
//				// repeat 안먹음 ;
////				if (K + 1 <= N) {
////					if (str.contains("1".repeat(K)) && !str.contains("1".repeat(K + 1))) {
////						cnt++;
////					}
////				}
//				
//				String strCol = "";
//				for(int n = 1; n <= K; n++) {
//					strCol += 1;
//				}
//				while(str.contains(strCol))
//						if(str.contains(strCol) && !str.contains(strCol+1)) {
//							cnt++;
//							// 밑에 문장이 문제다.
//							str = str.replaceFirst(strCol, "");
//							continue;
//						} else {
//							break;
//						}
//			}
//			
//			System.out.printf("#%d %d\n", i, cnt);
			
			for(int r = 0; r < N; r++) {
				int cnt = 0;
				for(int c = 0; c < N; c++) {
					if(arr[r][c] == 1) {
						cnt++;
					} else {
						if(cnt == K) {
							sum++;
						}
						cnt = 0;
					}
				}
				
				if(cnt == K) {
					sum++;
				}
			}
			
			for(int c = 0; c < N; c++) {
				int cnt = 0;
				for(int r = 0; r < N; r++) {
					if(arr[r][c] == 1) {
						cnt++;
					} else {
						if(cnt == K) {
							sum++;
						}
						cnt = 0;
					}
				}
				
				if(cnt == K) {
					sum++;
				}
			}
			
			System.out.printf("#%d %d\n", i, sum);
		} // TEST CASE END
		
	}

}