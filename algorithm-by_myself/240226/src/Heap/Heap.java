package Heap;

public class Heap {
	
	static int[] heap = new int[100];
	static int heapSize;
	
	public static void main(String[] args) {
		
	}
	
	static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
	
	static void heapPush(int data) {
		heap[++heapSize] = data;
		
		int child = heapSize;
		int parent = heapSize / 2;
		
		while(parent > 0 && heap[parent] < heap[child]) {
			swap(parent, child);
			
			child = parent;
			parent = child / 2;
		}
	}
	
	static int heapPop() {
		int popItem = heap[1];
		
		heap[1] = heap[heapSize--];
		
		int parent = 1;
		int child = parent * 2;
		
		if(child + 1 <= heapSize && heap[child] < heap[child + 1]) {
			child++;
		}
		
		while(child <= heapSize && heap[parent] < heap[child]) {
			swap(parent, child);
			
			parent = child;
			child = parent * 2;
			
			if(child + 1 <= heapSize && heap[child] < heap[child + 1]) {
				child++;
			}
		}
		
		return popItem;
	}
}