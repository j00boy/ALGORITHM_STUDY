package boj_12865_평범한배낭;

import java.util.Scanner;

public class Main {

	static int N; 			// 물품의 수
	static int K; 			// 배낭이 버틸 수 있는 무게
	static int[][] D;		// 점화식 배열 -> [1~N번째 물건까지 사용할 수 있는 경우] * [1~K까지 가방이 버틸 수 있는 최대 무게] 라서 2차원 배열 형태의 DP 테이블
	static int[][] info;	// [i][0]에는 무게, [i][1]에는 가치

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		D = new int[N+1][K + 1];
		info = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			info[i][0] = sc.nextInt();	// weight
			info[i][1] = sc.nextInt();	// value
		}

		/*
		 * Bottom-Up 방식
		 * - For문
		 */
		
		
		for(int r = 0; r < N+1; r++) {			// ~ r번째 물건을 사용 가능한데
			for(int c = 0; c < K+1; c++) {		// 가방이 0 ~ K까지 버틸 수 있다면
				if(r == 0) {					// 행이나 열의 index가 0이라면 걔네는 0
					D[r][c] = 0;
					continue;
				}
				if(c == 0) {
					D[r][c] = 0;
					continue;
				}
				if(info[r][0] > c) {			// r번째 물건의 무게 > 가방이 버틸 수 있는 무게
					D[r][c] = D[r-1][c];		// r번째 물건을 담을 수 없음 -> r-1번째 물건까지 담는 값을 불러옴
				} else {						// r번째 물건의 무게 <= 가방이 버틸 수 있는 무게 == r번째 물건을 가방에 넣을 수는 있음
					
					// r번째 물건을 넣지 않을 경우의 최대 가치의 합 vs r번째 물건을 넣을 경우의 최대 가치의 합
					/*
					 * 만약 최대 7kg까지 담을 수 있는 가방(c == 7)에 r번째 물건의 무게가 5KG라면,
					 * 1. 7Kg 중 5kg 물건(r번째 물건)을 넣고, (7-5)kg 가방에 담을 수 있는 최대 가치와 더함
					 * 2. 그냥 안 넣고 얻을 수 있는 최대 가치의 합
					 * ------> 더 큰 값을 D[r][c]에 넣어줌  
					 */
					D[r][c] = Math.max(D[r-1][c], D[r-1][c-info[r][0]] + info[r][1]);
				}
			}
		}
		
//		for(int r = 0; r < N+1; r++) {
//			for(int c = 0; c < K+1; c++) {
//				System.out.printf("%3d", D[r][c]);
//			}
//			System.out.println();
//		}
		
		System.out.println(D[N][K]);	// 가방이 버티는 무게가 K kg일 때, 1 ~ N번까지의 물건을 넣어 얻을 수 있는 최대 가치
		
		
		
		
	}
}
