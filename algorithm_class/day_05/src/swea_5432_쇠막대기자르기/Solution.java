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
		for(int tc = 1; tc <= T; tc++) {
			
			String str = sc.next();
			top = -1;
			stack = new char[size];
			
			int sentence = 0;
			for(int i = 0; i < size; i++) {
				if(str.charAt(i) == '(') {
					push(str.charAt(i));
					sentence++;
				} else if(str.charAt(i) == ')') {
					if(str.charAt(i-1) == '(') {
						
					}
				}
			}
			
		}
		// test case 끝
		
	}
	
	public static boolean isEmpty() {
		return top == -1;
	}
	
	public static boolean isFull() {
		return top == stack.length-1;
	}
	
	public static void push(char ch) {
		if(isFull()) {
			System.out.println("추가할 수 없습니다.");
			return;
		}
		stack[top++] = ch;
	}
	
	public static char pop() {
		if(isEmpty()) {
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