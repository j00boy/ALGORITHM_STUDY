package boj_12865_평범한배낭;

import java.util.Scanner;

public class Main {
	
	static int N;		// 물품의 수
	static int K;		// 준서가 버틸 수 있는 무게
	static int[] D;
	static int[] weight;
	static int[] value;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		D = new int[N+1];
		weight = new int[N+1];
		value = new int[N+1];
		
		for(int i = 1; 1 <= N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		
		/*
		 * D[i] = i개를 가방에 넣었을 때 가질 수 있는 가치의 최대
		 */
		
		for(int i = 1; i <= N; i++) {
			if(i == 1) {
				 
			}
		}
	}
}

