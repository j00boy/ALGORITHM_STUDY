package swea_2112_보호필름;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	static int D;
	static int W;
	static int K;
	static int[][] film;
	static int[][] copied;
	static int drug;
	static String cdt0;
	static String cdt1;
	static int[] sel;
	static boolean[] visited;
	static boolean flag;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("src/swea_2112_보호필름/input.txt"));

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {
			D = sc.nextInt(); // 보호필름의 두께
			W = sc.nextInt(); // 보호필름 가로 크기
			K = sc.nextInt(); // 합격기준
			drug = 0; // 약품 투여 횟수
			film = new int[D][W];
			cdt0 = "";
			cdt1 = "";
			flag = false;

			// A = 0, B = 1
			for (int r = 0; r < D; r++) {
				for (int c = 0; c < W; c++) {
					film[r][c] = sc.nextInt();
				}
			}

			for (int i = 0; i < K; i++) {
				cdt0 += "0";
				cdt1 += "1";
			}

			if (checkPNP(film)) {
				System.out.printf("#%d %d\n", tc, drug);
				continue;
			} else {
				for (int i = 1; i <= K; i++) {
					if (i == K) {
						drug = K;
						break;
					}
					sel = new int[i];
					copied = new int[D][W];
					copy();
					insertDrug(0, 0, i);
					if (flag) {
						drug = i;
						break;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, drug);
		}
		// test case
	}

	// 조합
	public static void insertDrug(int idx, int sidx, int size) {

		if (sidx >= size) {
			visited = new boolean[size];
			powerSet(0);
			return;
		}

		if (idx >= D) {
			return;
		}

		sel[sidx] = idx;
		insertDrug(idx + 1, sidx + 1, size);
		if (flag)
			return;
		insertDrug(idx + 1, sidx, size);
		if (flag)
			return;
	}

	public static boolean checkPNP(int[][] arr) {
		for (int c = 0; c < W; c++) {
			String str = "";
			for (int r = 0; r < D; r++) {
				str += arr[r][c];
			}
			if (!str.contains(cdt0) && !str.contains(cdt1)) {
				return false;
			}
		}

		return true;

	}

	public static void copy() {
		for (int r = 0; r < D; r++) {
			for (int c = 0; c < W; c++) {
				copied[r][c] = film[r][c];
			}
		}
	}

	public static void powerSet(int idx) {
		if (idx >= sel.length) {
			for (int r = 0; r < sel.length; r++) {
				if (visited[r]) {
					for (int c = 0; c < W; c++) {
						copied[sel[r]][c] = 0;
					}
				} else {
					for (int c = 0; c < W; c++) {
						copied[sel[r]][c] = 1;
					}
				}
			}

			if (checkPNP(copied)) {
				flag = true;
				return;
			} else {
				copy();
				return;
			}
		}

		if (flag)
			return;

		visited[idx] = false;
		powerSet(idx + 1);
		visited[idx] = true;
		powerSet(idx + 1);
	}
}