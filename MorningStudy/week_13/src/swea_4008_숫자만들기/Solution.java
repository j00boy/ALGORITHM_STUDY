package swea_4008_숫자만들기;

import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int[] numbers;
	static int[] counts;	// 카운팅 배열
	static int[] operators;
	static int max;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			
			counts = new int[4];		// +, -, *, /
			operators = new int[N-1];	// 연산자 조합을 담을 배열
			numbers = new int[N];
			
			for(int i = 0; i < 4; i++) {
				counts[i] = sc.nextInt();
			}

			for(int i = 0; i < N; i++) {
				numbers[i] = sc.nextInt();
			}
			
			permutation(0);
			
//			sb.append("#" + tc + " " + (max - min)).append("\n");
			System.out.println("#" + tc + " " + (max - min));
			
		}
		// test case	
//		System.out.println(sb);
		
	}

	// 순열
	public static void permutation(int idx) {
		if(idx >= N-1) {
//			System.out.println(Arrays.toString(operators));
			int answer = numbers[0]; // 시작은 numbers[0]
			for(int i = 1; i < N; i++) {
				switch(operators[i-1]) {
					case 0: 
						answer += numbers[i];
						break;
					case 1: 
						answer -= numbers[i];
						break;
					case 2: 
						answer *= numbers[i];
						break;
					default: 
						answer /= numbers[i];
						break;
				}
			}
			min = Math.min(min, answer);
			max = Math.max(max, answer);
			return;
		}

		for(int i = 0; i < 4; i++) {
			if(counts[i] != 0) {
				counts[i]--;
				operators[idx] = i;
				permutation(idx + 1);
				counts[i]++;
			}
		}
	}
}
