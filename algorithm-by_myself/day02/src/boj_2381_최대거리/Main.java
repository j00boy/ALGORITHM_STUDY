package boj_2381_최대거리;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] nums = new int[2][N];
		
		for(int i = 0; i < N; i++) {
			nums[0][i] = sc.nextInt();
			nums[1][i] = sc.nextInt();
		}
		
		int max_dist = Integer.MIN_VALUE;
		for(int i = 0; i < N-1; i++) {
			int standard_x = nums[0][i];
			int standard_y = nums[1][i];
			for(int j = i+1; j < N; j++) {
				int dist = Math.abs(standard_x - nums[0][j]) + Math.abs(standard_y - nums[1][j]);
				
				if(dist > max_dist) {
					max_dist = dist;
				}
			}
		}
		
		System.out.println(max_dist);
		
	}
}
