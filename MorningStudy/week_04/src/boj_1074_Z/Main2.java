package boj_1074_Z;

import java.util.Scanner;

public class Main2 {

	static int[][] map;
	static int N;
	static int targetR;
	static int targetC;
	static int number;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		int map_N = (int) Math.pow(2, N);

		map = new int[map_N][map_N];

		targetR = sc.nextInt();
		targetC = sc.nextInt();

		recur(0, 0, targetR, targetC, map_N);

		System.out.println(number);

	}

	// r: 행 시작점
	// c: 열 시작점

	// 전체를 나누어서,

	static void recur(int r, int c, int targetR, int targetC, int side) {

		if (side == 1) {
			if (r == targetR && c == targetC) {
				return;
			}

		} else {
			int div_side = side / 2;

			if (targetR >= r && targetR < r + div_side && targetC >= c && targetC < c + div_side) {
				recur(r, c, targetR, targetC, div_side);
			} else if (targetR >= r && targetR < r + div_side && targetC >= c + div_side && targetC < side) {
				recur(r, c + div_side, targetR, targetC, div_side);
			} else if (targetR >= r + div_side && targetR < side && targetC >= c && targetC < c + div_side) {
				recur(r + div_side, c, targetR, targetC, div_side);
			} else if (targetR >= r + div_side && targetR < side && targetC >= c + div_side && targetC < side) {
				recur(r + div_side, c + div_side, targetR, targetC, div_side);
			} else {
				number += div_side * div_side;
			}
		}
	}

}