package boj_17281_야구;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static boolean[] map;	// 주루 플레이트
	static int inning; // 이닝 수
	static int[] twins; // 팀
	static int[][] score;
	static boolean[] number;
	static int maxScore;
	static int index;	// 공격 순서

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		map = new boolean[3];
		twins = new int[9];
		number = new boolean[9];
		number[3] = true;		// 4번 타자 자리 끝
		twins[3] = 0;			// 4번 타자는 1번 선수
		inning = sc.nextInt();
		score = new int[inning][9];
		maxScore = 0;

		for (int r = 0; r < inning; r++) {
			for (int c = 0; c < 9; c++) {
				score[r][c] = sc.nextInt();
			}
		}

		// 0번 index 선수는 이미 골라짐
		permutation(1);

		System.out.println(maxScore);

	}

	// 타순을 구하는 함수
	public static void permutation(int idx) {
		if (idx >= 9) {
//			System.out.println(Arrays.toString(twins));
			index = 0;
			playBall();
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (number[i]) {	// 3번 index 알아서 넘김
				continue;
			}

			number[i] = true;	// 4번 타자를 제외한 자리를 점하고
			twins[i] = idx;		// 그 자리에 idx 선수를 넣음
			permutation(idx + 1);	// idx+1번 선수 자리 구함
			number[i] = false;		// 재귀 후 다시 안 고른 척
		}
	}

	public static void playBall() {
		int sum = 0;

		for (int r = 0; r < inning; r++) {
			map = new boolean[3];
			int outCnt = 0;

			// 3아웃이면 이닝 끝
			while (outCnt < 3) {
				if (score[r][twins[index]] == 0) {
					outCnt++;
					index = (index + 1) % 9;
					continue;
				} else if (score[r][twins[index]] == 1) {
					if (map[2]) {
						map[2] = false;
						sum += 1;
					}
					for (int i = 1; i >= 0; i--) {
						if (map[i]) {
							map[i] = false;
							map[i + 1] = true;
						}
					}
					map[0] = true;
					index = (index + 1) % 9;
					continue;
				} else if (score[r][twins[index]] == 2) {
					for (int i = 2; i >= 1; i--) {
						if (map[i]) {
							map[2] = false;
							sum += 1;
						}
					}
					map[1] = true;
					if (map[0]) {
						map[0] = false;
						map[2] = true;
					}
					index = (index + 1) % 9;
					continue;
				} else if (score[r][twins[index]] == 3) {
					for (int i = 0; i < 3; i++) {
						if (map[i]) {
							map[i] = false;
							sum += 1;
						}
					}
					map[2] = true;
					index = (index + 1) % 9;
					continue;
				} else {
					for (int i = 0; i < 3; i++) {
						if (map[i]) {
							map[i] = false;
							sum += 1;
						}
					}
					sum += 1;
					index = (index + 1) % 9;
					continue;
				}
			}
		}

		maxScore = Math.max(sum, maxScore);
	}
}
