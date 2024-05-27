package 수업내용_복습;

public class Heap_복습 {

	static int[] heap = new int[10001];
	static int heapSize = 0;
	
	public static void main(String[] args) {

	}
	
	public static void swap(int n1, int n2) {
		int tmp = heap[n1];
		heap[n1] = heap[n2];
		heap[n2] = tmp;
	}
	
	static void heapPush(int data) {
		heap[++heapSize] = data;	// heap 배열 내 유효한 데이터 범위의 맨 끝에 데이터 추가
		
		int child = heapSize;		// 이게 지금 추가된 데이터의 위치
		int parent = heapSize / 2;	// 현재 추가된 데이터 위치에서의 부모 노드
		
		//
		// heap[parent] < heap[child] 는 최대 힙인 경우를 위해,
		// parent = 1이 되면 멈춤
		// parent가 child보다 크면 멈충
		while(parent > 0 && heap[parent] < heap[child]) {
			
			int tmp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = tmp;
			
			child = parent;
			parent = child / 2;
			
		}
	}
	
	static int heapPop() {
		
		// heapPush때문에 정렬이 알아서 되어 있으니까 root값이 최대값
		int popItem = heap[1];
		
		// root값을 삭제 -> heapSize는 줄어듦
		// 마지막에 있는 원소를 루트로 불러옴
		heap[1] = heap[heapSize--];
		
		int parent = 1;
		int child = parent * 2;
		
		// 자식과 자식 비교 => 둘 중 더 큰 자식으로 방향이 가기 위해서 둘을 비교하는 것임
		if(child + 1 <= heapSize && heap[child] < heap[child + 1]) {
			child++;		// 오른쪽이 더 크다면 방향을 바꾼다.
		}
		
		while (child <= heapSize && heap[parent] < heap[child]) {
			int tmp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = tmp;
			
			parent = child;
			child = parent * 2;
			
			// 오른쪽꺼가 더 크다면, 오른쪽에 달림
			if(child + 1 <= heapSize && heap[child] < heap[child+1]) {
				child++;
			}
		}
		
		return popItem;
		
	}

}