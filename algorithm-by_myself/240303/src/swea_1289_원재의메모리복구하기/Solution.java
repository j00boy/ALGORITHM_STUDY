package swea_1289_원재의메모리복구하기;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_1289_원재의메모리복구하기/input.txt"));
		
		int T = sc.nextInt();
		
		// tc
		for(int tc = 1; tc <= T; tc++) {
			String s = sc.next();
			
			int count = 0;
			if(s.charAt(0) == '1') {
				count = 1;
			}
			for(int i = 1; i < s.length(); i++) {
				if(s.charAt(i) != s.charAt(i-1)) {
					count++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}
		// tc
	}
}