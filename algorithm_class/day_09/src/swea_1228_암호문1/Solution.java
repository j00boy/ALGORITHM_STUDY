package swea_1228_암호문1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Node {
	int data;
	Node link;
	
	Node() {}
	
	Node(int data) {
		this.data = data;
	}
}

class LinkedList {
	Node head;
	int size;
	
	LinkedList() {
		head = new Node();
	}
	
	void add(int index, int data) {
		if(index < 0 || index > size) {
			System.out.println("값을 추가할 수 없는 범위의 index입니다.");
			return;
		}
		
		Node curr = head;
		for(int i = 0; i < index; i++) {
			curr = curr.link;
		}
		
		Node newNode = new Node(data);
		newNode.link = curr.link;
		curr.link = newNode;
		
		size++;
	}
	
	void addToLast(int data) {
		Node newNode = new Node(data);
		
		Node curr = head;
		
		while(curr.link != null) {
			curr = curr.link;
		}
		
		curr.link = newNode;

		size++;
	}
	
	void printElement(int index) {
		int num;
		if(index < 0 || index > size) {
			System.out.println("값을 찾을 수 없는 범위의 index입니다.");
			return;
		}
		Node curr = head;
		for(int i = 0; i <= index; i++) {
			curr = curr.link;
		}
		
		System.out.print(curr.data + " ");
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		
//		File file = new File("src/swea_1228_암호문1/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			
			int N = sc.nextInt();
			
			LinkedList list = new LinkedList();
			
			for(int i = 0; i < N; i++) {
				list.addToLast(sc.nextInt());
			}
			
			int M = sc.nextInt();
			
			for(int i = 0; i < M; i++) {
				String s = sc.next();
				if(s.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					for(int j = 0; j < y; j++) {
						list.add(x+j, sc.nextInt());
					}
				}
			}
			
			System.out.printf("#%d ", tc);
			for(int i = 0; i < 10; i++) {
				list.printElement(i);
			}
			System.out.println();
		}
		
	}
}