package 구현연습;
import java.util.Arrays;

public class 병합정렬 {

	static int[] arr;
	static int[] sortedArr;

	public static void main(String[] args) {

		arr = new int[] { 1, 5, 2, 30, 9, 28, 63, 62, 5 };
		sortedArr = new int[arr.length];

		System.out.println(Arrays.toString(arr));

		mergeSort(0, arr.length - 1);

		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;

		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				sortedArr[idx++] = arr[L++];
			} else {
				sortedArr[idx++] = arr[R++];
			}
		}

		if(L <= mid) {
			for(int i = L; i <= mid; i++) {
				sortedArr[idx++] = arr[L++];
			}
		} else {
			for(int i = R; i <= right; i++) {
				sortedArr[idx++] = arr[R++];
			}
		}
		
		for(int i = 0; i <= right; i++) {
			arr[i] = sortedArr[i];
		}
	}
}
