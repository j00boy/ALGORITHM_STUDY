package boj_1744_수묶기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static long[] arr;
	static boolean[] selected;
	
	static long max = Long.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new long[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
		}
		
		Arrays.sort(arr);
		
		while(true) {
			
		}
	}
}
