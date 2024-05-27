package swea_1218_괄호짝짓기;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	static char[] stack;
	static int top;
	static int size;

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("src/swea_1218_괄호짝짓기/input.txt");
		Scanner sc = new Scanner(file);
		
//		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {

			top = -1;
			size = sc.nextInt();
			stack = new char[size];
			String str = sc.next();

			if (size % 2 == 1) {
				System.out.printf("#%d %d\n", tc, 0);
				continue;
			}

			int result = 1;

			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(' || str.charAt(i) == '<' || str.charAt(i) == '{' || str.charAt(i) == '[') {
					push(str.charAt(i));
				} else {
					if(str.charAt(i) == ')') {
						if(peek() == '(') {
							pop();
						} else {
							result = 0;
							break;
						}
					} else if(str.charAt(i) == '>') {
						if(peek() == '<') {
							pop();
						} else {
							result = 0;
							break;
						}
					} else if(str.charAt(i) == '}') {
						if(peek() == '{') {
							pop();
						} else {
							result = 0;
							break;
						}
					} else if(str.charAt(i) == ']') {
						if(peek() == '[') {
							pop();
						} else {
							result = 0;
							break;
						}
					}
				}
			}
			
			if(!isEmpty()) {
				result = 0;
			}
			
			System.out.printf("#%d %d\n", tc, result);

		}
	}

	public static boolean isEmpty() {
		return top == -1;
	}

	public static boolean isFull() {
		return top == stack.length - 1;
	}

	public static void push(char data) {
		if (isFull()) {
			System.out.println("추가할 수 없습니다.");
			return;
		}
		stack[++top] = data;
	}

	public static char pop() {
		if (isEmpty()) {
			return '\u0000';
		}
		char tmp = stack[top];
		stack[top--] = '\u0000';
		return tmp;
	}

	public static char peek() {
		return stack[top];
	}

}