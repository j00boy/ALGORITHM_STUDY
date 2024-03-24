package 정렬;

import java.util.Arrays;

public class QuickSort_로무토 {
	
	static int[] arr;
	static int[] sortedArr;
	
	public static void main(String[] args) {
		arr = new int[] {5, 22, 32, 26, 57, 19, 32, 55, 84};

		System.out.println(Arrays.toString(arr));
		
		quickSort(0, arr.length - 1);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void quickSort(int left, int right) {
		if(left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}
	
	public static int partition(int left, int right) {
		int pivot = arr[right];
		int i = left - 1;
		
		for(int j = left; j < right; j++) {
			if(arr[j] <= pivot) {
				i++;
				swap(i, j);
			}
		}
		
		swap(i+1, right);
		
		return i+1;
	}
	
	public static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
