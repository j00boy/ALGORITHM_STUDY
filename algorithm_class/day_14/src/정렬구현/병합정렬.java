package 정렬구현;

import java.util.Arrays;

public class 병합정렬 {

	static int[] arr;
	static int[] sortedArr;

	public static void main(String[] args) {

		arr = new int[] { 55, 22, 15, 67, 88, 43, 82, 91, 62, 1 };
		sortedArr = new int[arr.length];

		System.out.println("정렬 전: " + Arrays.toString(arr));
		mergeSort(0, arr.length - 1);
		System.out.println("정렬 후: " + Arrays.toString(sortedArr));

	}

	public static void mergeSort(int left, int right) {
		if(left < right) {	// 애초에 오름차순이면,
			return;			// 함수 종료
		}
		
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid); // 왼쪽
			mergeSort(mid + 1, right); // 오른쪽
			merge(left, mid, right);
		}
	}

	public static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽 구간의 시작 포인트
		int R = mid + 1; // 오른쪽 구간의 시작 포인트
		int idx = left; // 정렬된 원소들을 저장할 위치 (덮어 씌울 위치)

		// 서로 아직 비교할 수 있는 값이 남아있을 때
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				sortedArr[idx++] = arr[L++];
			} else {
				sortedArr[idx++] = arr[R++];
			}
		}

		// 왼쪽 구간만 남았음
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		}

		// 오른쪽 구간만 남았음
		else {
			for (int i = R; i <= right; i++) {
				sortedArr[idx++] = arr[i];
			}
		}

		// 마지막으로 해야 할 행위
		// 원본에 반영하기
		for (int i = left; i <= right; i++) {
			arr[i] = sortedArr[i];
		}
	}
}