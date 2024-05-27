package swea_1213_String;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		
//		File file = new File("src/swea_1213_String/input.txt");
//		Scanner sc = new Scanner(file);
		
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		// test case Start
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			String pattern = sc.next();
			String text = sc.next();
			
			
				String s = "";
				String[] arr = text.split(pattern);
				for(int i = 0; i < arr.length; i++) {
					s += arr[i];
				}
				int how_many = (text.length() - s.length()) / pattern.length();
				
				System.out.printf("#%d %d\n", test_case, how_many);
		}
		// test case End
	}
}