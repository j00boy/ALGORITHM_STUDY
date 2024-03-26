package boj_15686_치킨배달;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	
	static int N;
	static int M;
	static int[][] town;
	static int count = 0;
	static int minDist = Integer.MAX_VALUE;
	static List<int[]> chickens = new ArrayList<>();
	static List<int[]> houses = new ArrayList<>();
	static int[][] open;
	
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
					chickens.add(new int[] {r, c});	// 치킨집 위치 저장
					count++;			// 치킨집 갯수 
				} else if(town[r][c] == 1) {
					houses.add(new int[] {r, c});	// 집 위치 저장
				}
			}
		}
		
		
		open = new int[M][2];		// 남은 치킨집 위치만 저장할 배열
		
		closedDown(0, 0);			// 폐업 진행
		
		System.out.println(minDist);	// 최소 거리 결과
		
	}
	
	// 폐업시키기 (조합)
	public static void closedDown(int idx, int sidx) {
		if(sidx >= M) {		// 이때 멈춤
			// 여기서 치킨 최소 거리를 구함
			int sum = 0;
			for(int[] arr : houses) {
				sum += getDistance(arr[0], arr[1], open);
			}
			
			minDist = Math.min(minDist, sum);
			
			return;
		}
		
		if(idx >= count) {
			return;
		}
		
		open[sidx][0] = chickens.get(idx)[0];	// 치킨집 r 값
		open[sidx][1] = chickens.get(idx)[1];	// 치킨집 c 값
		
		closedDown(idx + 1, sidx + 1);
		closedDown(idx + 1, sidx);
		
	}
	
	// 거리 구하기 method
	public static int getDistance(int r, int c, int[][] arr) {
		int min = Integer.MAX_VALUE;

		for(int[] i : arr) {		// 여기서 들어갈 arr은 폐업시키고 남은 치킨집 위치 배열
			int dist = Math.abs(r - i[0]) + Math.abs(c - i[1]);		// 거리 구하기
			min = Math.min(min, dist);								// 최소 거리의 치킨집만 나의 치킨집이다.
		}
		
		return min;
	}
}