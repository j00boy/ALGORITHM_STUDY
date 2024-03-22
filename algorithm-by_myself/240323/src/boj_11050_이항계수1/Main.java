/**
 * 이항계수 : 이항 정리로 전개했을 때 각 항의 계수, 주어진 크기의 (순서 없는 조합의 가짓수)
 * NCK
 */

package boj_11050_이항계수1;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		System.out.println(이항계수(N, K));
		
	}
	
	public static int 이항계수(int a, int b) {
		int 분자 = 1;
		int 분모 = 1;
		
		for(int i = 0; i < K; i++) {
			분자 *= a;
			분모 *= b;
			a--;
			b--;
		}
		
		return 분자/분모;
	}
	
}
