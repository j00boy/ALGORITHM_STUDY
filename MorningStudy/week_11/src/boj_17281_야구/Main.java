package boj_17281_야구;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static boolean[] map;
	static int inning; // 이닝 수
	static int[] twins; // 팀
	static int[][] score;
	static boolean[] number;
	static int maxScore;
	static int outCnt;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		map = new boolean[3];
		twins = new int[9];
		number = new boolean[9];
		number[0] = true;
		twins[3] = 0;
		inning = sc.nextInt();
		score = new int[inning + 1][9];
		maxScore = 0;

		// 이닝도 1부터, 타순도 1부터
		for (int r = 1; r <= inning; r++) {
			for (int c = 0; c < 9; c++) {
				score[r][c] = sc.nextInt();
			}
		}
		
		// 이닝만큼 경기가 진행된다.
		permutation(0);
		
		System.out.println(maxScore);

	}

	// 타순을 구하는 함수
	public static void permutation(int idx) {
		if (idx >= 9) {
			// 여기서 타순으로 점수를 계산해줘야 함
			System.out.println(Arrays.toString(twins));
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (number[i]) {
				continue;
			}
			
			if(idx == 3) {
				permutation(idx + 1);
			} else {
				number[i] = true;
				twins[idx] = i;
				permutation(idx + 1);
				number[i] = false;
			}
		}
	}
	
	public static void getScore(int inn, int idx, int out, int sum) {
		if(inn >= inning && out >= 3) {
			maxScore = Math.max(sum, maxScore);
			return;
		}
		
		if(out >= 3) {
			getScore(inn + 1, idx + 1, 0, sum);
		}
		
		if(score[inn][twins[idx]] == 0) {
			out++;
			getScore(inn, (idx + 1) % 9, out + 1, sum);
		} else if(score[inn][twins[idx]] == 1) {
			if(map[3]) {
				map[3] = false;
				sum += 1;
			}
			for(int i = 2; i >= 0; i--) {
				if(map[i]) {
					map[i] = false;
					map[i+1] = true;
				}
			}
			
			getScore(inn, (idx + 1) % 9, out, sum);
			
		} else if(score[inn][twins[idx]] == 2) {
			if(map[3]) {
				map[3] = false;
				sum += 1;
			}
			
			if(map[2]) {
				map[2] = false;
				sum += 1;
			}
			
			for(int i = 1; i >= 0; i--) {
				if(map[i]) {
					map[i] = false;
					map[i+2] = true;
				}
			}
			
			getScore(inn, (idx + 1) % 9, out, sum);
			
		} else if(score[inn][twins[idx]] == 3) {
			
			if(map[0]) {
				map[0] = false;
				map[3] = true;
				sum += 1;
			}
			
			for(int i = 1; i <= 3; i++) {
				if(map[i]) {
					map[i] = false;
					sum += 1;
				}
			}
			
			getScore(inn, (idx + 1) % 9, out, sum);
			
		} else {
			for(int i = 0; i < 4; i++) {
				if(map[i]) {
					map[i] = false;
					sum += 1;
				}
			}
			
			getScore(inn, (idx + 1) % 9, out, sum);
			
		}
	}
}
