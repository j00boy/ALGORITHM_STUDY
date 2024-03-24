package 탐색;

public class 이진탐색_반복문 {
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 6, 77, 3, 123, 73,8};
		
		System.out.println(binarySearch(arr, 7));
	}
	
	static boolean binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(arr[mid] == key) {
				return true;
			} else if (arr[mid] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return false;
	}
}
