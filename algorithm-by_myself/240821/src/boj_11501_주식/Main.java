package boj_11501_주식;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[] price = new int[N];
			
			for(int i = 0; i < N; i++) {
				price[i] = sc.nextInt();
			}
			
			long profit = 0;

			int high = N-1;
			for(int i = N-1; i >= 0; i--) {
				if(price[i] <= price[high]) {
					profit += price[high] - price[i];
				} else {
					high = i;
				}
			}
			
			System.out.println(profit);
		}
	}
}
