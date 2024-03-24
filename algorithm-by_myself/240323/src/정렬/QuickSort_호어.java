package 정렬;

import java.util.Arrays;

public class QuickSort_호어 {
	
	static int[] arr;
	static int[] sortedArr;
	
	public static void main(String[] args) {
		arr = new int[] {5, 22, 32, 26, 57, 19, 32, 55, 84};

		System.out.println(Arrays.toString(arr));
		
		quickSort(0, arr.length - 1);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	static void quickSort(int left, int right) {
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
			while(L <= R && arr[L] <= pivot) {
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
