package boj_1991_트리순회;

import java.util.Scanner;

public class Main {

	static class Node {
		char ch;
		Node left;
		Node right;

		public Node(char ch) {
			this.ch = ch;
		}

		public Node(char ch, Node left, Node right) {
			this.left = left;
			this.right = right;
		}

	}

	static int N;
	static char[][] adj = new char[26][3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		for(int i = 0; i < 26; i++) {
			adj[i][0] = (char) (i + 'A');
		}

		for (int i = 0; i < N; i++) {
			char parent = sc.next().charAt(0);
			char L = sc.next().charAt(0);
			char R = sc.next().charAt(0);

			if (L != '.') {
				adj[parent - 'A'][1] = L;
			}
			if (R != '.') {
				adj[parent - 'A'][2] = R;
			}
		}

		for(int r = 0; r < 26; r++) {
			for(int c = 0; c < 3; c++) {
				System.out.print(adj[r][c] + " ");
			}
			System.out.println();
		}

	}

	// VLR
	public static void preorder(int idx) {

	}

	// LVR
	public static void inorder(int root) {

	}

	// LRV
	public static void poserorder(int root) {

	}
}
