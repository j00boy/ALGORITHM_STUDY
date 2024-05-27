package visit;

import java.util.Arrays;

public class Array02_열우선순위순회 {
	// main -> ctrl + space bar
	public static void main(String[] args) {
		int[][] arr1;
		arr1 = new int[5][5];
		
		String[][] arr2 = new String[5][5];
		
		int a = 1;
		
		// 열 우선순위 지그재그 순회
//		1 10 ..
//		2 9 
//		3 8 
//		4 7
//		5 6        25
		
		// 2차원 반복문 만들어 보기 
		// [x][o] 
		for(int col=0; col<5; col++) {
			
			// 1차원 반복문 만들어 보기
			// [o][x] 
			for(int row=0; row<5; row++) {
				arr1[row][col] = a++;
				arr2[row][col] = "↓";
			}
		}
		
		for(int n=0; n<5; n++) {
			System.out.println(Arrays.toString(arr1[n]));
		}
		
		for(int n=0; n<5; n++) {
			System.out.println(Arrays.toString(arr2[n]));
		}
		
		
		
	}
}
