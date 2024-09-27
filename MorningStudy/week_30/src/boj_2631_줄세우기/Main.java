package boj_2631_줄세우기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N;
	static int[] line;
	static int[] D;
	
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		line = new int[N + 1];
		D = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			line[i] = Integer.parseInt(br.readLine());
		}
		
		// D: 내가 마지막이 되어야 한다. (LIS: 최장증가 부분수열)
		// N: 1 ~ 200
		
		int max = 0;
		
		for(int i = 1; i <= N; i++) {
			D[i] = 1;	// 시작할 때는 1 (나)
			for(int j = 1; j <= i; j++) {	// 처음부터 i번째까지
				if(line[j] < line[i]) {		// 내가 더 크면, 나를 끝으로 하는 최장증가부분수열의 크기를 갱신
					D[i] = Math.max(D[i], D[j] + 1);
					max = Math.max(max, D[i]);
				}
			}
		}
		
//		System.out.println(Arrays.toString(line));
//		System.out.println(Arrays.toString(D));
		
		System.out.println(N - max);
	}
	
}
