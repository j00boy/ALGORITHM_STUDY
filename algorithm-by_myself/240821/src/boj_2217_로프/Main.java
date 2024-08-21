package boj_2217_로프;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
//		System.out.println(Arrays.toString(arr));
		
		int count = 0;
		int max = -1;
		for(int i = N - 1; i >= 0; i--) {
			int rope = arr[i];
			count++;
			if(rope * count > max) {
				max = rope * count;
			}
		}
		
		System.out.println(max);
	}
}
