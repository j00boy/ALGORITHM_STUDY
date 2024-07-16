package boj_14925_목장건설하기;

import java.util.Scanner;

public class Main {
	
	static int M;
	static int N;
	static int[][] map;
	static int max;
	
	static int[][] D;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[M][N];
		D = new int[M][N];
		max = 0;
		
		for(int r = 0; r < M; r++) {
			for(int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		for(int r = 0; r < M; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == 1) {
					D[r][c] = 0;
				} else if(map[r][c] == 2) {
					D[r][c] = 0;
				} else {
					/*
					 *  양변이 0일때는 D[r-1][c] or D[r][c-1]이랑 비교를 할 수가 없고,
					 *  내 기준은 정사각형이 만들어지는 가장 오른쪽 꼭짓점이 기준이기 때문에
					 *  해당 변에서는 무조건 1이 최고 길이임
					 */
					if(r == 0) D[r][c] = 1;
					else if(c == 0) D[r][c] = 1;
					else {
						D[r][c] = Math.min(Math.min(D[r-1][c], D[r][c-1]) + 1, D[r-1][c-1] + 1);
					}
					max = Math.max(max, D[r][c]);
				}
			}
		}
		
//		print(D);
		System.out.println(max);
	}
	
	public static void print(int[][] arr) {
		for(int r = 0; r < arr.length; r++) {
			for(int c = 0; c < arr[0].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
	}
}
