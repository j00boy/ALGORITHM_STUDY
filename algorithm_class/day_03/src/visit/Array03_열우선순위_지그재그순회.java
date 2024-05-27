package visit;

import java.util.Arrays;

public class Array03_열우선순위_지그재그순회 {
	// main -> ctrl + space bar
	public static void main(String[] args) {
		
		int[][] arr1;
		arr1 = new int[5][5];
		
		String[][] arr2 = new String[5][5];
		
		int a = 1;
		
//		1 6
//		2 7
//		3 8 
//		4 9 
//		5 10 ..a..a 25
	
		
		// 2차원 반복문 만들어 보기 
		// [x][o] 
		for(int col=0; col<5; col++) {
			
			// 1차원 반복문 
			// [o][x] 
			// row값 변경  col의 값이 0> 짝수이면 은 
			if (col %2 == 0) {
				// 0 ~ 4
				for (int row=0; row<5; row++) {
					arr1[row][col] = a++;
					arr2[row][col] = "↓";
				}
			}
			// row값 변경  col의 값이 1 홀수이면은 
			else {
				// 4 ~0 
				for (int row=4; row>=0; row--) {
					arr1[row][col] = a++;
					arr2[row][col] = "↑";
				}
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
