package swea_5432_쇠막대기자르기;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static char[] stack;
	static int size;
	static int top;

	public static void main(String[] args) throws IOException {
		File file = new File("src/swea_5432_쇠막대기자르기/input.txt");
		Scanner sc = new Scanner(file);

		int T = sc.nextInt();

		// test case 시작
		for (int tc = 1; tc <= T; tc++) {

			String sentence = sc.next();
			top = -1;
			stack = sentence.toCharArray();
			size = stack.length;

			int stick = 1; // 현재 스틱 수
			int sum = 0; // 개수의 합

			for (int i = 1; i < size; i++) {
				if(stack[i] == ')') {
					stick--;
					if(stack[i-1] == '(') {
						if(stick != 0) {
							sum += stick;
						}
					} else {
						sum += 1;
					}
				} else {
					stick++;
				}
			}

			System.out.printf("#%d %d\n", tc, sum);

		}
		// test case 끝

	}

	public static boolean isEmpty() {
		return top == -1;
	}

	public static boolean isFull() {
		return top == stack.length - 1;
	}

	public static void push(char ch) {
		if (isFull()) {
			System.out.println("추가할 수 없습니다.");
			return;
		}
		stack[top++] = ch;
	}

	public static char pop() {
		if (isEmpty()) {
			System.out.println("빼낼 수 없습니다.");
			return '\u0000';
		}
		char tmp = peek();
		stack[top--] = '\u0000';
		return tmp;
	}

	public static char peek() {
		return stack[top];
	}

}