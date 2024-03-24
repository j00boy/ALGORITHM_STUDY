package 정렬;

import java.util.Arrays;

public class QuickSort_Hoare {
	
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
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		return R;
	}
}
