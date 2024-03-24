package 탐색;

import java.util.Arrays;

public class 이진탐색_재귀함수 {
	
	static int[] arr;
	static int key;
	
	public static void main(String[] args) {
		
		arr = new int[] {1, 5, 6, 77, 3, 123, 73, 8};
		
		
		key = 123;
		
		int end = arr.length - 1;
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.binarySearch(arr, 6));	// index를 반환해줌
		
		/* 
		 * 꼭 정렬된 상태이어야 함
		 * left와 right는 모두 배열의 양쪽 끝 index 기준
		 */
		System.out.println(binarySearch(0, end));			// 포함 여부를 반환해 줌

	}
	
	static boolean binarySearch(int left, int right) {
		if(left > right) {
			return false;
		}
		
		int mid = (left + right) / 2;
		
		if(arr[mid] == key) {
			return true;
		} else if(arr[mid] > key) {
			return binarySearch(left, mid - 1);
		} else {
			return binarySearch(mid + 1, right);
		}
		
	}
}
