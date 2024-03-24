package boj_15651_N과M_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] nums;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sel = new int[M];
		
		comb(0);
	}
	
	public static void comb(int idx) {
		if(idx >= M) {
			String tmp = "";
			for(int i = 0; i < M; i++) {
				tmp += sel[i] + " ";
			}
			System.out.println(tmp);
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			sel[idx] = i;
			comb(idx + 1);
		}
	}
}
