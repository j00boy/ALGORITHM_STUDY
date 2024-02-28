package swea_4014_활주로건설;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/swea_4014_활주로건설/sample_input.txt");
		Scanner sc = new Scanner(file);

		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= 1; tc++) {
			int N = sc.nextInt();	// 변의 길이, 정사각형
			int X = sc.nextInt();	// 경사로의 길이, 높이는 1
			
			int[][] map = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
//			// 상 하 좌 우
//			int[] dr = {-1, 1, 0, 0};
//			int[] dc = {0, 0, -1, 1};
			
			int count = 0;
			for(int r = 0; r < N; r++) {
				int[] arr = new int[N];
				
				for(int c = 0; c < N; c++) {
					arr[c] = map[r][c];
				}
				
				// lft > rgt
				boolean isLeftOK = true;
				for(int i = 0; i < N-1; i++) {
					if(arr[i] > arr[i+1]) {
						if(i + 1 + X > N-1) {
							isLeftOK = false;
							break;
						}
						for(int j = i+1; j < i+1+X; j++) {
							if(arr[j] != arr[i+1]) {
								isLeftOK = false;
								break;
							}
						}
					}
				}
				
				// lft < rgt
				boolean isRightOK = true;
				for(int i = N-1; i >= 1; i--) {
					if(arr[i] > arr[i-1]) {
						if(i - 1 - X < 0) {
							isRightOK = false;
							break;
						}
						for(int j = i-1; j >= i-1-X; j--) {
							if(arr[j] != arr[i-1]) {
								isRightOK = false;
								break;
							}
						}
					}
				}
			}
			
			System.out.println(count);
		}
		// test case
	}

}
