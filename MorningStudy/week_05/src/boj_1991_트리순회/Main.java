package boj_1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char ch;
	Node left;
	Node right;

	Node() {
	}

	Node(char ch) {
		this.ch = ch;
	}
}

public class Main {

	static Node[] nodes;
	static int root;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		nodes = new Node[27];
		root = 1; // root = 1
		char[][] inputs = new char[27][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			inputs[i][0] = st.nextToken().charAt(0);
			inputs[i][1] = st.nextToken().charAt(0);
			inputs[i][2] = st.nextToken().charAt(0);

		}

		for (int i = 1; i <= N; i++) {
			if (nodes[inputs[i][0] - '@'] == null) { // nodes[i]가 비어 있으면
				nodes[inputs[i][0] - '@'] = new Node(inputs[i][0]); // 새로운 노드 생성
			} // 입력값에서 이미 left, right 선언 과정에서 생성되었을 수도 있기에 추가한 조건

			if (inputs[i][1] != '.') { // '.'이 아니라면
				if (nodes[inputs[i][1] - '@'] == null) {				// left에 해당하는 노드가 기존에 없다면
					nodes[inputs[i][1] - '@'] = new Node(inputs[i][1]); // 해당 nodes의 index에 새로운 노드 생성
				}
				nodes[inputs[i][0] - '@'].left = nodes[inputs[i][1] - '@'];	// 연결
			}

			if (inputs[i][2] != '.') {
				if (nodes[inputs[i][2] - '@'] == null) {
					nodes[inputs[i][2] - '@'] = new Node(inputs[i][2]);
				}
				nodes[inputs[i][0] - '@'].right = nodes[inputs[i][2] - '@'];
			}

		}

		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);

	}

	// 전위 순회
	// VLR

	public static void preorder(int idx) {
		if (idx >= nodes.length || nodes[idx] == null) {
			return;
		}

		// VLR
		System.out.print(nodes[idx].ch);
		preorder(idx * 2);
		preorder(idx * 2 + 1);
	}

	// 중위 순회
	// LVR
	public static void inorder(int idx) {
		if (idx >= nodes.length || nodes[idx] == null) {
			return;
		}

		// LVR
		inorder(idx * 2);
		System.out.print(nodes[idx].ch);
		inorder(idx * 2 + 1);
	}

	// 후위 순회
	// LRV
	public static void postorder(int idx) {
		if (idx >= nodes.length || nodes[idx] == null) {
			return;
		}

		// LRV
		postorder(idx * 2);
		postorder(idx * 2 + 1);
		System.out.print(nodes[idx].ch);
	}

}