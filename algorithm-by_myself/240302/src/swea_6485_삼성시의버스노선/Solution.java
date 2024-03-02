package swea_6485_삼성시의버스노선;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("src/swea_6485_삼성시의버스노선/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] way = new int[N][5001];

			for (int i = 0; i < N; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				for(int j = A; j <= B; j++) {
					way[i][j] = 1;
				}
			}
			
			int P = sc.nextInt();
			String ans = "";
			for (int i = 0; i < P; i++) {
				int C = sc.nextInt();
				
				int count = 0;
				for(int j = 0; j < N; j++) {
					if(way[j][C] == 1) {
						count++;
					}
				}
				
				ans += count + " ";
			}

			System.out.printf("#%d %s\n", tc, ans);

		}
		// test case
	}
}
