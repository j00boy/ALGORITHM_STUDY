package boj_2447_별찍기10;

import java.util.Scanner;

public class Main2 {
	
	static int N;
	static char[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new char[N][N];
		
		printStar(0, 0, N);
		
		print();
		
		System.out.println(sb);
	}
	
	
	public static void printStar(int row, int col, int side) {
		// 기저 조건
		if(side == 1) {
			return;
		}
		
		// 실행 로직
		int newSide = side / 3;
		
		// 맨위
		for(int r = row; r < row + newSide; r++) {
			for(int c = col; c < col + side; c++) {
				arr[r][c] = '*';
			}
		}
		
		// 중간 - 1
		for(int r = row + newSide; r < row + newSide * 2; r++) {
			for(int c = col; c < col + newSide; c++) {
				arr[r][c] = '*';
			}
		}
		
		
		// 중간 - 2
		for(int r = row + newSide; r < row + newSide * 2; r++) {
			for(int c = col + newSide; c < col + newSide * 2; c++) {
				arr[r][c] = ' ';
			}
		}
		
		
		// 중간 - 3
		for(int r = row + newSide; r < row + newSide * 2; r++) {
			for(int c = col + newSide * 2; c < col + side; c++) {
				arr[r][c] = '*';
			}
		}
		
		// 맨 아래
		for(int r = row + newSide * 2; r < row + side; r++) {
			for(int c = col; c < col + side; c++) {
				arr[r][c] = '*';
			}
		}
		
		// 재귀 조건
		for(int r = row; r < side; r += newSide) {
			for(int c = col; c < side; c+= newSide) {
				printStar(r, c, newSide);
			}
		}
		
	}
	
	public static void print() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				sb.append(arr[r][c] + " ");
			}
			sb.append("\n");
		}
	}
	
}