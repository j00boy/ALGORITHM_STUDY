package boj_1253_좋다;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static long[] arr;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		arr = new long[size];
		count = 0;
		
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextLong();
		}
		
		/*
		 *  이분탐색 쉽게 하려고 정렬했으나, 사실 내껀 이분탐색은 아님
		 *  - 이분탐색 시간복잡도 : log N
		 *  - 투포인터 시각복잡도 : N
		 *  : 이분탐색으로도 풀려면 풀 수 있을 것 같긴 하나 구체적으로 떠오르진 않음
		 */
		
		Arrays.sort(arr);

		for(int i = 0; i < size; i++) {
			
			int left = 0;
			int right = size - 1;
			
			/*
			 * 처음에는 left = 0, right = i-1 이라고만 생각했었다. 왜냐면 크기순으로 정렬했기 때문에.
			 * 근데 만약에 내 뒤에 있는 숫자도 나보다 같다고 한다면 예외가 발생함 -> 3% 에서 67%로 진화
			 */
			
			while(left < right) {
				
				long sum = arr[left] + arr[right];
				
				if(sum == arr[i]) {
					
					/*
					 * "수의 위치가 다르면 값이 같아도 다른 수이다." 라는 조건을 되게 가볍게 여김
					 * 내 자신이 나의 합에 포함이 되면 안됨. 포함될 수 있는 이유는 0이거나 음수가 섞여있는 경우가 있음
					 * 그래서 각 포인터가 '나(arr[i])'를 포함하고 있다면 left는 ++, right은 --를 해주고 count를 올리지 말아야 함
					 */
					
					if(left != i && right != i) {
						count++;
						break;						
					} else if(left == i) {
						left++;
					} else if(right == i) {
						right--;
					}
				} else if(sum < arr[i]) {
					left++;
				} else {
					right--;
				}
					
			}
		}
		
		System.out.println(count);
		
	}
}