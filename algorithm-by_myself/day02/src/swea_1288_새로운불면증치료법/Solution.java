package swea_1288_새로운불면증치료법;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();

			Boolean[] isChecked = new Boolean[10]; // 0123456789

			for (int i = 0; i < 10; i++) {
				isChecked[i] = false;
			}


			boolean check = false;
			int cnt = 1;
			
			while (check != true) {
				int tmp = N * cnt;

				// 해당 숫자 체크
				while (tmp != 0) {
					int num = tmp % 10;
					isChecked[num] = true;
					tmp /= 10;
				}

				// 모두 true인지 확인
				int checkCnt = 0;
				for (int i = 0; i < 10; i++) {
					if (isChecked[i] == false) {
						break;
					}
					checkCnt++;
				}
				
				if(checkCnt == 10) {
					check = true;
				} else {
					cnt++;
				}
			}
			
			
			System.out.println("#"+tc+" "+N * cnt);
			

		}
	}

}
