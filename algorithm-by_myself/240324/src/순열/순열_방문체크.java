package 순열;

import java.util.Arrays;

public class 순열_방문체크 {
	
	static int[] arr;
	static int N;
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) {
		arr = new int[] {1, 2, 3, 4};
		N = arr.length;
		visited = new boolean[N];
		result = new int[N];
		
		permutation(0);
	}
	
	public static void permutation(int idx) {
		if(idx >= N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) {
				continue;
			}
			
			result[idx] = arr[i];
			visited[i] = true;
			permutation(idx + 1);
			visited[i] = false;
		}
		
	}
}
