package boj_2847_게임을만든동준이;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int count = 0;
		
		if(N == 1) {
			count = 0;
		} else {
			for(int i = N - 1; i >= 1; i--) {
				if(arr[i-1] >= arr[i]) {
					count += arr[i-1] - arr[i] + 1;
					arr[i-1] = arr[i] - 1;
				}
			}
		}
		
		System.out.println(count);
	}
}
