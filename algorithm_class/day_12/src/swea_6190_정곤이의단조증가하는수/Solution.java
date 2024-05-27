package swea_6190_정곤이의단조증가하는수;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
//		File file = new File("src/swea_6190_정곤이의단조증가하는수/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case 시작
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			// 배열 생성 및 값 초기화
			int[] arr = new int[N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = Integer.MIN_VALUE;
			
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					
					if(arr[i] * arr[j] < 10 && arr[i] * arr[j] > max) {
						max = arr[i] * arr[j];
						continue;
					}
					
					int target = arr[i] * arr[j];
					while(target > 0 && target % 10 >= (target / 10) % 10) {
						
						target /= 10;
						if(target > 0 && target < 10) {
							if(arr[i] * arr[j] > max) {
								max = arr[i] * arr[j];
							}
						}
					}
				}
			}
			if(max < 0) {
				max = -1;
			}
			
			System.out.printf("#%d %d\n", tc, max);
			
			
		}
		// test case 끝
	}
}