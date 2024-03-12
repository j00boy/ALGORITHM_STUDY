/**
 * n개의 정수로 이루어진 임의의 수열
 * 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합
 * - 몇개의 수 : 1 이상
 * 이게 최장증가부분수열인가?
 */

package boj_1912_연속합;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] arr;
	static int[] D;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();				// 1 <= N <= 100,000
		arr = new int[N];
		D = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();		// -1,000 <= arr[i] <= 1,000
		}

		/*
		 * D[i] = 맨끝부터 현재자리까지의 숫자의 합
		 * 만약에 D[i+1]의 값이 음수면, 굳이 더할 필요가 없기 때문에 D[i] = arr[i]
		 */
		
		int max = Integer.MIN_VALUE;
		
		for(int i = N-1; i >= 0; i--) {
			if(i == N-1) {
				D[i] = arr[i];
			} else {
				if(D[i+1] < 0) {			// 0보다 작으면
					D[i] = arr[i];			// D[i]는 내 자신
				} else {
					D[i] = D[i+1] + arr[i];	// 아니면 ++
				}
			}
			if(max < D[i]) {				// max값 갱신
				max = D[i];
			}
		}
		
		System.out.println(max);
		
	}
}