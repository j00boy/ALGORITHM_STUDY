package boj_16934_게임닉네임;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	static StringBuilder sb;
	static int N;
	
	static class Node {
		HashMap<Character, Node> child;
		boolean endOfWord;
		
		public Node() {
			this.child = new HashMap<>();
			this.endOfWord = false;
		}
	}
	
	static class Trie {
		Node root;
		
		public Trie() {
			this.root = new Node();
		}
		
		public void insert(String str) {
			Node node = this.root;
			boolean flag = true;
			
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if(flag) {
					sb.append(c);
				}
				
				if(!node.child.containsKey(c)) {
					node.child.put(c, new Node());
					flag = false;
				}
				
				node = node.child.get(c);
			}
			
			if(node.endOfWord) {
				node = node.child.get('=');
				char ch = '1';
				while(node.child.containsKey(ch)) {
					ch += 1;
				}
				sb.append(ch-'0').append('\n');
				node.child.put(ch, new Node());
				
			} else {
				node.endOfWord = true;
				node.child.put('=', new Node());
				node = node.child.get('=');
				node.child.put('1', new Node());
				sb.append('\n');
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Trie trie = new Trie();
		sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			
			trie.insert(str);
		}
		
		System.out.println(sb);
	}
}
