package 구현;

class Node {
	int data;
	Node left;
	Node right;
	
	Node() {}
	
	Node(int data) {
		this.data = data;
	}
}

public class Tree구현 {
	
	static int[] tree;
	
	public static void main(String[] args) {
		
		tree = new int[] {1,5,8,5,2,3,4,0,0,0,9,0,2,4,5};
		
		preorder(1);
		System.out.println();
		
		inorder(1);
		System.out.println();
		
		postorder(1);
		System.out.println();
		
	}
	
	// 전위 순 -> VLR
	public static void preorder(int num) {
		// index 범위 확인 + null값은 아닌
		if(num >= tree.length || tree[num] == 0) {
			return;
		}
		
		System.out.print(tree[num] + " ");
		preorder(num * 2);
		preorder(num * 2 + 1);
	}
	
	// 중위순회 -> LVR
	public static void inorder(int num) {
		if(num >= tree.length || tree[num] == 0) {
			return;
		}
		
		inorder(num * 2);
		System.out.print(tree[num] + " ");
		inorder(num * 2 + 1);
	}
	
	// 후위순회 -> LRV
	public static void postorder(int num) {
		if(num >= tree.length || tree[num] == 0) {
			return;
		}
		
		postorder(num * 2);
		postorder(num * 2 + 1);
		System.out.print(tree[num] + " ");
	}
}
