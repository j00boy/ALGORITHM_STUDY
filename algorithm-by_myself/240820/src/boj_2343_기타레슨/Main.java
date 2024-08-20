package boj_2343_기타레슨;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] lecture;
	
	/*
	 * 최댓값의 최솟값
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		lecture = new int[N];
		
		for(int i = 0; i < N; i++) {
			lecture[i] = sc.nextInt();
		}
		
		int left = 1;
		int right = 1000000000;
		
		// 여기서 mid는 뭐가 되어야 하냐면, 블루레이의 최대 길이
		while(right >= left) {	// 최댓값의 최솟값을 구해야하기 때문에, right를 기준으로 left보다 크거나 같을 때 까지만
//			System.out.println("left:right = " + left + ":" + right);
			boolean error = false;	// 범위가 너무 작아서, 블루레이에 한 강의 조차도 못담을 경우를 고려
			int mid = (left + right) / 2;
			int count = 1;
			int size = mid;
			
			for(int i = 0; i < N; i++) {
				if(lecture[i] <= size) {
					size -= lecture[i];
				} else {
					count++;
					size = mid - lecture[i];
					
					if(size < 0) {
						error = true;
						break;
					}
				}
			}
			
			// 에러가 발생한거면, 너무 작아서 이기 때문에 left = mid + 1
			if(error) {
//				System.out.println("error 발생");
				left = mid + 1;
				continue;
			}
			
			// 동영상이 M보다 많으면, 허용 크기를 늘려줌
			if(count > M) {
				left = mid + 1;
			} else {	// M보다 작거나 같으면, 최댓값의 최솟값을 구하기 위해 right를 더 축소해봄
				right = mid - 1;
			}
		}
		
		// while문이 right가 left보다 작아졌을때 종료되기 때문에, 출력은 right + 1이 최솟값
		System.out.println(right + 1);
	}
}
