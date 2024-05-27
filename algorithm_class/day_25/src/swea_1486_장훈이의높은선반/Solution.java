package swea_1486_장훈이의높은선반;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// 점원 수
			int B = sc.nextInt();	// 최소 허용 높이
			int S = 0;
			
			int[] clerk = new int[N+1];
			
			for(int i = 1; i <= N; i++) {
				clerk[i] = sc.nextInt();
				S += clerk[i];
			}
			
			int[][] D = new int[N+1][S+1];
			
			int min = Integer.MAX_VALUE;
			
			for(int r = 1; r < N+1; r++) {
				for(int c = 0; c <= S; c++) {
					if(clerk[r] <= c) {
						D[r][c] = Math.max(D[r-1][c], D[r-1][c-clerk[r]] + clerk[r]);
					} else {
						D[r][c] = D[r-1][c];
					}
					if(D[r][c] >= B && D[r][c] < min) {
						min = D[r][c];
					}
				}
			}
			System.out.printf("#%d %d\n", tc, (min - B));
		}
	}
}