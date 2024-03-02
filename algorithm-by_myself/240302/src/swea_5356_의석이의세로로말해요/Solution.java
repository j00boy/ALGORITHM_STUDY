package swea_5356_의석이의세로로말해요;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_5356_의석이의세로로말해요/input.txt"));
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			char[][] map = new char[5][15];
			
			for(int i = 0; i < 5; i++) {
				String str = sc.next();
				for(int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			String answer = "";
			for(int j = 0; j < 15; j++) {
				for(int i = 0; i < 5; i++) {
					if(map[i][j] != '\u0000') {
						answer += map[i][j];
					}
				}
			}
			
			
			System.out.printf("#%d %s\n", tc, answer);
		}
		// test case
	}

}
