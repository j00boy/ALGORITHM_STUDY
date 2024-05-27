package 순열구현;

import java.util.Arrays;

public class 순열_swap {
	
	static int[] nums;
	static int N;
	
	public static void main(String[] args) {
		nums = new int[] {2, 4, 6, 8};
		N = nums.length;
		
		perm(0);
	}

	public static void perm(int idx) {
		// 기저 조건
		if(idx == N) {
			System.out.println(Arrays.toString(nums));
		}
		
		// 재귀조건
		for(int i = idx; i < N; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(idx, i);
		}
	}
	
	// swap 함수
	public static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
