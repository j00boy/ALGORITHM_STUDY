package boj_17140_이차원배열과연산;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
//	static ArrayList<ArrayList<Integer>> A = new ArrayList<>();
	static int[][] A;
	static int row;
	static int col;
	static int k;
	static int[][] copied;
	
	static int R;
	static int C;
	static int max;
	static int min;
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = 3;
		C = 3;
				
		row = sc.nextInt();
		col = sc.nextInt();
		k = sc.nextInt();
		
		copied = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				copied[r][c] = sc.nextInt();
			}
		}
		
		min = 0;
		flag = true;
		while(flag) {
//			System.out.println();
			if(min > 100) {
				min = -1;
				flag = false;
				break;
			}
			
			if(copied[row-1][col-1] == k) {
				flag = false;
				break;
			}
			
			if(R >= C) {
				cal_R();
//				for(int r = 0; r < R; r++) {
//					for(int c = 0; c < C; c++) {
//						System.out.print(copied[r][c] + " ");
//					}
//					System.out.println();
//				}
			} else {
				cal_C();
//				for(int r = 0; r < R; r++) {
//					for(int c = 0; c < C; c++) {
//						System.out.print(copied[r][c] + " ");
//					}
//					System.out.println();
//				}
			}
		}
		
		System.out.println(min);
	}
	
	// 행 연산
	public static void cal_R() {
		A = new int[R][C];
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				A[r][c] = copied[r][c];
			}
		}
				
		max = 0;
		copied = new int[R][C * 2];

		for(int r = 0; r < R; r++) {
			int[] counts = new int[C + 1];
			for(int c = 0; c < C; c++) {
				counts[A[r][c]]++;
			}
			
			int idx = 0;
			for(int c = 1; c < C+1; c++) {
				if(counts[c] != 0) {
					copied[r][idx++] = c;
					copied[r][idx++] = counts[c];
				}
			}
			max = Math.max(max, idx);
		}
		
		if(max > 100) {
			C = 100;
		} else {
			C = max;
		}
		
		min++;
	}
	
	// 열 연산
	public static void cal_C() {
		A = new int[R][C];
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				A[r][c] = copied[r][c];
			}
		}

		
		max = 0;
		copied = new int[R * 2][C];
		for(int c = 0; c < C; c++) {
			int[] counts = new int[R + 1];
			for(int r = 0; r < R; r++) {
				counts[A[r][c]]++;
			}
			
			int idx = 0;
			for(int r = 1; r < R+1; r++) {
				if(counts[r] != 0) {
					copied[idx++][c] = r;
					copied[idx++][c] = counts[r];
				}
			}
			max = Math.max(max, idx);
		}
		
		if(max > 100) {
			R = 100;
		} else {
			R = max;
		}
		
		min++;
	}
}
