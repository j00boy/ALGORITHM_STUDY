package boj_2805_나무자르기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// selectionsort 구현했으나 시간초과..
		Arrays.sort(arr);

		/*
		 *  처음에 min값을 arr[0]으로 두고 풀었는데
		 *  36%에서 계속 틀려서 생각해 보니
		 *  초기 M값이 너무 커서 기존 배열의 최솟값보다 작은 값으로 잘라야 함
		 *  반면, max값은 오름차순으로 정렬한 값의 끝 값이 최대일 수 밖에 없음
		 */
		int min = 0;
		int max = arr[arr.length - 1];
		
		// min이 max보다 커질 때까지 무한 반복
		while (min <= max) {
			int median = (min + max) / 2;					// 중앙값: (최소값 + 최대값) / 2
			
			long branchesSum = 0;							// 나무 가져가는 수
			for (int i = 0; i <= arr.length-1; i++) {		// 배열 내에서
				if (arr[i] - median >= 0) {					// 중앙값보다 큰 나무들만 자름
					branchesSum += arr[i] - median;
				}
			}
			
			// 이진 탐색 시작
			if(branchesSum >= M) {							// 가져가는 나무가 M보다 크면, 가져가는 나무 수 줄여주기
				min = median + 1;							// min의 값을 중앙값+1로 갱신	-> 오른쪽 탐색
			} else {										// 가져가는 나무가 M보다 작다면, 가져가는 나무 수 늘려주기
				max = median - 1;							// max의 값을 중앙값 - 1	-> 왼쪽 탐색
			}
		}
		
		/*
		 *  결과값을 min - 1 해주는 이유는
		 *  while문이 min > max가 되면 종료됨
		 *  
		 *  min은 가져가는 나무의 합이 M보다 커서 발생한 조건임
		 *  나무의 합이 M보다 크면, 오른쪽 탐색 -> 가져가는 나무의 수를 줄여줘야 함
		 *  
		 *  나무의 합이 M보다 작아서 가져가는 나무의 수를 늘려줘야 하는 max와 min이 충돌하는 시점에 종료됨
		 *  
		 *  min = median + 1 이므로
		 *  해당 높이에서는 나무를 잘라주지 않아도 됨
		 *  따라서 while문의 조건에 부합해야 하므로
		 *  min - 1
		 */
		
		System.out.println(min - 1);
		
		
	}

}