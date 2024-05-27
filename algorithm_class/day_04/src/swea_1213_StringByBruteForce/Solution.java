package swea_1213_StringByBruteForce;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {

		File file = new File("src/swea_1213_StringByBruteForce/input.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

			String pattern = sc.next();
			String text = sc.next();

			System.out.printf("#%d %d\n", test_case, checkPatternCount(text, pattern));

		}

	}

	public static int checkPatternCount(String text, String pattern) {

		char[] textToArr = text.toCharArray(); // text를 문자 배열로 변환
		char[] patternToArr = pattern.toCharArray(); // pattern를 문자 배열로 변환

		int count = 0; // 갯수를 담을 변수 생성

		for (int i = 0; i < textToArr.length - patternToArr.length + 1; i++) { // text에서 pattern을 탐색을 시작할 index
			if(textToArr[i] == patternToArr[0]) {
				boolean isMatch = true;
				for(int j = 1; j < pattern.length(); j++) {
					if(textToArr[i+j] != patternToArr[j]) {
						isMatch = false;
						break;
					}
				}
				if(isMatch) count++;
			}
		}
		return count;
	}

}
