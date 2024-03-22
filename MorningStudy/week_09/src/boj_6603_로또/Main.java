package boj_6603_로또;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] sel = new int[6];
	static int k;

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			k = sc.nextInt();
			
			// 배열을 0 입력 전까지 계속 반복해서 받으니까 non-static으로 생성
			int[] S = new int[k];
			
			if(k == 0) {
				flag = false;
				break;
			}
			
			S = new int[k];
			
			for(int i = 0; i < k; i++) {
				S[i] = sc.nextInt();
			}
			
			Arrays.sort(S);
			
			lotto(S, 0, 0);
			System.out.println();
		}
		
	}
	
	public static void lotto(int[] arr, int idx, int count) {
		// 기저조건
		if(count == 6) {									// 6개를 다 뽑으면
			for(int i = 0; i < 6; i++) {
				System.out.print(sel[i] + " ");				// 출력
			}
			System.out.println();
			return;
		}
		
		if(idx == k) {		// 만약 6개 다 안뽑고 도착한거면 종료
			return;
		}
		
		sel[count] = arr[idx];			// 일단 해당 숫자를 넣은 경우
		lotto(arr, idx+1, count+1);		// 그 다음꺼 탐색
		
		lotto(arr, idx+1, count);		// 넣지 않은 경우
	}
}