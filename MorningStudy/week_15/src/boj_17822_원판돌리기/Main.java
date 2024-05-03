package boj_17822_원판돌리기;

import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int N;	// 반지름
	static int M;	// M개의 정수
	static int T;	// 총 회전 수
	static int[][] map;
	static int[] info;
	static int total;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		total = 0;
		
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		map = new int[N + 1][M];
		info = new int[3];	// info[0]: x, info[1]: d, info[2]: k
		
		for(int r = 1; r <= N; r++) {
			for(int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		// 총 T번 회전 + 그 안에서 돌아가는 메서드
		// - 일단 해당 회차 먼저 다 돌리고
		// - 그 다음에 인접한 것들 삭제
		for(int i = 0; i < T; i++) {
			info[0] = sc.nextInt();
			info[1] = sc.nextInt();	// info[1]: 0 = 시계 방향, info[1]: 1 = 반시계 방향
			info[2] = sc.nextInt();
			
			if(info[1] == 0) {	// 시계 방향 회전
				for(int r = 1; r <= N; r++) {	// 모든걸 돌면서
					if(r % info[0] == 0) {	// 배수일 때만
						int num = map[r][M-1];
						for(int c = 1; c < M; c++) {
							map[r][c] = map[r][c - 1];
						}
						map[r][0] = num;
					}
				}
				
				// 숫자 제거 로직
				double sum = 0;
				double numCnt = 0;
				double avg = 0;
				int cnt = 0;
				for(int r = 1; r <= N; r++) {	// 모든걸 돌면서
					if(r % info[0] == 0) {	// 배수일 때만
						for(int c = 0; c < N; c++) {
							if(map[r][c] != 0) {
								sum += map[r][c];
								numCnt++;
								
								int count = 0;
								for(int d = 0; d < 4; d++) {
									int nr = r + dr[d];
									int nc = c + dc[d];
									
									if(check(nr, nc) && map[nr][nc] == map[r][c]) {
										map[nr][nc] = 0;
										cnt++;
										count++;
									}
								}
								
								if(count > 0) {
									map[r][c] = 0;
								}
							}
						}
					}
				}
				
				if(cnt == 0) {
					avg = sum / numCnt;
					
					for(int r = 1; r <= N; r++) {
						for(int c = 0; c < M; c++) {
							if(map[r][c] != 0) {
								if(map[r][c] > avg) {
									map[r][c]--;
								} else if(map[r][c] < avg){
									map[r][c]++;
								}
							}
						}
					}
				}
				
			} else {			// 반시계 방향 회전
				for(int r = 1; r <= N; r++) {	// 모든걸 돌면서
					if(r % info[0] == 0) {	// 배수일 때만
						int num = map[r][0];
						for(int c = 0; c < M - 1; c++) {
							map[r][c] = map[r][c + 1];
						}
						map[r][M-1] = num;
					}
				}
				
				// 숫자 제거 로직
				double sum = 0;
				double numCnt = 0;
				double avg = 0;
				int cnt = 0;
				for(int r = 1; r <= N; r++) {	// 모든걸 돌면서
					if(r % info[0] == 0) {	// 배수일 때만
						for(int c = 0; c < N; c++) {
							if(map[r][c] != 0) {
								sum += map[r][c];
								numCnt++;
								
								int count = 0;
								for(int d = 0; d < 4; d++) {
									int nr = r + dr[d];
									int nc = c + dc[d];
									
									if(check(nr, nc) && map[nr][nc] == map[r][c]) {
										map[nr][nc] = 0;
										cnt++;
										count++;
									}
								}
								
								if(count > 0) {
									map[r][c] = 0;
								}
							}
						}
					}
				}
				
				if(cnt == 0) {
					avg = sum / numCnt;
					
					for(int r = 1; r <= N; r++) {
						for(int c = 0; c < M; c++) {
							if(map[r][c] != 0) {
								if(map[r][c] > avg) {
									map[r][c]--;
								} else if(map[r][c] < avg){
									map[r][c]++;
								}
							}
						}
					}
				}
			}
		}
		
		for(int r = 1; r <= N; r++) {
			for(int c = 0; c < M; c++) {
				total += map[r][c];
			}
		}
		
		System.out.println(total);
	
	}
	
	static boolean check(int r, int c) {
		return r >= 1 && r < N+1 && c >= 0 && c < M;
	}
}