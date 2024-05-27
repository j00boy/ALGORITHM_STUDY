package SinglyLinkedList_구현;

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
	
	// 맨 앞에 삽입
	void addToFirst(String data) {
		Node newNode = new Node(data);
		newNode.link = head.link;
		head.link = newNode;
		size++;
	}
	
	// 제일 뒤에 삽입
	void addToLast(String data) {
		Node newNode = new Node(data);
		
		Node curr = head;
		// curr이 맨 마지막으로 이동
		while(curr.link != null) {
			curr = curr.link;
		}
		
		curr.link = newNode;
		size++;
	}
	
	// 중간에 삽입
	void add(int index, String data) {
		if(index < 0 || index > size) {
			System.out.println("삽입할 수 없는 index 범위입니다.");
			return;
		}
		
		// curr이 삽입하고자 하는 위치를 가리킴
		Node curr = head;
		for(int i = 0; i < index; i++) {
			curr = curr.link;
		}
		
		Node newNode = new Node(data);
		newNode.link = curr.link;
		curr.link = newNode;
		
		size++;
	}
	
	// 지정한 index의 데이터 삭제
	void remove(int index) {
		if(index < 0 || index > size) {
			System.out.println("삭제할 수 없습니다.");
			return;
		}
		
		// curr이 삭제하고자 하는 위치를 가리킴
		Node curr = head;
		for(int i = 0; i < index; i++) {
			curr = curr.link;
		}
		
		curr.link = curr.link.link;
		
		size--;
	}
	
	// 특정 index 조회
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
		
		System.out.println(curr.link.data);
	}
	
	// 모든 데이터 조회
	void printAll() {
		Node curr = head.link;
		while(curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.link;
		}
		System.out.println();
	}
	
	// 크기 조회
	int getSize() {
		Node curr = head;
		int count = 0;
		
		while(curr.link != null) {
			curr = curr.link;
			count++;
		}
		return size;
	}
	
}



public class SinglyLinkedList_구현 {
	public static void main(String[] args) {

		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addToFirst("A");
		list.addToFirst("B");
		list.addToFirst("C");
		list.addToFirst("D");
		list.addToFirst("E");
		list.addToLast("Z");
		list.printAll();
		list.print(3);
		list.remove(3);
		list.printAll();
		list.add(2, "AB");
		list.printAll();
		System.out.println(list.getSize());
	}

}