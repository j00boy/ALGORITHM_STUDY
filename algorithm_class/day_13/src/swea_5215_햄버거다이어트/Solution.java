package swea_5215_햄버거다이어트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int L;
	static int[] scores;
	static int[] calories;
	static int max;

	public static void main(String[] args) throws IOException {

		//File file = new File("src/swea_5215_햄버거다이어트/input.txt");
		//Scanner sc = new Scanner(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		// test case
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			max = Integer.MIN_VALUE;

			scores = new int[N];
			calories = new int[N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st1.nextToken());
				calories[i] = Integer.parseInt(st1.nextToken());
			}
			
			combination(0, 0, 0);
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}
	
	public static void combination(int idx, int cal, int score) {
		
		if(cal >= L) {
			return;
		}
		
		if(idx >= N) {
			if(score > max) {
				max = score;
			}
			return;
		}

		combination(idx + 1, cal + calories[idx], score + scores[idx]);
		
		combination(idx + 1, cal, score);
		
	}
	
}