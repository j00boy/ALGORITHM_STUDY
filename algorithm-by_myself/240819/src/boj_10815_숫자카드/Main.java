package boj_10815_숫자카드;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static StringBuilder sb;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] cards = new int[N];
		
		for(int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}
		
		Arrays.sort(cards);	// -10 2 3 6 10
		
		sb = new StringBuilder();
		
		int M = sc.nextInt();
		
		for(int i = 0; i < M; i++) {
			int num = sc.nextInt();
			
			game(cards, num);
		}
		
		System.out.println(sb);
	}
	
	public static void game(int[] arr, int num) {
		int left = 0;
		int right = arr.length - 1;
		boolean flag = true;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(arr[mid] == num) {
				flag = false;
				break;
			} else if(arr[mid] < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		if(flag) {
			sb.append("0 ");
		} else {
			sb.append("1 ");
		}
	}
}
