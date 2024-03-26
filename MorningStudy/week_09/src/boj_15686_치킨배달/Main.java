package boj_15686_치킨배달;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[][] town;
	static int count = 0;
	static int minDist = Integer.MAX_VALUE;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> houses = new ArrayList<>();
	static int[][] closed;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();		// 한 변
		M = sc.nextInt();		// 마을에 남겨야 하는 치킨집 갯수
		town = new int[N+1][N+1];
		
		// 마을 입력
		// 현재 치킨집 갯수
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				
				town[r][c] = sc.nextInt();
				
				if(town[r][c] == 2) {
					list.add(new int[] {r, c});	// 치킨집 위치 저장
					count++;			// 치킨집 갯수 
				} else if(town[r][c] == 1) {
					houses.add(new int[] {r, c});	// 치킨집 위치 저장
				}
			}
		}
		
		
		closed = new int[count - M][2];	// 폐업시킬 치킨집 저장
		
		closedDown(0, 0);
		
		System.out.println(minDist);
		
	}
	
	public static void closedDown(int idx, int sidx) {
		if(sidx >= count - M) {
			// 치킨집 문 닫기
			for(int i = 0; i < count - M; i++) {
				town[closed[i][0]][closed[i][1]] = 0;
			}

			// 여기서 치킨 최소 거리를 구함
			int sum = 0;
			for(int[] arr : houses) {
				sum += getDistance(arr[0], arr[1], 0);
			}
			
			// 다시 열기
			for(int i = 0; i < count - M; i++) {
				town[closed[i][0]][closed[i][1]] = 2;
			}
						
			minDist = Math.min(minDist, sum);			
			
			return;
		}
		
		if(idx >= count) {
			return;
		}
		
		closed[sidx][0] = list.get(idx)[0];
		closed[sidx][1] = list.get(idx)[1];
		
		closedDown(idx + 1, sidx + 1);
		closedDown(idx + 1, sidx);
		
	}
	
	public static int getDistance(int r, int c, int depth) {
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		boolean[][] visited = new boolean[N+1][N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(r);
		queue.add(c);
		queue.add(0);
		visited[r][c] = true;
		int dist = 0;
		
		boolean flag = true;
		while(!queue.isEmpty()) {
			depth++;
			int now_r = queue.poll();
			int now_c = queue.poll();
			int now_depth = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];
				
				if(check(nr, nc) && !visited[nr][nc]) {
					if(town[nr][nc] == 2) {
						dist = now_depth + 1;
						flag = false;
						break;
					}
					queue.add(nr);
					queue.add(nc);
					queue.add(now_depth + 1);
					visited[nr][nc] = true;
				}
			}
			
			if(!flag) {
				break;
			}
		}
		
		return dist;
	}
	
	static boolean check(int r, int c) {
		return r >= 1 && r <= N && c >= 1 && c <= N;
	}
	
	public static int getInstance(int r, int c) {
		int min = Integer.MAX_VALUE;

		for(int[] arr : houses) {
			int dist = Math.abs(r - arr[0]) + Math.abs(c - arr[1]);
			min = Math.min(min, dist);
		}
		
		return min;
	}
}