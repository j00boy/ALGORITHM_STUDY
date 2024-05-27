package 정렬구현;

import java.util.Arrays;

public class 퀵정렬_Hoare {

	static int[] arr;

	public static void main(String[] args) {
		arr = new int[] { 1, 3, 6, 63, 67, 16, 97, 86, 53, 74, 99 };
		quickSort(0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int left, int right) {
		if (left >= right) {
			return;
		}

		if (left < right) {
			int pivot = Hoare_partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
	}

	static int Hoare_partition(int left, int right) {
		int pivot = arr[left];

		int L = left + 1;
		int R = right;

		while (L <= R) {
			while (arr[R] > pivot) {
				R--;
			}

			while (L <= R && arr[L] <= pivot) {
				L++;
			}

			if (L < R) {
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
