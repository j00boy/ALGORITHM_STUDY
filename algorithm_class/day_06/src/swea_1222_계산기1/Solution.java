package swea_1222_계산기1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	static int top;
	static char[] prestack;
	static int[] stack;
	static int size;

	public static void main(String[] args) throws Exception {

//		File file = new File("src/swea_1222_계산기1/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);

		// test case 시작
		for (int tc = 1; tc <= 10; tc++) {

			size = sc.nextInt();
			prestack = new char[size];
			String expression = sc.next();
			top = -1;
			String postfix = "";

			for (int i = 0; i < size; i++) {
				char c = expression.charAt(i);

				if (c >= '0' && c <= '9') {
					postfix += c;
				} else {
					prepush(c);
				}

			}
			while (!isEmpty()) {
				postfix += prepop();
			}
//			System.out.println(postfix);

			top = -1;
			size = postfix.length();
			stack = new int[size];
			int result = 0;

			for (int i = 0; i < size; i++) {
				char c = postfix.charAt(i);

				if (c >= '0' && c <= '9') {
					int n = c - '0';
					push(n);
				} else {
					int a = pop();
					int b = pop();
					int sum = a + b;
					push(sum);
				}
			}

			result = peak();
			System.out.printf("#%d %d\n", tc, result);
		}
		// test case 끝
	}

	public static boolean isEmpty() {
		return top == -1;
	}

	// char 스택
	public static boolean preIsFull() {
		return top == prestack.length - 1;
	}

	public static void prepush(char c) {
		if (preIsFull()) {
			System.out.println("값을 추가할 수 없습니다.");
			return;
		}
		prestack[++top] = c;
	}

	public static char prepop() {
		if (isEmpty()) {
			System.out.println("값을 뺄 수 없습니다.");
			return '\u0000';
		}
		char tmp = prestack[top];
		prestack[top--] = '\u0000';
		return tmp;
	}

	public static char prepeak() {
		return prestack[top];
	}

	// int 스택
	public static boolean isFull() {
		return top == stack.length - 1;
	}

	public static void push(int n) {
		if (isFull()) {
			System.out.println("값을 추가할 수 없습니다.");
			return;
		}
		stack[++top] = n;
	}

	public static int pop() {
		if (isEmpty()) {
			System.out.println("값을 빼낼 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		int tmp = stack[top];
		stack[top--] = 0;
		return tmp;
	}

	public static int peak() {
		return stack[top];
	}

}