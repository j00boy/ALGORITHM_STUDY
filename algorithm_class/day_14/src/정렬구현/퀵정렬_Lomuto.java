package 정렬구현;

import java.util.Arrays;

public class 퀵정렬_Lomuto {

	static int[] arr;

	public static void main(String[] args) {

		arr = new int[] { 3, 6, 8, 9, 37, 23, 36, 89, 50, 98 };
		quickSort(0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int left, int right) {
		if(left >= right) {
			return;
		}
		
		if(left < right) {
			int pivot = Lomuto_partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}

	static int Lomuto_partition(int left, int right) {
		// 로무토 파티션은 오른쪽부터 
		int pivot = arr[right];
		int i = left - 1;
		
		for(int j = left; j < right; j++) {
			if(arr[j] <= pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
		int tmp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] = tmp;
		
		return i+1;
	}
}
