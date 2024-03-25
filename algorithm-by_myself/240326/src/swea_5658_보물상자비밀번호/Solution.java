package swea_5658_보물상자비밀번호;

import java.util.*;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {

			List<String> list = new ArrayList<>();
			int N = sc.nextInt();
			int K = sc.nextInt();
			String str = sc.next();

			for (int n = 0; n < N / 4; n++) {
				for (int i = 0; i < N; i += N / 4) {
					String pass = "";
					for (int j = i; j < i + N / 4; j++) {
						pass += str.charAt(j);
					}
					if (!list.contains(pass)) {
						list.add(pass);
					}
				}
				
				str = str.charAt(str.length()-1) + str.substring(0, str.length()-1);
			}
			
			Collections.sort(list, Collections.reverseOrder());
			
			String target = list.get(K-1);
			
			// 숫자로 변환
			int targetToNum = 0;
			int idx = 0;
			for(int i = target.length() - 1; i >= 0; i--) {
				if(target.charAt(i) >= '0' && target.charAt(i) <= '9') {
					targetToNum += (target.charAt(i) - '0') * Math.pow(16, idx); 
				} else if(target.charAt(i) >= 'A' && target.charAt(i) <= 'F') {
					targetToNum += (target.charAt(i) - 55) * Math.pow(16, idx);
				}
				idx++;
			}
			
			System.out.printf("#%d %d\n", tc, targetToNum);
		}
		// test case
	}
}
