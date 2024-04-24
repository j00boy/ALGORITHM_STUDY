package programmers;

/*
8
420
0
900
0
200
150
0
30
50

4
100
245
317
151
192
 */

/*

10
10
1
3
2
4
3
3
4
3
3
4

25
10
0
0
0
0
5
5
5
5
5
0
0
0
0
0
0
0
0
0
0
0
0
0
0
5
5

 */

import java.util.Scanner;

public class Solution {
	
	static int money;
	static int[] floor;
	static int length;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		floor = new int[N + 1];
		
		money = sc.nextInt();
		
		
		for(int i = 1; i <= N; i++) {
			floor[i] = sc.nextInt();
		}
		
		int max = 0;
		int left = 1;
		int right = 1;
		
		while(right <= N) {
			int sum = 0;
			int count = 0;
			for(int i = left; i <= right; i++) {
				sum += floor[i];
				if(sum <= money) {
					count++;
				} else {
					max = Math.max(max, count);
					left++;
					if(right < left) right = left;
					break;
				}
			}
			
			if(sum <= money) {
				max = Math.max(max, count);
				right++;
			} else {
				left++;
				if(right < left) right = left;
			}
		}
		
		System.out.println(max);
		
		
		
		
	}
}
