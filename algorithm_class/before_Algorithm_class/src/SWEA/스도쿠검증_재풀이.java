package SWEA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 스도쿠검증_재풀이 {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("src/SWEA/input.txt");
		Scanner sc = new Scanner(file);
		
//		Scanner sc = new Scanner(System.in);
		
		// TEST CASE
		int T = sc.nextInt();
		
		// TEST CASE 시작
		for(int testCase = 1; testCase <= T; testCase++) {
			
			// flag 설정
			// boolean flag가 아닌 result = 1 or 0으로 해도 무방하긴 할텐데, flag가 보다 직관적인 것 같음
			
			// 1. 행 조건
			// 2. 열 조건
			// 3. 3*3 격자 조건
			boolean flag = true;
//			boolean flag2 = true;
//			boolean flag3 = true;
			
			// 스도쿠 생성
			int[][] map = new int[9][9];
			for(int r = 0; r < 9; r++) {
				for(int c = 0; c < 9; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			
			// 행 검사
			for(int r = 0; r < 9; r++) {
				
				// [r]번째 행의 값의 빈도 수를 넣은 빈도수 배열 생성
				int[] row = new int[10];	// counting 배열 생성
				for(int c = 0; c < 9; c++) {
					row[map[r][c]]++;
				}
				
				// 스도쿠 숫자: 1~9 한번씩이므로 i=1부터 끝까지 탐색
				for(int i = 1; i < row.length; i++) {
					if(row[i] != 1) {	// 1번 이상 나온 숫자 or 한 번도 안 나온 숫자가 있다면
						flag = false;	// 첫 번째 flag: false;
						break;			// 해당 for문 반복 종료 및 탈출
					}					// 이상 없으면 초기화값 그대로 true;
				}
			}
			
			// 열 검사 전 flag 확인
			// - 실패 시 그냥 break
			if(flag == false) {
				System.out.printf("#%d %d\n", testCase, 0);
				continue;		// 해당 반복 탈출 후 다음 반복 실행
			}
			
			// 열 검사
			// [c]번째 열의 값의 빈도수를 담을 1차원 배열 생성
			for(int c = 0; c < 9; c++) {
				int[] col = new int[10];
				for(int r = 0; r < 9; r++) {
					col[map[r][c]]++;
				}
				
				for(int i = 1; i < col.length; i++) {
					if(col[i] != 1) {
						flag = false;
						break;		// 해당 for문 반복 종료 및 탈출
					}
				}
			}
			
			
			// 3 by 3 검사 전 flag 확인
			// 두번째 조건이 false일 경우, 결과값 0 출력 후 다음 반복문 실행
			if(flag == false) {			
				System.out.printf("#%d %d\n", testCase, 0);
				continue;
			}	
			
			
			// 3 by 3 검사
			// 이게 어려웠음
			/*
			 * 1 2 3
			 * 4 5 6
			 * 7 8 9
			 * 
			 * 9개의 격자를 만들어야 하므로 r, c의 증감식은 +3씩
			 */
			// 열, 행 검사와 똑같이 빈도 수 배열 생성 및 값 초기화
			for(int r = 0; r < 9; r += 3) {	
				for(int c = 0; c < 9; c += 3) {
					int[] part = new int[10];
					for(int part_r = 0; part_r < 3; part_r++) {
						for(int part_c = 0; part_c < 3; part_c++) {
							part[map[part_r][part_c]]++;
						}
					}
					
					for(int i = 1; i < part.length; i++) {
						if(part[i] != 1) {
							flag = false;
							break;
						}
					}
				}
			}
			
			// 1, 2, 3번째 flag가 모두 true일 경우, <= 3가지로 나눴다면,3
			// 세번째 flag 검사
			if(!flag) {
				System.out.printf("#%d %d\n", testCase, 0);
				continue;
			} else {
				System.out.printf("#%d %d\n", testCase, 1);
			}
			
		}
		// TEST CASE 끝
		
	}

}
