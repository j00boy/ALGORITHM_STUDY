package BOJ_1874_스택수열;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Stack<Integer> stack = new Stack<>();

		int N = sc.nextInt();

		// StringBuilder: 메모리 초과때문에 썼더니 통과
		StringBuilder ans = new StringBuilder("");
		int start = 1;
		boolean can = true;

		for (int i = 0; i < N; i++) {
			
			int num = sc.nextInt();

			if (start <= num) {
				for (int j = start; j <= num; j++) {
					stack.push(j);
					ans.append("+\n");
				}
				start = num + 1;
				stack.pop();
				ans.append("-\n");
			} else { // start > num
				if (stack.peek() != num) {
					can = false;
					break;
				} else {
					stack.pop();
					ans.append("-\n");
				}
			}

		}

		if(can && stack.isEmpty()) {
			System.out.println(ans);
		} else {
			System.out.println("NO");
		}

	}
}