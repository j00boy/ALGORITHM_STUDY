package 정렬;

import java.util.Arrays;

public class 병합정렬 {
	
	static int[] arr;
	static int[] sortedArr;
	
	public static void main(String[] args) {
		arr = new int[] {2, 56, 6, 6, 23, 87, 42, 86, 4};
		sortedArr = new int[arr.length];
		
		mergeSort(0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	// 분할 과정
	static void mergeSort(int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	// 병합 과정
	static void merge(int left, int mid, int right) {
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
		
		// 원본에 반영하기
		for(int i = 0; i <= right; i++) {
			arr[i] = sortedArr[i];
		}
	}
}
