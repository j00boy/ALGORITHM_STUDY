package DoublyLinkedList_구현;

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
	
	// 첫번째에 삽입
	void addToFirst(String data) {
		Node newNode = new Node(data);
		
		newNode.next = head.next;
		head.next = newNode;
		
		size++;
	}
	
	// 마지막에 삽입
	void addToLast(String data) {
		Node newNode = new Node(data);
		
		// newNode 먼저 연결
		newNode.next = tail;
		newNode.prev = tail.prev;
		
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		
		size++;
	}
	
	// 중간에 삽입
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
	
	// 지정한 index의 데이터 삭제
	void remove(int index) {
		if(index < 0 || index > size) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		
		Node curr = head;
		for(int i = 0; i < index; i++) {
			curr = curr.next;
		}
		
		curr.next = curr.next.next;
		
		size--;
	}
	
	// 지정한 index 데이터 조회
	void print(int index) {
		if(index < 0 || index > size) {
			System.out.println("찾을 수 없는 범위입니다.");
			return;
		}
		
		Node curr = head;
		for(int i = 0; i < index; i++) {
			curr = curr.next;
		}
		
		System.out.println(curr.next.data);
	}
	
	
	// 모든 데이터 조회
	void printAll() {
		Node curr = head.next;
		while(curr != tail) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println();
	}
	
}

public class DoublyLinkedList_구현 {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.addToLast("D");
		list.addToLast("C");
		list.addToLast("B");
		list.addToLast("A");
		list.addToFirst("C");
		list.addToFirst("B");
		list.addToFirst("A");
		list.printAll();
		list.add(1, "add 삽입");
		list.printAll();
		list.remove(1);
		list.printAll();
		list.print(6);
	}

}
