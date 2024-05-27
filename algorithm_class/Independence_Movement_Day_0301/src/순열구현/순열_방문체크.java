package 순열구현;

import java.util.Arrays;

public class 순열_방문체크 {

	static int[] nums;
	static int N;
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) {
		nums = new int[] { 2, 4, 6, 8 };
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];
		
		perm(0);

	}

	public static void perm(int idx) {
		// 기저 조건
		if (idx == N) {
			System.out.println(Arrays.toString(result));
		}

		// 재귀 조건
		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			
			result[idx] = nums[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}

}
