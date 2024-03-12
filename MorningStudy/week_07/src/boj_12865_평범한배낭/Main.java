package boj_12865_평범한배낭;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N; // 물품의 수
	static int K; // 준서가 버틸 수 있는 무게
	static int[] D;
	static int[] weight;
	static int[] value;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		D = new int[K + 1];
		weight = new int[N + 1];
		value = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}

		/*
		 * 알고리즘 분류에 냅색 알고리즘이라고 해서 보니,
		 * 냅색 알고리즘의 핵심은 어떤 경우의 수를 넣지 않는 것이
		 * 최선의 경우가 될 수 있음을 고려해주는 것
		 * 
		 * 알고리즘 분류에 배낭 문제라고 있어서 냅색 알고리즘을 찾아보니까
		 * 약간의 스포를 당한 상태에서 시작합니다.
		 */

		
		
		System.out.println(Arrays.toString(D));
		
	}
}
