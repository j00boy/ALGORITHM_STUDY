package SWEA_1954_달팽이숫자;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt();
		
		// test case 입력
		for(int i = 1; i <= T; i++) {
			// N 입력
			int N = sc.nextInt(); 
			int[][] arr = new int[N][N];
			int[] dx = {0, 1, 0, -1};	// 우 하 좌 상
			int[] dy = {1, 0, -1, 0};	// 우 하 좌 상
			
			// 만약, 다음에 넣을 값이 0이 아니라면, 방향 바꾸기
			int x = 0;		// 현재 x좌표
			int y = 0;		// 현재 y좌표
			int d = 0;		// 방향 index
			
			for(int n = 1; n <= N*N; n++) {
				// n은 1부터 1씩 커지면서 차례대로 배열에 넣는다.
				arr[x][y] = n;
				/*
				 * <index>
				 * x+dx[d], y+dy[d]가 N보다 크거나
				 * x+dx[d], y+dy[d]가 0보다 작거나
				 * 
				 * <value>
				 * 배열의 위치에 이미 값이 들어가 있다면,
				 */
				if(x+dx[d] >= N || x+dx[d] < 0 || y+dy[d] >= N || y+dy[d] < 0 || arr[x+dx[d]][y+dy[d]] != 0) {
					// d에 1을 더한다.
					d += 1;
					// d가 3보다 커지면 dx[d], dy[d]의 범위가 벗어나기 때문에 4로 나누어 줌
					d %= 4;
				}
				// 방향 전환
				x += dx[d];	
				y += dy[d];
			}			
			
			System.out.printf("#%d\n", i);
			for(x = 0; x < N; x++) {
				for(y = 0; y < N; y++) {
					System.out.print(arr[x][y] + " ");
				}
				System.out.println();
			}
		}	// test case 종료
		
	}

}