package swea_2001_파리퇴치;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		
//		File file = new File("src/swea_2001_파리퇴치/input.txt");
//		Scanner sc = new Scanner(file);
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case 시작
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();	// 배열의 크기
			int[][] flies = new int[N][N];	// 파리 배열
			
			int M = sc.nextInt();	// 파리채 변 크기
			int max_kill = 0;		// 파리를 죽일 수 있는 최대값 
			
			
			for(int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					flies[r][c] = sc.nextInt();
				}
			}
			
			for(int r = 0; r < N-M+1; r++) {		// N의 파리구역에서 M이 파리채 크기일 때 (N-M+1)^2만큼 경우의 수가 생김
				for(int c = 0; c < N-M+1; c++) {
					int kill = 0;					// arr[r][c]를 기준으로 파리채 크기가 M일 때 죽일 수 있는 파리의 수
					for(int a = r; a < M+r; a++) {
						for(int b = c; b < M+c; b++) {
							kill += flies[a][b];	// 배열을 순회하며 누적
						}
					}
					if(kill > max_kill) {			// 최대값보다 크면
						max_kill = kill;			// max_kill 갱신
					}
				}
			}
			
			System.out.printf("#%d %d\n", test_case, max_kill);
			
		}
		// test case 끝
		
	}
}