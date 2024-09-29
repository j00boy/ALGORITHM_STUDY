package boj_14725_개미굴;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	static int N;
	static int K;
	
	static class Node {
		Node parent;
		TreeMap<String, Node> child;
		int depth;
		
		Node(Node parent, int depth) {
			this.parent = parent;
			this.child = new TreeMap<>();
			this.depth = depth;
		}
		
		Node() {}
	}
	
	static class Trie {
		Node root;
		
		Trie() {
			this.root = new Node(new Node(), 0);
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		Trie trie = new Trie();
		N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			K = sc.nextInt();
			
			Node curr = trie.root;
			
			for(int j = 0; j < K; j++) {
				String word = sc.next();
				if(!curr.child.containsKey(word)) {
					curr.child.put(word, new Node(curr, j));
				}
				
				curr = curr.child.get(word);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Node curr = trie.root;
		String word;
		
		while(true) {
			if(!curr.child.isEmpty()) {
				word = curr.child.firstKey();
//				sb.repeat("--", curr.child.get(word).depth).append(word).append("\n");
				int dep = curr.child.get(word).depth;
				if(dep > 0) {
					for(int i = 0; i < dep; i++) {
						sb.append("--");
					}
				}
				sb.append(word).append("\n");
				curr = curr.child.get(word);
				curr.parent.child.remove(word);
			} else {
				curr = curr.parent;
				if(curr.parent == null) {
					break;
				}
			}
		}
		
		System.out.println(sb);
	}
}
