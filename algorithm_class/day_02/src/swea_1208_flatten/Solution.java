package swea_1208_flatten;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File("src/swea_1208_flatten/input.txt");
//		Scanner sc = new Scanner(file);
		
		Scanner sc = new Scanner(System.in);

		int T = 10;

		// TestCase 시작
		for (int testCase = 1; testCase <= 10; testCase++) {
			int dump_N = sc.nextInt();

			int[] arr = new int[100];

			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}
			
			arr = sort(arr);
			
			for(int dump = 0; dump < dump_N; dump++) {
				arr[99]--;
				arr[0]++;
				arr = sort(arr);
			}
			
			int gap = arr[99]-arr[0];
			
			System.out.printf("#%d %d\n", testCase, gap);
			
			

			
		}
		// TestCase 끝
	}
	
	public static int[] sort(int[] arr) {
		// counting sort
		int max = 101;
		int[] counts = new int[max];
		
		// 빈도수 배열 만들기
		for(int i = 0; i < 100; i++) {
			counts[arr[i]]++;
		}
		
		// 누적합으로 만들기
		for(int i = 1; i < counts.length; i++) {
			counts[i] += counts[i-1];
		}
		
		// 배열 정렬
		int[] newArr = new int[max];
		for(int i = 99; i >= 0; i--) {
			newArr[--counts[arr[i]]] = arr[i];
		}
		
		return newArr;
	}

}
