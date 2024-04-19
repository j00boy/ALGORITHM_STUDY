package boj_11559_PuyoPuyo;

import java.util.Scanner;

public class Main {
	
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		map = new char[12][6];
		
		for(int r = 0; r < 12; r++) {
			String str = sc.next();
			for(int c = 0; c < 6; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
	}
}