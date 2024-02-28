package SinglyLinkedList;

class Node {
	String data;
	Node link;
	
	Node() {}
	
	Node(String data) {
		this.data = data;
	}
}

class SinglyLinkedList {
	Node head;
	int size;
	
	SinglyLinkedList() {
		head = new Node();
	}
	
	void addFirst(String data) {
		Node newNode = new Node(data);
		newNode.link = head.link;
	}
}

public class LinkedList {

}
