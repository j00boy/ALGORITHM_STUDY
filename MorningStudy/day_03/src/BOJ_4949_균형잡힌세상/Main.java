package BOJ_4949_균형잡힌세상;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 런타임 에러땜시
		// keepGoing = false면 종료
		boolean keepGoing = true;
		while (keepGoing) {
			
			String str = sc.nextLine();	
			
			// while true라는 무한반복 막기
			// '.' 이 처음에 나오면
			if(str.charAt(0) == '.' && str.length() == 1) {
				keepGoing = false;
				break;
			}

			Stack<Character> stack = new Stack<>();

			// 조건에 부합하지 않으면 문장 1 cycle에 대한 for문 종료 
			boolean isOK = true;
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						isOK = false;
						break;
					} else {
						stack.pop();
					}
				} else if (c == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						isOK = false;
						break;
					} else {
						stack.pop();
					}
				} else if(c == '.') {
					break;
				}
			}

			if (isOK && stack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
			
		}

	}
}