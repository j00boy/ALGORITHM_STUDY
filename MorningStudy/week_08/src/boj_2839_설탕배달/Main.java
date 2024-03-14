/**
 * [실버 4]
 * - 설탕 배달
 * - 3kg
 * - 5kg
 */

package boj_2839_설탕배달;

import java.util.Scanner;

public class Main {
	
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		if(N % 5 == 0) {
			System.out.println(N/5);
		}
	}
}