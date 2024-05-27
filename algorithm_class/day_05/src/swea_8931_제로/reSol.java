package swea_8931_제로;

import java.util.Scanner;
import java.util.Stack;

public class reSol {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		
		// test case 시작
		for(int tc = 1; tc <= TC; tc++) {
			
			int K = sc.nextInt();
			
			Stack<Integer> stack = new Stack<>();
			for(int i = 0; i < K; i++) {
				Integer num = sc.nextInt();
				if(num != 0) {
					stack.push(num);
				} else {
					stack.pop();
				}
			}
			
			Integer sum = 0;
			for(Integer n : stack) {
				sum += n;
			}
			
			
			System.out.printf("#%d %d\n", tc, sum);
			
		}
		// test case 끝
	}
}
