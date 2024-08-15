package boj_15988_123더하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static long[] D = new long[1000001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		D[0] = 0;
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		
		for(int test = 0; test < T; test++) {
			int n = Integer.parseInt(br.readLine());	// 1 ~ 1,000,000
			
			System.out.println(topDown(n));
		}
	}
	
	public static long topDown(int n) {
		if(n == 3) return 4;
		if(n == 2) return 2;
		if(n == 1) return 1;
		
		if(D[n] == 0) {			
			D[n] = (topDown(n-1) + topDown(n-2) + topDown(n-3)) % 1000000009;
		}
		
		return D[n];
	}
}
