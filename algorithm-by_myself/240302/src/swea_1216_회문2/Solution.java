package swea_1216_회문2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_1216_회문2/input.txt"));

		// test case
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();

			char[][] letters = new char[100][100];

			for (int r = 0; r < 100; r++) {
				String str = sc.next();
				for (int c = 0; c < 100; c++) {
					letters[r][c] = str.charAt(c);
				}
			}

			int max = 0;
			// 행 검사
			for (int r = 0; r < 100; r++) {
				for (int i = 0; i < 100; i++) {
					String str = "";
					for(int j = i; j < 100; j++) {
						str += letters[r][j];
						StringBuilder sb = new StringBuilder(str);
						sb.reverse();
						if(str.equals(sb.toString())) {
							if(max < str.length()) {
								max = str.length();
							}
						}
					}
					
				}
			}
			
			// 열 검사
			for (int c = 0; c < 100; c++) {
				for (int i = 0; i < 100; i++) {
					String str = "";
					for(int j = i; j < 100; j++) {
						str += letters[j][c];
						StringBuilder sb = new StringBuilder(str);
						sb.reverse();
						if(str.equals(sb.toString())) {
							if(max < str.length()) {
								max = str.length();
							}
						}
					}
					
				}
			}


			System.out.printf("#%d %d\n", T, max);
		}
	}

}
