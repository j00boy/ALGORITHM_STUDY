package swea_1218_괄호짝짓기;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/swea_1218_괄호짝짓기/input.txt"));
		Stack<Character> stack = new Stack<>();


		// test case
		for (int tc = 1; tc <= 10; tc++) {
			stack.clear();
			int N = sc.nextInt();
			String str = sc.next();

			boolean isValid = true;
			
			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				
				if(!isValid) break;
				
				if (c == '(' || c == '[' || c == '{' || c == '<') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.peek() != '(') {
						isValid = false;
						break;
					} else {
						stack.pop();
					}
				} else if (c == ']') {
					if (stack.peek() != '[') {
						isValid = false;
						break;
					} else {
						stack.pop();
					}
				} else if (c == '}') {
					if (stack.peek() != '{') {
						isValid = false;
						break;
					} else {
						stack.pop();
					}
				} else if (c == '>') {
					if (stack.peek() != '<') {
						isValid = false;
						break;
					} else {
						stack.pop();
					}
				}
				
			}

			if (stack.isEmpty() && isValid) {
				System.out.printf("#%d %d\n", tc, 1);
			} else {
				System.out.printf("#%d %d\n", tc, 0);
			}

		}
		// test case
	}
}
