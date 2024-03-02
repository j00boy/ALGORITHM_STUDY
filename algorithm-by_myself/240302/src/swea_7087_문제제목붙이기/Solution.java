package swea_7087_문제제목붙이기;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_7087_문제제목붙이기/input.txt"));
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[] list = new char[N];
			
			for(int i = 0; i < N; i++) {
				list[i] = sc.next().charAt(0); 
			}
			
			Arrays.sort(list);
			
			char target = 'A';
			int count = 0;
			
			for(char c : list) {
				if(c == target) {
					target++;
					count++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}
		// test case
	}
}
