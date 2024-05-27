package swea_4012_요리사;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int[][] synergy;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_4012_요리사/input.txt"));
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			synergy = new int[N][N];
			int minGap = 20000;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					synergy[i][j] = sc.nextInt();
				}
			}
			
			
			
		}
		// test case
	}
}
