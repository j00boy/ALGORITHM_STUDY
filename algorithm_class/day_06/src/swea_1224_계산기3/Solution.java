package swea_1224_계산기3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	static char[] prestack;
	static int[] stack;
	static int top;
	static int size;
	
	public static void main(String[] args) throws IOException {

//		File file = new File("src/swea_1224_계산기3/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = 10;	// test case 횟수
		// 연산자 우선순위를 저장할 HashMap
		Map<Character, Integer> priority = new HashMap<>();
		
		priority.put('*', 2);	// 우선순위가 가장 높음
		priority.put('+', 1);
		priority.put(')', 0);	// 우선순위가 가장 낮음
		
		// test case 시작
		for(int tc = 1; tc <= 10; tc++) {
			size = sc.nextInt();
			prestack = new char[size];
			String expression = sc.next();
			String postfix = "";
			
			// prestack
			for(int i = 0; i < size; i++) {
				char c = expression.charAt(i);
				
				if(c == '(') {		// '(' 라면
					prepush(c);		// prestack에 push 
				} else if(c >= '0' && c <= '9') {	// 피연산자라면
					postfix += c;					// 후위표기식++
				} else if(c == ')') {				// 닫는 괄호라면
					while(prepeak() != '(') {		// 여는 괄호 찾을 때까지
						postfix += prepop();		// prestack에서 pop
					}
					prepop();						// 여는 괄호 삭제
				} else {							// 연산자를 만나면
					while(!isEmpty()				// prestack이 빌 때까지 
							&& priority.get(prepeak()) != null // top에 있는 문자가 priority에 없을 때까지
							&& priority.get(c) <= priority.get(prepeak())) {	// 우선순위가 더 낮은 연산자가 prestack의 top에 위치할 때까지
						postfix += prepop();		// pop
					}
					prepush(c);
				}
			}
			
//			System.out.println(postfix);
			
			top = -1;					// top 초기화
			size = postfix.length();	// size 초기화
			stack = new int[size];		// stack 크기 초기화
			
			for(int i = 0; i < size; i++) {
				char c = postfix.charAt(i);
				
				if(c >= '0' && c <= '9') {	// 피연산자라면
					int n = c - '0';		// int형으로 바꿔서
					push(n);				// stack에 push
				} else if(c == '+') {		// 연산자 '+' 라면
					int a = pop();			// top부터 숫자 2개 빼서
					int b = pop();
					int sum = b + a;		// 더한 값을 push
					push(sum);
				} else {					// 연산자 '*' 라면
					int a = pop();			// top부터 숫자 2개 빼서
					int b = pop();
					int mul = b * a;		// 곱한 값을 push
					push(mul);
				}
			}								// postfix를 다 돌면, 결국 stack에 1개의 변수만 남음 = 그게 결과값
			
			System.out.printf("#%d %d\n", tc, peak());
		}
		// test case 끝
		
	}
	
	// prestack - char
	public static boolean isEmpty() {
		return top == -1;
	}
	
	public static boolean preIsFull() {
		return top == prestack.length - 1;
	}
	
	public static void prepush(char ch) {
		if(preIsFull()) {
			System.out.println("추가할 수 없습니다.");
			return;
		}
		prestack[++top] = ch;
	}
	
	public static char prepop() {
		if(isEmpty()) {
			System.out.println("값을 빼낼 수 없습니다.");
			return '\u0000';
		}
		char tmp = prestack[top];
		prestack[top--] = '\u0000';
		return tmp;
	}
	
	public static char prepeak() {
		return prestack[top];
	}
	
	
	
	// stack - int
	public static boolean isFull() {
		return top == stack.length - 1;
	}
	
	public static void push(int num) {
		if(isFull()) {
			System.out.println("추가할 수 없습니다.");
			return;
		}
		stack[++top] = num;
	}
	
	public static int pop() {
		if(isEmpty()) {
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