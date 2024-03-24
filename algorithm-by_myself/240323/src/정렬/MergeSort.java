package 정렬;

import java.util.Arrays;

public class MergeSort {
	
	static int[] arr;
	static int[] sortedArr;
	
	public static void main(String[] args) {
		arr = new int[] {5, 22, 32, 26, 57, 19, 32, 55, 84};
		sortedArr = new int[arr.length];
		
		System.out.println("Before Merge Sort: " + Arrays.toString(arr));
		mergeSort(0, arr.length-1);
		System.out.println("After Merge Sort: " + Arrays.toString(arr));
	}
	
	public static void mergeSort(int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	public static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;
		
		while(L <= mid && R <= right) {
			if(arr[L] <= arr[R]) {
				sortedArr[idx++] = arr[L++];
			} else {
				sortedArr[idx++] = arr[R++];
			}
		}
		
		if(L <= mid) {
			for(int i = L; i <= mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		} else {
			for(int i = R; i <= right; i++) {
				sortedArr[idx++] = arr[i];
			}
		}
		
		for(int i = left; i <= right; i++) {
			arr[i] = sortedArr[i];
		}
	}
	
}
