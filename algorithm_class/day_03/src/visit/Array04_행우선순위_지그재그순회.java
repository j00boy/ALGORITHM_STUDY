package visit;

import java.util.Arrays;

public class Array04_행우선순위_지그재그순회 {
	// main -> ctrl + space bar
	public static void main(String[] args) {
		
		int[][] arr1;
		arr1 = new int[5][];
		
		String[][] arr2 = new String[5][];
		
		int a = 1;
		
//		1 2 3 4 5
//		10 9 8 7 6 
//		
//		
//		         25
	
		
		// 1차원 반복문 만들어 보기 
		// [o][x] 
		for(int row=0; row<5; row++) {
			arr1[row] = new int[5];
			arr2[row] = new String[5];
			
			// 2차원 반복문 
			// [x][o] 
			// col값 변경  row의 값이 0> 짝수이면 은 
			if (row %2 == 0) {
				// 0 ~ 4
				for (int col=0; col<5; col++) {
					arr1[row][col] = a++;
					arr2[row][col] = "→";
				}
			}
			// col값 변경  row의 값이 1 홀수이면은 
			else {
				// 4 ~0 
				for (int col=4; col>=0; col--) {
					arr1[row][col] = a++;
					arr2[row][col] = "←";
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
