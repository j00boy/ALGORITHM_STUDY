package swea_보물상자비밀번호;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_보물상자비밀번호/input.txt"));
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			String input = sc.next();
			StringBuilder sb = new StringBuilder(input);
			
			int num = N / 4;
			
			for(int i = 0; i < N; i += N/4) {
				String ans = "";
				for(int j = i; j < i + N/4; j++) {
					ans += sb.charAt(j);
				}
				
				if(ans.length())
			}
			
			
		}
		// test case
	}

}
