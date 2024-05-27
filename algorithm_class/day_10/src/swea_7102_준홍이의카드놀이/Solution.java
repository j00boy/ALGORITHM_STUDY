package swea_7102_준홍이의카드놀이;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Node {
	int num;
	int count;
	Node left;
	Node right;

	Node() {
	}

	Node(int num) {
		this.num = num;
	}
}

public class Solution {

	static Node[] results;
	static Node[] N_nodes;
	static Node[] M_nodes;

	public static void main(String[] args) throws IOException {

//		File file = new File("src/swea_7102_준홍이의카드놀이/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			results = new Node[N + M + 1];
			N_nodes = new Node[N + 1];
			M_nodes = new Node[M + 1];

			for (int i = 1; i < N + M + 1; i++) {
				results[i] = new Node(i);
			}

			for (int i = 1; i < N + 1; i++) {
				N_nodes[i] = new Node(i);
			}

			for (int i = 1; i < M + 1; i++) {
				M_nodes[i] = new Node(i);
			}

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < M + 1; j++) {
					if (N_nodes[i].num + M_nodes[j].num == results[i + j].num) {
						Node lft = new Node(i);
						lft.left = results[i+j].left;
						results[i+j].left = lft;
					}
				}
			}

			int maxCnt = Integer.MIN_VALUE;
			for (int i = 1; i < results.length; i++) {

				if(results[i].left == null) {
					continue;
				}
				
				Node curr = results[i];
				
				while (curr.left != null) {
					curr = curr.left;
					results[i].count++;
				}
				
				if (results[i].count > maxCnt) {
					maxCnt = results[i].count;
				}
			}



			String ans = "";
			for (int i = 1; i < N + M + 1; i++) {
				if (results[i].count == maxCnt) {
					ans += results[i].num + " ";
				}
			}

			System.out.printf("#%d %s\n", tc, ans);

		}
		// test case
	}

}