package boj_2447_별찍기10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new char[N][N];
		for(int r = 0; r < N; r++) {
			Arrays.fill(arr[r], '*');
		}
		
		printStar(0, 0, N);
		
		print();
		
		System.out.println(sb);
	}
	
	
	public static void printStar(int row, int col, int side) {
		// 기저 조건
		if(side < 3) {
			return;
		}
		
		// 실행 로직
		int newSide = side / 3;
		
		for(int r = row + newSide; r < row + newSide * 2; r++) {
			for(int c = col + newSide; c < col + newSide * 2; c++) {
				arr[r][c] = ' ';
			}
		}
		
		printStar(row, col, newSide);
		printStar(row, col + newSide, newSide);
		printStar(row, col + newSide * 2, newSide);
		printStar(row + newSide, col, newSide);
		printStar(row + newSide, col + newSide, newSide);
		printStar(row + newSide, col + newSide * 2, newSide);
		printStar(row + newSide * 2, col, newSide);
		printStar(row + newSide * 2, col + newSide, newSide);
		printStar(row + newSide * 2, col + newSide * 2, newSide);
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