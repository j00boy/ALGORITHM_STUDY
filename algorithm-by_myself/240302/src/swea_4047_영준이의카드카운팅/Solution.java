package swea_4047_영준이의카드카운팅;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("src/swea_4047_영준이의카드카운팅/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			
			int S = 13;
			int D = 13;
			int H = 13;
			int C = 13;
			
			String str = sc.next();
			List<String> list = new ArrayList<>();
			boolean ERROR = true;
			
			for(int i = 0; i < str.length()/3; i++) {
				String card = "";
				for(int j = i*3; j < i*3+3; j++) {
					card += str.charAt(j);
				}
				if(list.contains(card)) {
					ERROR = false;
					break;
				}
				list.add(card);
				
			}
			
			for(String s : list) {
				switch(s.charAt(0)) {
				case 'S':
					S--;
					break;
				case 'D':
					D--;
					break;
				case 'H': 
					H--;
					break;
				case 'C':
					C--;
					break;
				}
			}
			
			if(!ERROR) System.out.printf("#%d %s\n", tc, "ERROR");
			else System.out.printf("#%d %d %d %d %d\n", tc, S, D, H, C);
			
		}
		// test case

	}

}
