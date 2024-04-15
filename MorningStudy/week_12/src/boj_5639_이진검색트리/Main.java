package boj_5639_이진검색트리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static ArrayList<Node> tree;

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

		tree = new ArrayList<>();

		while (sc.hasNext()) {

			int num = sc.nextInt();

			if (num == 0) {
				break;
			}

			if (tree.isEmpty()) {
				tree.add(new Node(num));
			} else if (num < tree.get(tree.size() - 1).data) {
				Node node = new Node(num);
				tree.add(node);
				tree.get(tree.size() - 1).left = node;
			} else {
				boolean flag = true;
				for (int i = tree.size() - 1; i >= 0; i--) {
					if (tree.get(i).data > num) {
						flag = false;
						Node node = new Node(num);
						tree.add(node);
						tree.get(i).right = node;
						break;
					}
				}

				if(flag) {
					Node node = new Node(num);
					tree.add(node);
					tree.get(0).right = node;
				}
			}
		}

		postorder(tree.get(0));
//		System.out.println(tree.get(0).right.data);
//		for (int i = 0; i < tree.size(); i++) {
//			System.out.println(tree.get(i).data);
//		}

	}

	// 전위 순회 : VLR

	// 후위 순회 : LRV
	public static void postorder(Node node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.data);
		}
	}
}