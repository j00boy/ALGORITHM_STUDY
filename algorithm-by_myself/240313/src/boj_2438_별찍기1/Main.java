package boj_2438_별찍기1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String s = "";
		for(int i = 1; i <= N; i++) {
			s += "*";
			System.out.println(s);
		}
	}
}
