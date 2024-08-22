package boj_1439_뒤집기;

import java.util.Scanner;

public class Main {
	
	static String str;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		str = sc.next();
		
		int zero = 0;
		int one = 0;
		
		char now = '\u0000';
		for(int i = 0; i < str.length(); i++) {
			if(now == '\u0000') {
				now = str.charAt(i);
			} else if(str.charAt(i) != now) {
				if(now == '0') {
					zero++;
				} else {
					one++;
				}
				now = str.charAt(i);
			}
		}
		
		if(now == '0') {
			zero++;
		} else {
			one++;
		}
		
		System.out.println(Math.min(zero, one));
	}
}
