package swea_1966_숫자를정렬하자;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
//		File file = new File("src/swea_1966_숫자를정렬하자/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case 시작
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int[] nums = new int[N];
			
			for(int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			selectionSort(nums);
			
			String ans = "";
			for(int i = 0; i < N; i++) {
				ans += nums[i] + " ";
			}
			
			System.out.printf("#%d %s\n", tc, ans);
		}
		// test case 끝
	}
	
	public static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length -1; i++) {
			int minIdx = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
	}
}