package swea_1989_초심자의회문검사;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {

//		File file = new File("src/swea_1989_초심자의회문검사/input.txt");
//		Scanner sc = new Scanner(file);
		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			if(str.equals(getPalindrome(str))) {
				System.out.printf("#%d %d\n", test_case, 1);
			} else {
				System.out.printf("#%d %d\n", test_case, 0);
			}
		}
	}

	public static String getPalindrome(String str) {

		char[] ch = str.toCharArray();
		String s = "";
		for(int i = ch.length-1; i >= 0; i--) {
			s = s + ch[i];
		}
		
		return s;
			
	}
}
