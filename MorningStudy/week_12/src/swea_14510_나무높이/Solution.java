package swea_14510_나무높이;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] tree = new int[N];
			int[] rest = new int[N];
			int max = 0;
			int oneCnt = 0;
			int minDay = 0;
			int mods = 0;	// 2로 나눌 수 있는 경우의 몫의 합
			
			for(int i = 0; i < N; i++) {
				tree[i] = sc.nextInt();
				max = Math.max(max, tree[i]);
			}
			
			int sum = 0;
			for(int i = 0; i < N; i++) {
				rest[i] = max - tree[i];
				sum += rest[i];
			}
			
			
			if(sum == 0) {
				System.out.printf("#%d %d\n", tc, 0);
				continue;
			} else if(sum == 1) {
				System.out.printf("#%d %d\n", tc, 1);
				continue;
			} else if(sum == 2) {
				System.out.printf("#%d %d\n", tc, 2);
				continue;
			} else {
				for(int i = 0; i < N; i++) {
					mods += rest[i] / 2;
					if(rest[i] % 2 == 1) {
						oneCnt++;
					}
				}
				
//				System.out.println("mods : " + mods);
//				System.out.println("oneCnt : " + oneCnt);
				
				if(mods < oneCnt) {
					minDay += (oneCnt - mods) * 2 - 1 + mods * 2;
				} else if(mods == oneCnt) {
					minDay += mods * 2;
				} else {
					minDay += oneCnt * 2;
//					System.out.println("minDay : " + minDay);
					int sur = (mods - oneCnt) * 2;
//					System.out.println("sur : " + sur);
					minDay += (sur / 3) * 2;
//					System.out.println("minDay : " + minDay);
					sur = sur % 3;
//					System.out.println("sur : " + sur);
					if(sur == 1) minDay += 1;
					else if(sur == 2) minDay += 2;
				}
				
				System.out.printf("#%d %d\n", tc, minDay);
				continue;
			}
			
		}
		// test case
	}
}
