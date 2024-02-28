package Tree_Heap구현;

import java.util.Arrays;

public class Heap구현 {
	
	static int heap[] = new int[100];
	static int heapSize;
	
	public static void main(String[] args) {
		
		heapPush(55);
		heapPush(56);
		heapPush(54);
		heapPush(32);
		heapPush(1);
		heapPush(11);

		System.out.println(Arrays.toString(heap));

		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
	}
	
	static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
	
	// 삽입
	// 항상 부모랑만 비교하기 때문에, 자기 자신에 대한 고려는 필요 X
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
