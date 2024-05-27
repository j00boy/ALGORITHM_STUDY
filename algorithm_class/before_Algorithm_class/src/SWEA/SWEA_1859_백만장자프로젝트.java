package SWEA;

import java.util.Scanner;

public class SWEA_1859_백만장자프로젝트 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 1; i <= T; i++) {
			int N = sc.nextInt();	// 2 <= N <= 1,000,000
			int[] arr = new int[N];	// N개의 숫자만큼 입력을 받아 넣을 그릇
			int totalSum = 0;		// 최대 이익의 합을 담는 그릇
			int maxPrice = 0;		// 각 경우마다 최대 가격
			
			// 입력값을 배열에 담기
			for(int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}
			
			for(int k = N-1; k >= 0; k--) {
				if(arr[k] > maxPrice) {
					maxPrice = arr[k];
				}
				totalSum += maxPrice-arr[k];
			}
			
			System.out.printf("#%d %d\n", i, totalSum);
		}
	}
}