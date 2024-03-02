package swea_7272_안경이없어;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(new File("src/swea_7272_안경이없어/input.txt"));
		
		int T = sc.nextInt();
		
		// tc
		for(int tc = 1; tc <= T; tc++) {
			String str1 = sc.next();
			String str2 = sc.next();
			
			if(str1.length() != str2.length()) {
				System.out.printf("#%d %s\n", tc, "DIFF");
				continue;
			}
			
			boolean isSame = true;
			String letter1 = "CEFGHIJKLMNSTUVWXYZ";
			String letter2 = "ADOPQR";
			String B = "B";
			int len = str1.length();
			
			for(int i = 0; i < len; i++) {
				if(letter1.contains(String.valueOf(str1.charAt(i))) && letter1.contains(String.valueOf(str2.charAt(i)))) {
					continue;
				} else if(letter2.contains(String.valueOf(str1.charAt(i))) && letter2.contains(String.valueOf(str2.charAt(i)))) {
					continue;
				} else if(str1.charAt(i) == 'B' && str2.charAt(i) == 'B') {
					continue;
				} else {
					isSame = false;
					break;
				}
			}
			
			if(isSame) {
				System.out.printf("#%d %s\n", tc, "SAME");
			} else {
				System.out.printf("#%d %s\n", tc, "DIFF");
			}
		}
		// tc
	}
}