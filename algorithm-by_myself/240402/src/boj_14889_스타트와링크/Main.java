package boj_14889_스타트와링크;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] adj;
	static int[] start;
	static boolean[] visited;
	static int minGap = Integer.MAX_VALUE;
	static int total = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		start = new int[N / 2];
		adj = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				adj[r][c] = sc.nextInt();
				total += adj[r][c];
			}
		}

		comb(0, 0);

		System.out.println(minGap);
	}

	public static void comb(int idx, int sidx) {
		if (sidx >= N/2) {
//			System.out.println(Arrays.toString(start));
			for(int i = 0; i < N; i++) {
				
			}
			int gap = teamWork();
			minGap = Math.min(gap, minGap);
			return;
		}

		if (idx >= N) {
			return;
		}

		start[sidx] = idx;
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}

	public static int teamWork() {
		int sum1 = 0;
		for (int i : start) {
			for(int j : start) {
				sum1 += adj[i][j];
				System.out.println(i + " " + j);
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j : start) {
				if(i != j) {
					
				}
			}
		}
		
		int sum2 = total - sum1;

		return Math.abs(sum1 - sum2);

	}
}
