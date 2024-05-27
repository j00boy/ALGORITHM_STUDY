package swea_1231_중위순회;

import java.io.File;
import java.io.IOException;
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
	static String ans;

	public static void main(String[] args) throws IOException {

//		File file = new File("src/swea_1231_중위순회/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);

		// test case 시작
		for (int tc = 1; tc <= 10; tc++) {
			// 총 노드 갯수
			int N = sc.nextInt();
			sc.nextLine();

			// 노드를 담을 tree 생성
			tree = new Node[N + 1];

			for (int i = 0; i < N + 1; i++) {
				tree[i] = new Node();
			}

			for (int i = 1; i <= N; i++) {
				String str = sc.nextLine();
				String[] strArr = str.split(" ");

				if (strArr.length == 2) {
					int num = Integer.parseInt(strArr[0]);
					String s = strArr[1];

					tree[num].s = s;

				} else if (strArr.length == 3) {
					int num = Integer.parseInt(strArr[0]);
					String s = strArr[1];
					int lft = Integer.parseInt(strArr[2]);

					tree[num].s = s;
					tree[num].left = tree[lft];

				} else {
					int num = Integer.parseInt(strArr[0]);
					String s = strArr[1];
					int lft = Integer.parseInt(strArr[2]);
					int rgt = Integer.parseInt(strArr[3]);

					tree[num].s = s;
					tree[num].left = tree[lft];
					tree[num].right = tree[rgt];
				}
			}

			ans = "";
			inorder(1);
			System.out.printf("#%d %s\n", tc, ans);

		}
		// test case 끝
	}

	static void inorder(int index) {
		if (index >= tree.length || tree[index] == null) {
			return;
		}

		// LVR
		inorder(index * 2);
		ans += tree[index].s;
		inorder(index * 2 + 1);
	}

}