package 구현연습;
import java.util.Arrays;

public class 퀵정렬 {
	
	static int[] arr;
	
	public static void main(String[] args) {
		
		arr = new int[] {1, 5, 2, 30, 9, 28, 63, 62, 5};
		
		System.out.println(Arrays.toString(arr));
		
		quickSort(0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));

	}
	
	public static void quickSort(int left, int right) {
		if(left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
	}

	static int partition(int left, int right) {
		
		int pivot = arr[left];
		
		int L = left + 1;
		int R = right;
		
		while(L <= R) {
			while(arr[L] <= pivot) {
				L++;
			}
			
			while(arr[R] > pivot) {
				R--;
			}
			
			if(L < R) {
				swap(L, R);
			}
		}
		
		swap(left, R);
		
		return R;
	}
	
	public static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
