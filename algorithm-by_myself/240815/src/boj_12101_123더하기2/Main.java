package boj_12101_123더하기2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static ArrayList<ArrayList<String>> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		list = new ArrayList<ArrayList<String>>();
		
		for(int i = 0; i < 11; i++) {
			list.add(new ArrayList<String>());
		}
		
		list.get(1).add("1");
		list.get(2).add("1+1");
		list.get(2).add("2");
		list.get(3).add("1+1+1");
		list.get(3).add("1+2");
		list.get(3).add("2+1");
		list.get(3).add("3");
		
		if(n > 3) {
			for(int i = 4; i <= n; i++) {
				for(int j = 1; j <= 3; j++) {
					for(String operation : list.get(i - j)) {
						list.get(i).add(operation + "+" + j);
					}
				}
			}
			
			if(k > list.get(n).size()) {
				System.out.println(-1);
			} else {
				Collections.sort(list.get(n));
//				System.out.println(list.get(n));
				System.out.println(list.get(n).get(k-1));
			}
			
		} else {
			if(k > list.get(n).size()) {
				System.out.println(-1);
			} else {
				Collections.sort(list.get(n));
//				System.out.println(list.get(n));
				System.out.println(list.get(n).get(k-1));
			}
		}
	}
	
}
