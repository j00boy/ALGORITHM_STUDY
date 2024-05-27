package swea_2805_농작물수확하기;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {

//		File file = new File("src/swea_2805_농작물수확하기/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// tc 시작
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// 밭의 크기
			sc.nextLine();
			
			int[][] farm = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				String str = sc.nextLine();
				for(int c = 0; c < N; c++) {
					farm[r][c] = Character.getNumericValue(str.charAt(c));
				}
			}
			
			
			int mid = N / 2;
			int profit = 0;
			int d = 0;
			
			for(int r = 0; r < N; r++) {
				for(int c = mid-d; c <= mid+d; c++) {
					profit += farm[r][c];
				}
				if(r >= mid) {
					d--;
				} else {
					d++;
				}
			}
			
			
			System.out.printf("#%d %d\n", tc, profit);
		}
		// tc 끝
	}

}
