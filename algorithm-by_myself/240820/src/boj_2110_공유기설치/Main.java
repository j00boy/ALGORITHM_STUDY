package boj_2110_공유기설치;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;	 // 집의 개수
	static int C;	// 공유기의 개수
	static int[] home;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		C = sc.nextInt();
		
		home = new int[N];
		
		for(int i = 0; i < N; i++) {
			home[i] = sc.nextInt();
		}
		
		Arrays.sort(home);
		
//		System.out.println(Arrays.toString(home));
		int left = 1;	// 공유기 설치 최소거리: 1
		int right = home[N-1];	// 공유기 설치 최대거리: home[N-1]
		int answer = -1;
		// 1 2 4 8 9
		
		// 이분 탐색
		while(left <= right) {
			int count = 1;	// 시작점은 항상 설치한다고 가정
			int mid = (left + right) / 2;
//			System.out.println(mid);
			int now = home[0];	// 시작점은 항상 설치한다고 가정
			
			for(int i = 1; i < N; i++) {
				if(home[i] - now >= mid) {	// 현재 집 <-> 직전에 설치한 집까지의 거리가 공유기 설치 가능 최대거리보다 작거나 같다면
					count++;	// 공유기 설치 count++
					now = home[i];	// 직전에 설치한 집 = home[i]
				}
			}
			
//			System.out.println("mid: " + mid + ", count: " + count);
//			System.out.println("left: " + left + ", right: " + right);
			
			if(count >= C) {	
				left = mid + 1;
			} else {
				right = mid - 1;	// count가 최대 가능 공유기 대수보다 크다면, 최대거리를 줄임
			}
		}
		
		System.out.println(left - 1);
		
	}

}
