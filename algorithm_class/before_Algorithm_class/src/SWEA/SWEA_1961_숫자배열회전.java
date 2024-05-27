package SWEA;

import java.util.Scanner;

public class SWEA_1961_숫자배열회전 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int x = 0; x < arr.length; x++) {
				for(int y = 0; y < arr[x].length; y++) {
					arr[x][y] = sc.nextInt();
				}
			}
			
			int[][] arr90 = new int[N][N];
			int[][] arr180 = new int[N][N];
			int[][] arr270 = new int[N][N];

			// 1. 90도 회전
			/*
			 * [0,0] [0,1] [0,2] [0,3]
			 * [1,0] [1,1] [1,2] [1,3]
			 * [2,0] [2,1] [2,2] [2,3]
			 * [3,0] [3,1] [3,2] [3,3]
			 * 
			 * x -> y
			 * y -> (N-1)-x
			 */
			for(int x = 0; x < arr.length; x++) {
				for(int y = 0; y < arr[x].length; y++) {
					arr90[y][N-1-x] = arr[x][y];
				} 
			}
			
			// 2. 180도 회전
			for(int x = 0; x < arr90.length; x++) {
				for(int y = 0; y < arr90.length; y++) {
					arr180[y][N-1-x] = arr90[x][y];
				}
			}
			
			// 3. 270도 회전
			for(int x = 0; x < arr180.length; x++) {
				for(int y = 0; y < arr180.length; y++) {
					arr270[y][N-1-x] = arr180[x][y];
				}
			}
			
			// 출력만 제대로 하면 된다.
			/*
			 * 여기서부터 메소드를 입력하시오.
			 */
			System.out.printf("#%d\n", i);
			for(int j = 0; j < N; j++) {
				int[] ans = new int[N];
				
				for(int k = 0; k < N; k++) {
					ans[k] = arr90[j][k];
					System.out.print(ans[k]);
				}
				
				System.out.print(" ");
				
				for(int k = 0; k < N; k++) {
					ans[k] = arr180[j][k];
					System.out.print(ans[k]);
				}
				
				System.out.print(" ");
				
				for(int k = 0; k < N; k++) {
					ans[k] = arr270[j][k];
					System.out.print(ans[k]);
				}
				System.out.println();
			}
			
		}
	}
 
}
