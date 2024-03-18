package boj_15486_퇴사2;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] T;
	static int[] P;
	static int[] D;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		T = new int[N+1];	// 진행일
		P = new int[N+1];	// 수익
		D = new int[N+2];	// i번째 일 ~ 퇴사일까지 벌 수 있는 최대 수익
		int dDay = N+1;		// 퇴사일
		
		for(int i = 1; i <= N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		// 탑 다운밖에 못하겠음
		D[N+1] = 0;
		for(int i = N; i >= 1; i--) {
			if(i + T[i] > dDay) {	// i번쨰 일에 해당하는 일을 할 수 없는 경우라면
				D[i] = D[i+1];		// 전꺼랑 똑같음
			} else {				// i+T[i] <= 퇴사일이라면
				D[i] = Math.max(D[i+1], D[i+T[i]] + P[i]);	// i번째 일을 하지 않는 경우 vs 일을 했을 경우의 수익 + 해당 일정 진행 후의 수익
			}
		}
		
		System.out.println(D[1]);
	}
}