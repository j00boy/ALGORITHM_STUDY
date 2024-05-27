// 이해가 되지 않는다.

package 순열구현;

import java.util.Arrays;

public class 순열_비트마스킹 {
	
	static int[] nums;
	static int N;
	static int[] result;
	
	public static void main(String[] args) {
		nums = new int[] {2, 4, 6, 8};
		N = nums.length;
		result = new int[N];
		
		perm(0, 0);
	}
	
	public static void perm(int idx, int visited) {
		// 기저 조건
		if(idx == N) {
			System.out.println(Arrays.toString(result));
		}
		
		for(int i = 0; i < N; i++) {
			if((visited & (nums[1] << nums[i])) != 0) {
				continue;
			}
			
			result[idx] = nums[i];
			perm(idx + 1, visited | (nums[1] << nums[i]));
		}
	}

}
