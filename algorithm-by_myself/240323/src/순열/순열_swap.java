package 순열;

import java.util.Arrays;
import java.util.Scanner;

public class 순열_swap {
	
	static int[] nums;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N];
		for(int i = 1; i <= N; i++) {
			nums[i-1] = i;
		}
		
		permutation(0);
		
	}
	
	public static void permutation(int idx) {
		if(idx >= N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for(int i = idx; i < N; i++) {
			swap(i, idx);
			permutation(idx + 1);
			swap(i, idx);
		}
	}
	
	public static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
