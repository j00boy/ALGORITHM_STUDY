package boj_5639_이진검색트리;

import java.util.Scanner;

public class Main {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Node root = new Node(sc.nextInt()); // 50

		while (sc.hasNext()) {		// 이거만 코드 참고
			int num = sc.nextInt();
			if (num == 0) {
				break;
			}

			Node curr = root;	// 매 while문마다 curr값 초기화
			while (true) {
				if (num < curr.data) {	// 작을 때
					if (curr.left == null) {
						curr.left = new Node(num);
						break;
					} else {
						curr = curr.left;
					}
				} else {				// 클 때
					if (curr.right == null) {
						curr.right = new Node(num);
						break;
					} else {
						curr = curr.right;
					}
				}
			}
		}

		postorder(root);
	}

	public static void postorder(Node node) {
		if (node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		System.out.println(node.data);
	}
}