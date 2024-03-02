package swea_1860_진기의최고급붕어빵;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("src/swea_1860_진기의최고급붕어빵/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();

			int[] time = new int[11112];

			for (int i = 0; i < N; i++) {
				time[sc.nextInt()]++;
			}

			int 붕어빵 = 0;
			boolean possible = true;
			
			if(time[0] != 0) {
				possible = false;
			}
			
			for (int i = 1; i < 11112; i++) {
				if (i % M == 0) {
					붕어빵 += K;
				}
				
				붕어빵 -= time[i];

				if (붕어빵 < 0) {
					possible = false;
					break;
				}
			}

			if (possible) {
				System.out.printf("#%d %s\n", tc, "Possible");
			} else {
				System.out.printf("#%d %s\n", tc, "Impossible");
			}
		}
		// test case
	}

}