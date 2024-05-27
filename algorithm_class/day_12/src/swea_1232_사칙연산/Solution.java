package swea_1232_사칙연산;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Node {
	String s;
	Node left;
	Node right;

	Node() {
	}

	Node(String s) {
		this.s = s;
	}

}

public class Solution {

	static Node[] tree;
	static int ans;

	public static void main(String[] args) throws FileNotFoundException {

//		File file = new File("src/swea_1232_사칙연산/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);

		// test case 시작
		for (int tc = 1; tc <= 10; tc++) {

			int N = sc.nextInt();
			ans = 0;

			tree = new Node[N + 1];
			for (int i = 0; i < N + 1; i++) {
				tree[i] = new Node();
			}

			sc.nextLine();

			for (int i = 1; i <= N; i++) {
				String str = sc.nextLine();
				String[] strArr = str.split(" ");

				if (strArr.length == 2) {
					int num = Integer.parseInt(strArr[0]);
					String s = strArr[1];

					tree[num].s = s;

				} else if (strArr.length == 4) {
					int num = Integer.parseInt(strArr[0]);
					String s = strArr[1];
					int lft = Integer.parseInt(strArr[2]);
					int rgt = Integer.parseInt(strArr[3]);

					tree[num].s = s;

					tree[num].left = tree[lft];
					tree[num].right = tree[rgt];
				}
			}

			ans = evaluate(tree[1]);
			System.out.printf("#%d %d\n", tc, ans);

		}
		// test case 끝
	}

	// 중위 순회
	// LVR
	static int evaluate(Node node) {

		if(node.left == null && node.right == null) {
			return Integer.parseInt(node.s);
		}
		
		int left = evaluate(node.left);
		int right = evaluate(node.right);
		
		if(node.s.equals("+")) {
			return left + right;
		} else if(node.s.equals("-")) {
			return left - right;
		} else if(node.s.equals("*")) {
			return left * right;
		} else {
			return left / right;
		} 
		
	}

}
