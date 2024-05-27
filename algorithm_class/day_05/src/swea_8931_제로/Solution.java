package swea_8931_제로;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	static int[] stack;
	static int top;
	
	
	public static void main(String[] args) throws FileNotFoundException {

//		File file = new File("src/swea_8931_제로/sample_input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		
		// test case 시작
		for(int tc = 1; tc <= TC; tc++) {
			
			int K = sc.nextInt();
			stack = new int[K];
			top = -1;
			
			for(int i = 0; i < K; i++) {
				int num = sc.nextInt();
				if(num != 0) {
					push(num);
				} else {
					pop();
				}
			}
			
			int sum = 0;
			for(int n : stack) {
				sum += n;
			}
			
			
			System.out.printf("#%d %d\n", tc, sum);
			
		}
		// test case 끝
	}

	public static void push(int data) {
		if(isFull()) {
			System.out.println("더 이상 추가할 수 없습니다.");
			return;
		}
		stack[++top] = data;
	}
	
	public static int pop() {
		if(isEmpty()) {
			System.out.println("더 이상 추출할 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		return stack[top--] = 0;
	}
	
	public static boolean isEmpty() {
		return top == -1;
	}
	
	public static boolean isFull() {
		return top == stack.length - 1;
	}
	
}