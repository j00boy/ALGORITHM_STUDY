package swea_2063_중간값찾기;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		
//		File file = new File("src/swea_2063_중간값찾기/input.txt");
//		Scanner sc = new Scanner(file);
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 오름차순으로 정렬
		arr = sort(arr);
		
		// 중앙 index 찾기
		int middle = arr.length / 2;
		
		// 값 출력
		System.out.println(arr[middle]);
	}
	
	// selection sort
	// 가장 작은 값을 찾아 왼쪽부터 정렬
	public static int[] sort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int minIdx = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[minIdx]) {
					minIdx = j;
				}
				int temp = arr[i];
				arr[i] = arr[minIdx];
				arr[minIdx] = temp;
			}
		}
		return arr;
	}

}
