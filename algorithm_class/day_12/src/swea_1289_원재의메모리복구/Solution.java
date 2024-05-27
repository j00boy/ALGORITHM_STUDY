package swea_1289_원재의메모리복구;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws FileNotFoundException {
		
//		File file = new File("src/swea_1289_원재의메모리복구/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			String memoryValue = sc.next();
			int count = countModified(memoryValue);
			System.out.printf("#%d %d\n", tc, count);
			
		}
		
	}
	
	public static int countModified(String str) {
		int count = 0;
		
		if(str.charAt(0) == '1') {
			count = 1;
		}
				
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) != str.charAt(i-1)) {
				count++;
			}
		}
		
		return count;
	}
	
}