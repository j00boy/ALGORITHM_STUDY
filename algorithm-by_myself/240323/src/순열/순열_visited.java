package 순열;

import java.util.Arrays;
import java.util.Scanner;

public class 순열_visited {
	
	static int[] nums;
	static int N;
	static int M;
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N];
		result = new int[N];
		visited = new boolean[N];
		for(int i = 1; i <= N; i++) {
			nums[i-1] = i;
		}
		
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
			
			result[idx] = nums[i];
			visited[i] = true;		
			permutation(idx + 1);
			visited[i] = false;
		}
	}
	
}
