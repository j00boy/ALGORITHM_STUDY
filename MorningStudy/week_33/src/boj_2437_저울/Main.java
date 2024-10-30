package boj_2437_저울;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list, (a, b) -> a - b);
		
		/*
		 * 1 1 2 3 6 7 30
		 */
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			int num = list.get(i);

			if(sum + 1 < num) {
				break;
			}
			
			sum += num;
		}
		
		System.out.println(sum + 1);
	}
}
