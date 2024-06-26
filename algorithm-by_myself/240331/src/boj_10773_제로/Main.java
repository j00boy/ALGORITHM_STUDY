package boj_10773_제로;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < K; i++) {
			int num = sc.nextInt();
			
			if(num != 0) {
				stack.add(num);
			} else {
				stack.pop();
			}
		}
		
		int sum = 0;
		for(int i : stack) {
			sum += i;
		}
		
		System.out.println(sum);
	}
}
