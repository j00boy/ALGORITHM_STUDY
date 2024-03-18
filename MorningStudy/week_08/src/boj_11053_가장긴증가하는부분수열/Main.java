package boj_11053_가장긴증가하는부분수열;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] arr;
	static int[][] D;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 수열의 길이
		arr = new int[N];	// 수열 
		D = new int[N+1][N+1];	// 시작점(기준점)까지 증가하는 최대 길이를 담을 배열
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int r = 1; r < N; r++) {
			for(int c = 1; c < N; c++) {
				
			}
		}
	}
}