package swea_1217_거듭제곱;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static int[] memoziation = new int[100];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		File file = new File("src/swea_1217_거듭제곱/input.txt");
//		Scanner sc = new Scanner(file);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int test_case = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.printf("#%d %d\n", test_case, power(N, M));
		}
	}

	public static int power(int N, int M) {
		if (M == 0) return 1;
		else if (M == 1) return N;
		else {
		if (memoziation[N] != 0)
			return memoziation[N];
		return N * power(N, M-1);
		}
	}
}