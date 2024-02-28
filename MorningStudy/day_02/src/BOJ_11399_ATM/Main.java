package BOJ_11399_ATM;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] list = new int[N];
		
		// 값 입력받기
		for(int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		
		Arrays.sort(list);
		
		// 누적합 배열로 전환
		for(int i = 1; i < N; i++) {
			list[i] += list[i-1];
		}
		
		// 원소합 구하기
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += list[i];
		}
		
		System.out.println(sum);
		
	}
}