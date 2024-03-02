package swea_1220_Magnetic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_1220_Magnetic/input.txt"));
		
		// tc
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			char[][] table = new char[N][N];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					table[r][c] = sc.next().charAt(0);
				}
			}
			
			
			int count = 0;
			for(int c = 0; c < N; c++) {
				String str = "";
				for(int r = 0; r < N; r++) {
					if(table[r][c] != '0') {
						str += table[r][c];
					}
				}
								
				String[] arr = str.split("12");
				String newStr = "";
				for(String s : arr) {
					newStr += s;
				}
				
				count += (str.length() - newStr.length()) / 2;
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}
		// tc
	}
}