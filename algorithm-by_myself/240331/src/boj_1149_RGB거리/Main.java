package boj_1149_RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] rgb;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;
	static int sum = 0;
	
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rgb = new int[N][3];
		visited = new boolean[N][3];
		
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 3; c++) {
				rgb[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int c = 0; c < 3; c++) {
			visited[0][c] = true;
			permutation(1);
			visited[0][c] = false;
		}
		
		
		System.out.println(min);
		
		
	}
	
	public static void permutation(int idx) {
		if(idx >= N) {
			int sum = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < 3; c++) {
					if(visited[r][c]) {
						if(sum + rgb[r][c] > min) {
							return;
						}
						sum += rgb[r][c];
					}
				}
			}
			min = sum;
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			if(!visited[idx-1][i]) {
				visited[idx][i] = true;
				permutation(idx + 1);
				visited[idx][i] = false;
			}
		}
	}
}
