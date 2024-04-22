package boj_20057_마법사상어와토네이도;

import java.util.Scanner;

public class Main {
	
	static int[] dr = {0, 1, 0, -1};	// 좌 하 우 상
	static int[] dc = {-1, 0, 1, 0};	// 좌 하 우 상
	
	static int N;			// N은 무조건 홀수
	static int[][] map;
	static int[] start;
	static int move;
	static int index;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		move = 0;
		index = 0;
		N = sc.nextInt();
		map = new int[N][N];
		start = new int[] {N/2, N/2};
		
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		// 이동하기
		while(move != N * N - 1) {
			
			
			
			move++;
		}
		
		
	}

	// 디버깅
	public static void print() {
		System.out.println("-------------------------------");
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
	}
	
	// 경계조건 체크 함수
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}