package boj_1463_1로만들기;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] D;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		D = new int[N+1];
		
		D[1] = 0;
		
		/*
		 *  [바텀-업 방식]
		 *  - from 작은 부분 to 큰 부분
		 *  - 주로 반복문의 형태
		 *  - 재귀보다 더 안전한 방식
		 */
		
//		for(int i = 2; i < N+1; i++) {
//			D[i] = D[i-1] + 1;
//			
//			if(i % 2 == 0) {
//				D[i] = Math.min(D[i], D[i/2] + 1);
//			}
//			
//			if (i % 3 == 0) {
//				D[i] = Math.min(D[i], D[i/3] + 1);
//			}
//		}
		
		System.out.println(topDown(N));
	}
	
	/*
	 * [탑 다운 방식]
	 * - 위에서부터 문제를 파악해 내려오는 방식
	 * - 주로 재귀함수의 형태
	 * - 코드의 가독성이 좋고, 이해하기가 편하다는 특징
	 * - 하지만 시간 초과가 날 우려가 있음
	 */
	public static int topDown(int n) {
		// 기저조건
		if(n == 1) {
			return 0;
		}
		
		if(D[n] > 0) {
			return D[n];
		}
		
		// 재귀조건
		D[n] = topDown(n-1) + 1;
		
		if(n % 3 == 0) {
			D[n] = Math.min(D[n], topDown(n/3) + 1);
		}
		
		if(n % 2 == 0) {
			D[n] = Math.min(D[n], topDown(n/2) + 1);
		}
		
		return D[n];
				
	}
	
}
