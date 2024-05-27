package swea_1217_거듭제곱;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	static int N, E;
	
	public static void main(String[] args) throws FileNotFoundException {
		
//		File file = new File("src/swea_1217_거듭제곱/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 0; tc < 10; tc++) {
			String T = sc.next();
			N = sc.nextInt();
			E = sc.nextInt();
			
			System.out.println("#"+T + " " + power(N, E));
			
		}
		
	}
	
	public static int power(int N, int E) {
		// 기저 조건
		if(E == 1) {
			return N;
		}
		
		// 재귀 부분
		int newE = E / 2; 
		int tmp = power(N, newE);
		if(E % 2 == 0) {
			return tmp * tmp;
		} else {
			return tmp * tmp * N;
		}
		
	}
}