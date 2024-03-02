package swea_4698_테네스의특별한소수;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_4698_테네스의특별한소수/input.txt"));
//		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			boolean[] visited = new boolean[B+1];
			
			int count = 0;
			for(int i = A; i <= B; i++) {
				boolean flag = true;
				for(int j = 2; j <= Math.sqrt(i); j++) {
					if(i % j == 0) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					if(String.valueOf(i).contains(String.valueOf(D))) {
						count++;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}
		// test case
	}

}
