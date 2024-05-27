package swea_14229_백만개의정수정렬;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	static int[] arr = new int[1000000];
	
	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File("src/swea_14229_백만개의정수정렬/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		QuickSort(0, arr.length-1);
		
		System.out.println(arr[500000]);
	}
	
	static void QuickSort(int left, int right) {
		if(left < right) {
			int pivot = Hoare_partition(left, right);
			QuickSort(left, pivot-1);
			QuickSort(pivot+1, right);
		}
	}

	static int Hoare_partition(int left, int right) {
		int pivot = arr[left];
		int L = left + 1;
		int R = right;
		
		while(L <= R) {
			while(L <= R && arr[L] <= pivot) {
				L++;
			}
			
			while(arr[R] > pivot) {
				R--;
			}
			
			if(L < R) {
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