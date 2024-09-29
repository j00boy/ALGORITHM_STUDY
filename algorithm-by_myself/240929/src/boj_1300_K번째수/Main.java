package boj_1300_K번째수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;	// (1 ~ 100,000) -> 10,000,000,000 -> 100억
	static int k;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());	// k번째 인덱스에 있는 수를 꺼내와라. // 실제로는 K+1 인덱스 == K번째에 있는 수를 반환하라.
		
		// k가 mid일 때, 같거나 작은 원소의 개수가 k개 인 것 중에 최소
		
		long left = 0;
		long right = 1000000000;	// 10억 
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long count = 0;
			
			for(int i = 1; i <= N; i++) {
				if(mid / i > N) {
					count += N;
				} else {
					count += mid / i;
				}
			}
			
			if(count < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(right + 1);
	}
}
