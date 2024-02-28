package DoublyLinkedList구현;

class Node {
	String data;
	Node prev;
	Node next;
	
	Node() {}
	
	Node(String data) {
		this.data = data;
	}
}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;
	
	DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	void addToFirst(String data) {
		Node newNode = new Node(data);
		
		newNode.next = head.next;
		newNode.prev = head;
		
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		
		size++;
	}
	
	void addToLast(String data) {
		Node newNode = new Node(data);
		
		newNode.next = tail;
		newNode.prev = tail.prev;

		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		
		size++;
	}
	
	void add(int index, String data) {
		Node newNode = new Node(data);
		
		if(index < 0 || index > size) {
			System.out.println("삽입할 수 없는 위치입니다.");
			return;
		}
		
		Node curr = head;
		
		for(int i = 0; i < index; i++) {
			curr = curr.next;
		}
		
		newNode.next = curr.next;
		curr.next = newNode;
		
		size++;
	}
	
	void remove(int index) {
		if(index < 0 || index > size) {
			System.out.println("참조할 수 없는 index 범위입니다.");
			return;
		}
		Node curr = head;
		
		for(int i = 0; i < index; i++) {
			curr = curr.next;
		}
		
		curr.next = curr.next.next;
		
		size--;
	}
	
	void print(int index) {
		if(index < 0 || index > size) {
			System.out.println("참조할 수 없는 index 범위입니다.");
			return;
		}
		
		Node curr = head;
		
		for(int i = 0; i < index; i++) {
			curr = curr.next;
		}
		
		System.out.println(curr.next.data);
	}
	
	void printAll() {
		Node curr = head.next;
		while(curr != tail) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println();
	}
	
}

public class DoublyLinkedList구현 {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addToFirst("aa");
		list.addToLast("3");
		list.addToLast("2");
		list.addToLast("1");
		list.addToLast("4");
		list.printAll();
		list.add(2, "bb");
		list.printAll();
		list.remove(1);
		list.printAll();
		list.print(5);
	}
}