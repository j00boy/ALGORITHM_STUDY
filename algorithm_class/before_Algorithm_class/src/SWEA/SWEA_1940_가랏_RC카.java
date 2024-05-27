/*
 * <command 정의>
 * 0: 현재 속도 유지
 * 1: 가속 => 1 or 2
 * 2: 감속 => 1 or 2
 * 
 * int N = sc.nextInt();
 */

package SWEA;

import java.util.Scanner;

public class SWEA_1940_가랏_RC카 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// T
		
		int T = sc.nextInt();					// N
		for(int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int totalDistance = 0;
			int rcSpeed = 0;
			
			for(int j = 0; j < N; j++) {
				int input = sc.nextInt();		// input
				switch(input) {
				case 1:
					int plusSpeed = sc.nextInt();		// + option
					rcSpeed = (rcSpeed + plusSpeed);
					break;
				case 2:
					int minusSpeed = sc.nextInt();		// - option
					if(rcSpeed - minusSpeed <= 0) {
						rcSpeed = 0;
					} else {
						rcSpeed = (rcSpeed - minusSpeed);
					}
					break;
				default:
					break;
				}
			
				totalDistance += rcSpeed;
			}
			System.out.printf("#%d %d\n", i, totalDistance);
		}
		
	}

}
