package boj_2467_용액;

import java.util.Scanner;

public class Main {

	static int N;
	static long[] arr;
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new long[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
		}

		long first = 0;
		long second = 0;

		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			long tmp = arr[left] + arr[right];
//			System.out.println(tmp + " " + min);
			
			if(Math.abs(tmp) <= min) {
				min = Math.abs(tmp);
				first = arr[left];
				second = arr[right];
			}
			
			if(tmp > 0) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(first + " " + second);
	}
}
