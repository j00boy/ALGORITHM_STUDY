package boj_14890_경사로;

import java.util.Scanner;

public class Main2 {
	
	static int N;
	static int L;
	static int[][] map;
	static int road;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		road = 0;	// 갈 수 있는 길을 담을 배열
		N = sc.nextInt();
		L = sc.nextInt();	// 경사로의 길이
		map = new int[N][N];

		// 맵 입력받기
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		// 행 검사
		for(int r = 0; r < N; r++) {
			int idx = 0;
			int hgt = map[r][0];
			int count = 1;
			boolean canGo = true;
			
			while(idx < N) {
				if(map[r][idx] == hgt) {
					count++;
					idx++;
				} else if(Math.abs(map[r][idx] - hgt) > 1) {
					canGo = false;
					break;
				} else if((map[r][idx] - hgt) == 1) {	// 지금 나온게 더 클 때
					if(count > L) {
						hgt = map[r][idx];
						count = 1;
						idx++;
					} else {
						canGo = false;
						break;
					}
				} else if((map[r][idx] - hgt) == -1) {
					if(check(r, idx+L)) {
						boolean flag = true;
						for(int i = idx; i < idx+L; i++) {
							if(map[r][i] != map[r][idx]) {
								flag = false;
								break;
							}
						}
						if(!flag) {
							canGo = false;
							break;
						}
						hgt = map[r][idx];
						count = 0;
						idx += L;
					} else {
						canGo = false;
						break;
					}
				}
			}
			
			if(canGo) road++;
		}
		
		
		// 열 검사
		for(int c = 0; c < N; c++) {
			int idx = 0;
			int hgt = map[0][c];
			int count = 1;
			boolean canGo = true;
			
			while(idx < N) {
				if(map[idx][c] == hgt) {
					count++;
					idx++;
				} else if(Math.abs(map[idx][c] - hgt) > 1) {
					canGo = false;
					break;
				} else if((map[idx][c] - hgt) == 1) {	// 지금 나온게 더 클 때
					if(count > L) {
						hgt = map[idx][c];
						count = 1;
						idx++;
					} else {
						canGo = false;
						break;
					}
				} else if((map[idx][c] - hgt) == -1) {
					if(check(idx + L, c)) {
						boolean flag = true;
						for(int i = idx; i < idx+L; i++) {
							if(map[i][c] != map[idx][c]) {
								flag = false;
								break;
							}
						}
						if(!flag) {
							canGo = false;
							break;
						}
						hgt = map[idx][c];
						count = 0;
						idx += L;
					} else {
						canGo = false;
						break;
					}
				}
			}
			
			if(canGo) road++;
		}
				
		System.out.println(road);
		
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	
}