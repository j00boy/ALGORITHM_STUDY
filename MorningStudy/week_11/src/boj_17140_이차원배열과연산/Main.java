package boj_17140_이차원배열과연산;

import java.util.Scanner;

public class Main {

	static int[][] A;	// 원본 배열
	static int row;		// 목표 행 좌표
	static int col;		// 목표 열 좌표
	static int k;		// 목표 값
	static int[][] copied;	// 복사 배열

	static int R;		// 행 수
	static int C;		// 열 수
	static int max;		// 정렬 후 가장 긴 길이를 표
	static int min;		// 시간(minute)
	static boolean flag;	// while문 탈출을 위한 flag

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		R = 3;
		C = 3;

		row = sc.nextInt();
		col = sc.nextInt();
		k = sc.nextInt();

		A = new int[100][100];		// 100개 제외는 다 버리기 때문에 최대 크기 100
									// 동적으로 사이즈 조절하려다가 실패
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				A[r][c] = sc.nextInt();
			}
		}

		min = 0;
		flag = true;
		while (flag) {
			if (min > 100) {		// 100분 넘어가면 -1 출력
				min = -1;
				flag = false;
				break;
			}

			if (A[row - 1][col - 1] == k) {	// 목표 값에 다다르면 걸린 시간 출력
				flag = false;
				break;
			}

			if (R >= C) {			// 행이 더 길면 행 정렬
				cal_R();
			} else {				// 열이 더 길면 열 정렬
				cal_C();
			}
		}

		System.out.println(min);
	}

	// 행 연산
	public static void cal_R() {
		copied = new int[100][100];				// 복사 배열 생성
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				copied[r][c] = A[r][c];			// 깊은 복사
			}
		}

		max = 0;			
		A = new int[100][100];					// 정렬 후 값 초기화

		// 카운트 배열을 이용한 숫자 및 갯수 확인
		for (int r = 0; r < 100; r++) {
			int[] counts = new int[101];
			for (int c = 0; c < 100; c++) {
				counts[copied[r][c]]++;
			}

			int idx = 0;						// 찾으면 0부터 하나씩 값을 넣어줌
			int cnt = 1;						// 1. 갯수 오름차순
												// 	  - 숫자 오름차순
			while (cnt <= 100) {				// 1부터 100까지 다 비교함	(갯수가 1인것부터 탐색 후 발견하면 넣고, 2, 3, 4,....)
				for (int c = 1; c <= 100; c++) {
					if (counts[c] == cnt) {
						A[r][idx++] = c;
						A[r][idx++] = counts[c];
					} else {
						continue;
					}
				}
				cnt++;
			}
			max = Math.max(max, idx);
		}

		if (max > 100) {
			C = 100;
		} else {
			C = max;
		}
		min++;
	}

	// 열 연산
	public static void cal_C() {
		copied = new int[100][100];
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				copied[r][c] = A[r][c];
			}
		}

		max = 0;
		A = new int[100][100];
		for (int c = 0; c < 100; c++) {
			int[] counts = new int[101];
			for (int r = 0; r < 100; r++) {
				counts[copied[r][c]]++;
			}

			int idx = 0;
			int cnt = 1;
			while (cnt <= C) {
				for (int r = 1; r < 101; r++) {
					if (counts[r] == cnt) {
						A[idx++][c] = r;
						A[idx++][c] = counts[r];
					}
				}
				cnt++;
			}
			max = Math.max(max, idx);
		}

		if (max > 100) {
			R = 100;
		} else {
			R = max;
		}

		min++;
	}
}
