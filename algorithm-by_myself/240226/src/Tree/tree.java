package Tree;

public class tree {

	static char[] tree = new char[] { '\0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 0, 0, 'H', 'I' };
	
	public static void main(String[] args) {

	}
	
	static void preorder(int i) {
		if(i >= tree.length || tree[i] == 0) {
			return;
		}
		
		System.out.print(tree[i] + " ");
		preorder(i * 2);
		preorder(i * 2 + 1);
	}
	
	static void inorder(int i) {
		if(i >= tree.length || tree[i] == 0) {
			return;
		}
		
		inorder(i * 2);
		System.out.print(tree[i] + " ");
		inorder(i * 2 + 1);
	}
	
	static void postorder(int i) {
		if(i >= tree.length || tree[i] == 0) {
			return;
		}
		
		postorder(i * 2);
		postorder(i * 2 + 1);
		System.out.print(tree[i] + " ");
	}

}