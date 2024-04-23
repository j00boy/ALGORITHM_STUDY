package boj_20057_마법사상어와토네이도;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {0, 1, 0, -1};	// 좌 하 우 상
	static int[] dc = {-1, 0, 1, 0};	// 좌 하 우 상
	
	static int[] xr = {-1, -1, 1, 1};	// 진행 방향 기준: 좌상 우상 좌하 우하
	static int[] xc = {-1, 1, -1, 1};	// 진행 방향 기준: 좌상 우상 좌하 우하
	
	static List<Integer> list;
	static int index;
	static int N;			// N은 무조건 홀수
	static int[][] map;
	static int nowR;
	static int nowC;
	static int move;
	static int trash;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		list = new ArrayList<>();
		trash = 0;
		move = 0;
		N = sc.nextInt();
		map = new int[N][N];
		nowR = N / 2;
		nowC = N / 2;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		// 처음꺼만 먼저 이동하기
		nowR += dr[0];
		nowC += dc[0];
		
		if(check(nowR, nowC)) {
			
		}
		
		// 이동하기
		int d = 0;
		while(move != N * N - 1) {
			
			
			
			move++;
		}
		
		
	}
	
	// 모래 흩뿌리기
	public static void sandStorm(int r, int c, int direction, int sand) {
		
		list = new ArrayList<>();
		index = 0;
		
		for(int d = 0; d < 4; d++) { 
			int dir = (direction + d + 1) % 4;
			int nr = r;
			int nc = c;
			
			switch(d) {
				case 0: case 2:
					for(int i = 0; i < 2; i++) {
						nr += dr[dir];
						nc += dc[dir];
						
						if(i == 0) {
							list.add(map[r][c] * 7 / 100);
							index++;
							if(check(nr, nc)) {
								map[nr][nc] += list.get(index);
							} else {
								trash += list.get(index);
							}
						} else {
							list.add(map[r][c] * 2 / 100);
							index++;
							if(check(nr, nc)) {
								map[nr][nc] += list.get(index);
							} else {
								trash += list.get(index);
							}
						}
					}
					break;
				case 1: break;
				default:
					for(int i = 0; i < 2; i++) {
						nr += dr[dir];
						nc += dc[dir];
						
						if(i == 0) {
							list.add(map[r][c] * 7 / 100);
							index++;
							if(check(nr, nc)) {
								map[nr][nc] += list.get(index);
							} else {
								trash += list.get(index);
							}
						} else {
							list.add(map[r][c] * 2 / 100);
							index++;
							if(check(nr, nc)) {
								map[nr][nc] += list.get(index);
							} else {
								trash += list.get(index);
							}
						}
					}
					break;
			}
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			switch(d) {
				case 0: case 1:
//					r += 
			}
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