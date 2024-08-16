package boj_15989_123더하기4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int[] D;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		D = new int[10001];	// 1 ~ 10000
		sb = new StringBuilder();
		
		D[0] = 0;
		D[1] = 1;	// {1}
		D[2] = 2;	// {1,1}, {2}
		D[3] = 3;	// {1,1,1}, {1,2}, {3}
		D[4] = 4;	// {1,1,1,1}, {1,1,2}, {2,2}, {1,3}
		D[5] = 5;	// {1,1,1,1,1}, {1,1,1,2}, {1,2,2}, {1,1,3}, {2,3}
		D[6] = 7;	// {1.1.1.1.1.1}, {1,1,1,1,2}, {1,1,2,2}, {1,1,1,3}, {1,2,3}, {2,2,2}, {3,3}
		/**
		 *  TODO
		 *  D[i] = D[i-1]
		 */
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(D[n]).append('\n');
			
		}
		
		System.out.println(sb);
	}
	
	
}