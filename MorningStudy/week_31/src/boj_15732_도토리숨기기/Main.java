package boj_15732_도토리숨기기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;	// 상자의 개수	(1 ~ 1,000,000)
	static int K;	// 규칙의 개수	(1 ~ 10,000)
	static int D;	// 도토리의 개수(1 ~ 10억)
	static int A;	// A번 상자부터
	static int B;	// B번 상자까지
	static int C;	// C개 간격으로 도토리를 하나씩 넣음
	
	static int[][] rules; // 규칙담는 배열 (시작점, 끝점, 간격)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		rules = new int[K][3];
		
		for(int t = 0; t < K; t++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			rules[t][0] = A;
			rules[t][1] = B;
			rules[t][2] = C;
		}
		
		// 마지막 도토리가 들어가 있는 상자의 번호를 이분탐색으로 찾음 (파라매트릭 서치)
		/*
		 *  파라매트릭 서치: 상자에 담을 수 있는 도토리의 개수 중 가장 최소값을 구항(주어진 범위 내에서 가장 답이 될 수 있는 값 -> 최소가 될 수도, 최대가 될 수도)
		 *  현재의 상자번호까지의 도토리 개수를 구했을 때, D개를 담을 수 있는가.
		 *  담을 수 있다? 어디까지 줄여도 담을 수 있나(최솟값)
		 */
		long left = 0; 
		long right = N; 
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long count = 0;		// mid 번을 마지막 도토리가 들어가 있는 상자의 번호라고 했을 때, 담을 수 있는 도토리의 수
			
			for(int i = 0; i < K; i++) {
				if(rules[i][0] > mid) {
					continue;
				} else if(rules[i][1] < mid) {
					count += (rules[i][1] - rules[i][0]) / rules[i][2] + 1;
				} else {	// start <= mid < end에 있는 경우
					count += (mid - rules[i][0]) / rules[i][2] + 1;
				}
			}
			
			if(count < D) {	// 담을 수 있는 도토리가 총 도토리 수보다 작다면,
				left = mid + 1;	// 상자 번호를 늘려
			} else {		// 담을 수 있는 도토리가 더 많거나, D개야.
				right = mid - 1;	// 더 줄여도 담기나 테스트해봐.
			}
		}
		
		// 최솟값을 구하는 문제기 때문에, right + 1 (계속 줄여나가서, 결국에 right는 안 되는 범위의 최댓값)
		// 최댓값을 구하는 문제였다면 left - 1
		System.out.println(right + 1);
	}
}
