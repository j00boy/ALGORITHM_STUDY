package swea_2007_패턴마디의길이;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("src/swea_2007_패턴마디의길이/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();

			List<String> list = new ArrayList<>();
			int max = 0;

			for (int i = 9; i >= 0; i--) {
				String s = str.substring(0, i + 1);
				list.add(s);
				String tmpStr = s + s;
				for(int j = 1; j < 10; j++) {
					list.remove(tmpStr);
					tmpStr += s;
				}
			}

			for (String s : list) {
				String pattern = s;
				boolean flag = true;
				int count = 1;
				while (pattern.length() < 30) {
					if (str.contains(pattern)) {
						pattern += s;
					} else {
						flag = false;
						break;
					}
				}

				if (flag) {
					if (max < s.length())
						max = s.length();
				}
			}

			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
