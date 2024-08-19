package boj_10816_숫자카드2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] cards;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		N = sc.nextInt();
		cards = new int[N];
		
		for(int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}
		
		Arrays.sort(cards);
		
		M = sc.nextInt();
		
		for(int i = 0; i < M; i++) {
			int num = sc.nextInt();
			
			sb.append(binarySearch(num) + " ");
		}
		
		System.out.println(sb);
	}
	
	static int binarySearch(int num) {
		int left = 0;
		int right = N - 1;
		int count = 0;
		
		int start = -1;
		int end = -1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(cards[mid] < num) {
				left = mid + 1;
			} else {	// cards[mid] > num
				right = mid - 1;
			}
		}
		start = left;
		
		left = 0;
		right = N - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(cards[mid] <= num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		end = right;
		
		return end - start + 1;
	}
}
