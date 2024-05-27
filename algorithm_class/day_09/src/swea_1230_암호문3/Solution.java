package swea_1230_암호문3;

import java.io.File;
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
	Scanner sc = new Scanner(System.in);
	Node head;
	int size;
	
	LinkedList() {
		head = new Node();
	}
	
	void addToLast(int data) {
		Node newNode = new Node(data);
		
		Node curr = head;
		while(curr.link != null) {
			curr = curr.link;
		}
		
		newNode.link = curr.link;
		curr.link = newNode;
		
		size++;
	}
	
	void add(int index, int data) {
		if(index < 0 || index > size) {
			System.out.println("값을 추가할 수 없는 index 입니다.");
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
	
	void delete(int index) {
		if(index < 0 || index > size) {
			System.out.println("값을 삭제할 수 없는 index 입니다.");
			return;
		}
		
		Node curr = head;
		for(int i = 0; i < index; i++) {
			curr = curr.link;
		}
		
		curr.link = curr.link.link;
		
		size--;
	}
	
	void print(int index) {
		if(index < 0 || index > size) {
			System.out.println("찾을 수 없는 범위입니다.");
			return ;
		}
		
		Node curr = head;
		// curr이 찾고자 하는 위치를 가리킴
		for(int i = 0; i < index; i++) {
			curr = curr.link;
		}
		
		System.out.print(curr.link.data + " ");
	}
	
}

public class Solution {
	public static void main(String[] args) throws IOException {
		
//		File file = new File("src/swea_1230_암호문3/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();	// 원본 암호문 뭉치 속 암호문의 개수
			LinkedList list = new LinkedList();
			
			for(int i = 0; i < N; i++) {
				list.addToLast(sc.nextInt());
			}
			
			int M = sc.nextInt();
			for(int i = 0; i < M; i++) {
				String s = sc.next();
				switch(s) {
					case "I":
						int x = sc.nextInt();
						int y = sc.nextInt();
						
						for(int j = 0; j < y; j++) {
							list.add(x+j, sc.nextInt());
						}
						break;
					case "D":
						x = sc.nextInt();
						y = sc.nextInt();
						
						for(int j = 0; j < y; j++) {
							list.delete(x);
						}
						break;
					case "A":
						y = sc.nextInt();
						for(int j = 0; j < y; j++) {
							list.addToLast(sc.nextInt());
						}
						break;
				}
			}
			
			System.out.printf("#%d ", tc);
			for(int i = 0; i < 10; i++) {
				list.print(i);
			}
			System.out.println();
			
		}
		
	}
	
}