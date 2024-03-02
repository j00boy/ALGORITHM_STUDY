package swea_2007_패턴마디의길이;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		String str = "";
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			str = sc.next();
			int min = 30;
			
			for(int i = 1; i <= 10; i++) {
				String tmp = str;
				String substr = tmp.substring(0, i);
				
				int count = 0;
				for(int j = 0; j < 30; j += substr.length()) {
					String check = "";
					for(int k = j; k < j+substr.length(); k++) {
						if(k >= 30) {
							break;
						}
						check += str.charAt(k);
					}
					if(check.equals(substr)) {
						count++;
					}
				}
				if(min > count) min = count;
			}
			
			System.out.println(min);
		}
	}
}
