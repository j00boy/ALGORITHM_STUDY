package swea_1209_Sum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		
//		File file = new File("src/swea_1209_Sum/input.txt");
//		Scanner sc = new Scanner(file);
		
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			
			int N = sc.nextInt();
			
			int[][] arr = new int[100][100];
			
			for(int r = 0; r < 100; r++) {
				for(int c = 0; c < 100; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			
			// Row 합 중 최대값 구하기
			int max = Integer.MIN_VALUE;
			for(int r = 0; r < 100; r++) {
				int rowSum = 0;
				for(int c = 0; c < 100; c++) {
					rowSum += arr[r][c];
				}
				if(rowSum > max) {
					max = rowSum;
				}
			}
			
			
			// Column 합 중 최대값 구하기
			for(int c = 0; c < 100; c++) {
				int colSum = 0;
				for(int r = 0; r < 100; r++) {
					colSum += arr[r][c];
				}
				if(colSum > max) {
					max = colSum;
				}
			}
			
			
			// CrossLine 합 중 최대값 구하기
			int crossSum1 = 0;
			int crossSum2 = 0;
			for(int r = 0; r < 100; r++) {
				for(int c = 0; c < 100; c++) {
					if(c == r) crossSum1 += arr[r][c];
					if(c == 99-r) crossSum2 += arr[r][c];
				}
			}
			
			if(crossSum1 > max) {
				max = crossSum1;
			}
			if(crossSum2 > max) {
				max = crossSum2;
			}
			
			
			
			System.out.printf("#%d %d\n", test_case, max);
		}
	}
}