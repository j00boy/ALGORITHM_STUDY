package BOJ_1780_종이의개수;

import java.util.Scanner;

public class Main {

	static int[][] paper;	// 첫 종이
	
	// 같은 숫자일 경우 종이의 개수: -1, 0, 1
	static int minusOne = 0;
	static int zero = 0;
	static int plusOne = 0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		paper = new int[N][N];
		
		// 숫자 입력
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				paper[r][c] = sc.nextInt();
			}
		}
		
		cutPaper(paper, 0, 0, N);
		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(plusOne);
		
	}

	// 종이 1개에 대한 check
	// 행에 대한 시작점 r = 0
	// 열에 대한 시작점 c = 0
	public static boolean checkIsSame(int r, int c, int N) {
		for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (paper[r][c] != paper[i][j]) {	// 같은 숫자가 아니라면 false;
					return false;
				}
			}
		}
		return true;	// 전부 같으면 true;
	}

	// 행에 대한 시작점 r = 0
	// 열에 대한 시작점 c = 0
	public static void cutPaper(int[][] arr, int r, int c, int N) {
		if (checkIsSame(r, c, N)) {		// 숫자가 같다면 어떤 종이의 숫자를 올릴지 선택
			if (arr[r][c] == -1) {
				minusOne++;
			} else if (arr[r][c] == 0) {
				zero++;
			} else if (arr[r][c] == 1) {
				plusOne++;
			}
			return;						// 함수 종료
			
		} else {	// 숫자들이 같지 않다면, 각 변을 3등분으로 나눠 종이를 9개 만듬
			int side = N / 3;			// 종이의 변을 3으로 나눔

			for (int i = r; i < r + N; i += side) {		// new_N만큼 증감식
				for (int j = c; j < c + N; j += side) {	// new_N만큼 증감식
					cutPaper(arr, i, j, side);					// 9개로 나눈 종이에 대해 cutPaper() 메서드를 실행
				}											// 1 by 1인 종이가 되면 checkisSame() 함수에서 종료됨
			}
		}
	}

}