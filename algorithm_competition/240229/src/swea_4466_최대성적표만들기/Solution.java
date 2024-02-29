package swea_4466_최대성적표만들기;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File("src/swea_4466_최대성적표만들기/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[] scores = new int[N];
			
			for(int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
			}
			
			Arrays.sort(scores);
			
			int sum = 0;
			for(int i = scores.length - 1; i >= scores.length - K; i--) {
				sum += scores[i];
			}
			
			
			System.out.printf("#%d %d\n", tc, sum);
		}
		// test case
	}

}
