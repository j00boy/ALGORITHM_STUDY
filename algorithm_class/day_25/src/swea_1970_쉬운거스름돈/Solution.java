package swea_1970_쉬운거스름돈;

import java.util.Scanner;

public class Solution {
	
	static int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		// [그리디 알고리즘]
		// test case
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < 8; i++) {
				if((N/money[i]) >= 1) {
					sb.append(N / money[i] + " ");
					N = N % money[i];
				} else {
					sb.append("0" + " ");
				}
			}
			
			System.out.println("#" + tc + "\n" + sb);
		}
		// test case
	}
}