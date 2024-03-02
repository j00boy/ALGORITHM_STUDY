package swea_7964_부먹왕국의차원관문;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_7964_부먹왕국의차원관문/input.txt"));

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int D = sc.nextInt();

			int[] cities = new int[N + 2];

			for (int i = 1; i < N + 1; i++) {
				cities[i] = sc.nextInt();
			}

			cities[0] = 1;
			cities[N + 1] = 1;

			int gap = 0;
			int count = 0;

			for(int i = 0; i < N+2; i++) {
				if(cities[i] == 1) {
					gap = 0;
					continue;
				}
				
				if(cities[i] == 0) {
					gap++;
					if(gap == D) {
						cities[i] = 1;
						count++;
						gap = 0;
					}
				}
			}

//			System.out.println(Arrays.toString(cities) + " " + count);
			System.out.printf("#%d %d\n", tc, count);
		}
		// test case
	}

}
