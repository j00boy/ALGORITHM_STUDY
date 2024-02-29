package swea_보물상자비밀번호;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("src/swea_보물상자비밀번호/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			String input = sc.next();
			StringBuilder sb = new StringBuilder(input);
			
			List<String> list = new ArrayList<>();
			
			int rotation = N/4;
			String tmp = input;
			while(rotation-- != 0) {
				list.add(tmp);
				
				char s = tmp.charAt(tmp.length()-1);
				tmp = s + tmp.substring(0, tmp.length()-1);
			}
			
			
			List<String> passwords = new ArrayList<>();
			
			for(int i = 0; i < list.size(); i++) {
				for(int j = 0; j < N; j += N/4) {
					String target = "";
					for(int k = j; k < j + N/4; k++) {
						target += list.get(i).charAt(k);
					}
					
					
					if(!passwords.contains(target)) {
						passwords.add(target);
					}
					
				}
			}
			
			Collections.sort(passwords);
			
			String ans = passwords.get(passwords.size() - K);
			int rot = ans.length();
			int num = (int) Math.pow(16, ans.length()-1);
			int idx = 0;
			int result = 0;
			
			while(rot != 0) {
				int n1 = 0;
				char c = ans.charAt(idx);
				if(c >= '0' && c <= '9') {
					n1 = c - '0';
				} else if(c == 'A') {
					n1 = 10;
				} else if(c == 'B') {
					n1 = 11;
				} else if(c == 'C') {
					n1 = 12;
				} else if(c == 'D') {
					n1 = 13;
				} else if(c == 'E') {
					n1 = 14;
				} else if(c == 'F') {
					n1 = 15;
				}
				
				result += num * n1;
				num = num / 16;
				rot--;
				idx++;
				
			}

//			System.out.println(passwords);
			System.out.printf("#%d %s\n", tc, result);
			
		}
		// test case
	}

}
