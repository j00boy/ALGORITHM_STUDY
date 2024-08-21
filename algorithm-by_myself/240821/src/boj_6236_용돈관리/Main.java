package boj_6236_용돈관리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	
	static int[] days;
	
	static int K;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		days = new int[N];
		
		for(int i = 0; i < N; i++) {
			days[i] = Integer.parseInt(br.readLine());
		}
		
		int left = 1;
		int right = 1000000000;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int count = 1;
			int budget = mid;
			boolean isError = false;
			
//			System.out.println("변화 전 left : right = " + left + " : " + right);
			
			/*
			 *  다만 현우는 M이라는 숫자를 좋아하기 때문에,
			 *  정확히 M번을 맞추기 위해서 남은 금액이 그날 사용할 금액보다 많더라도 남은 금액은 통장에 집어넣고 다시 K원을 인출할 수 있다.
			 */
			for(int i = 0; i < N; i++) {
				if(budget - days[i] >= 0) {
					budget -= days[i];
				} else {
					count++;
					budget = mid;
					budget -= days[i];
					
					if(budget < 0) {
						isError = true;
						break;
					}
				}
			}
			
			if(isError) {
				left = mid + 1;
				continue;
			}
			
			// 최솟값을 구해야 하기 때문에
			if(count > M) {
				left = mid + 1;
			} else {	// count < M
				right = mid - 1;
			}
			
//			System.out.println("인출금액: " +  mid);
//			System.out.println("인출횟수: " + count);
//			System.out.println("변화 후 left : right = " + left + " : " + right);
		}
		
		System.out.println(right + 1);
	}
}
