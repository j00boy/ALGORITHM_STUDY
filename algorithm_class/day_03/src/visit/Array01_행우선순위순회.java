package visit;

import java.util.Arrays;

public class Array01_행우선순위순회 {
	// main -> ctrl + space bar
	public static void main(String[] args) {
		int[][] arr1;
		arr1 = new int[5][];
		
		String[][] arr2 = new String[5][];
		int a = 1;
		
//		1 2 3 4 5 
//		6 7 8 9 10
//		 
//		
//		. ..a..a 25
	
		
		// 1차원 반복문 만들어 보기 
		// [o][x] 
		for(int row=0; row<5; row++) {
			arr1[row] = new int[5]; // 요 틀은 외우는 것도 좋다!
			arr2[row] = new String[5]; // 요 틀은 외우는 것도 좋다!

			// 2차원 반복문 만들어 보기
			// [x][o]
			for(int col=0; col<5; col++) {
				arr1[row][col] = a++;
				arr2[row][col] = "→";
			}
		}
		
		for (int i=0; i<5; i++) {
			System.out.println(Arrays.toString(arr1[i]));
		}
		
		for (int i=0; i<5; i++) {
			System.out.println(Arrays.toString(arr2[i]));
		}
		
	}
}
