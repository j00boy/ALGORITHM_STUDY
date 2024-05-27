package swea_1204_최빈수구하기;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {

//		File file = new File("src/swea_1204_최빈수구하기/input.txt");
//		Scanner sc = new Scanner(file);
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case 시작
		for(int testCase = 1; testCase <= T; testCase++) {
			int series = sc.nextInt(); 
			int[] students = new int[1000];
			
			for(int i = 0; i < 1000; i++) {
				students[i] = sc.nextInt();
			}
			
			// 최빈수 배열 생성 및 초기화
			int[] counts = new int[101];
			for(int j = 0; j < 1000; j++) {
				counts[students[j]]++;
			}

			// 최빈값 구하기 : 가장 많이 반복된 숫자의 갯수
			int maxFreq = Integer.MIN_VALUE;
			for(int j = 0; j < 101; j++) {
				if(counts[j] > maxFreq) {
					maxFreq = counts[j];
				}
			}
			
			// counting sort
//			students = sort(students);	// 오름차순으로 정렬
			int maxNum = 0;
			
			for(int j = 100; j >= 0; j--) {
				if(counts[j] == maxFreq) {	// J
					maxNum = j;
					break;
				}
			}
			
			System.out.printf("#%d %d\n", testCase, maxNum);
		}
		// test case 끝
	}
	
	// counting sort 함수 생성
//	public static int[] sort(int[] arr) {
//		
//		// 카운팅 배열 생성
//		int max = 101;
//		int[] counts = new int[max];
//		
//		// 카운팅 배열에 값 넣기
//		for(int i = 0; i < arr.length; i++) {
//			counts[arr[i]]++;
//		}
//		
//		// 누적합 배열로 만들기
//		for(int i = 1; i < counts.length; i++) {
//			counts[i] += counts[i-1];
//		}
//		
//		// sorting
//		int[] newArr = new int[arr.length];
//		for(int i = arr.length - 1; i >= 0; i--) {
//			newArr[--counts[arr[i]]] = arr[i];
//		}
//		
//		return newArr;
//	}

}
