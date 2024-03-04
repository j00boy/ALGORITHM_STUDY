package BOJ_1431_시리얼번호;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] serial = new String[N];

		for (int i = 0; i < N; i++) {
			serial[i] = sc.next();
		}

		// 1. 짧은 순서대로 정렬
		for (int i = 0; i < serial.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < serial.length; j++) {
				if (serial[j].length() < serial[minIdx].length()) {
					minIdx = j;
				}
			}
			String tmp = serial[i];
			serial[i] = serial[minIdx];
			serial[minIdx] = tmp;
		}

		// 2. 서로 숫자만 더해서 작은 합을 구하는 것이 먼저 온다.
		for (int i = 0; i < serial.length - 1; i++) {
			int minIdx = i;
			// serial[minIdx]의 수 더하기
			int sum = 0;
			for(int n = 0; n < serial[minIdx].length(); n++) {
				if(serial[minIdx].charAt(n) >= '0' && serial[minIdx].charAt(n) <= '9') {
					sum += serial[minIdx].charAt(n) - '0';
				}
			}
			// serial[minIdx] 더하기 끝
			
			// 같은 길이의 숫자 중에서 '숫자'의 합이 작은 것을 앞으로
			for(int j = i + 1; j < serial.length; j++) {
				int psum = 0;
				if(serial[minIdx].length() == serial[j].length()) {
					for(int k = 0; k < serial[j].length(); k++) {
						if(serial[j].charAt(k) >= '0' && serial[j].charAt(k) <= '9') {
							psum += serial[j].charAt(k) - '0';
						}
					}
				}
				if(sum > psum) {
					minIdx = j;
				}
			}
			String tmp = serial[i];
			serial[i] = serial[minIdx];
			serial[minIdx] = tmp;
		}
		
		// 3. 숫자가 알파벳보다 
		for(int i = 0; i < serial.length; i++) {
			System.out.println(serial[i]);
		}
	}
}