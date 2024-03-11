/**
 * n개의 정수로 이루어진 임의의 수열
 * 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합
 * - 몇개의 수 : 1 이상
 * 이게 최장증가부분수열인가?
 */

package boj_1912_연속합;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();				// 1 <= N <= 100,000
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();		// -1,000 <= arr[i] <= 1,000
		}

		
	}
}