package boj_1806_부분합;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int S;
	static int[] arr;
	static int leng;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		leng = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] >= S) {
				leng = 1;
			}
		}
		
		if(leng != 0) {
			System.out.println(leng);
			return;
		}

		// 누적합
		int sum = 0;
		
		int[] sumArr = new int[N+1];
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			sumArr[i + 1] = sum;
		}
		
		System.out.println(Arrays.toString(sumArr));
		
		if(sum < S) {
			System.out.println(0);
			return;
		}
		
		// 누적합과 관련된 실연산, 투포인터 ?
		leng = 100000;
		int left = 0;
		int right = arr.length;
		
		while(left < right) {
			
		}
		
	}
}
