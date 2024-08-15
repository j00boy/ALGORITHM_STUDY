package boj_9935_문자열폭발;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static final String FRULA = "FRULA";
	
	static String input;
	static String bomb;
	static String output;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine();
		bomb = br.readLine();
		int bombSize = bomb.length();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < input.length(); i++) {
			
			// stack을 이용하면 문자열을 한번 순회하면서, 무조건 앞에 있는 애들만 비교하면 됨
			stack.push(input.charAt(i));
			
			if(stack.size() >= bombSize) {
				boolean canBomb = true;
				
				for(int j = 0; j < bombSize; j++) {
					// 폭발 문자열과 같은지
					if(stack.get(stack.size() - bombSize + j) != bomb.charAt(j)) {
						canBomb = false;
						break;
					}
				}
				
				// 같은 거면, 삭제
				if(canBomb) {
					for(int j = 0; j < bombSize; j++) {
						stack.pop();
					}
				}
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println(FRULA);
		} else {
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty()) {
				sb = sb.append(stack.pop());
			}
			System.out.println(sb.reverse());
		}
		
	}
}
