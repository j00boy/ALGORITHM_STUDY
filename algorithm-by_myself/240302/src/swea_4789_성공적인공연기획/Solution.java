package swea_4789_성공적인공연기획;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("src/swea_4789_성공적인공연기획/input.txt"));

		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int len = str.length();
			int hired = 0;
			int[] people = new int[str.length()];

			for (int i = 0; i < len; i++) {
				people[i] = Character.getNumericValue(str.charAt(i));
			}

			int sum = people[0];
			for(int i = 1; i < len; i++) {
				int gap = 0;
				if(i > sum) {
					gap = i - sum;
				}
				
				if(hired < gap) {
					hired = gap;
				}
				
				sum += people[i];
			}
			
			System.out.printf("#%d %d\n", tc, hired);

		}
		// test case
	}

}
