package boj_1931_회의실배정;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		LinkedList<int[]> list = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(new int[] {sc.nextInt(), sc.nextInt()});
		}
		
		int count = 0;
		while(!list.isEmpty()) {
			int min = Integer.MAX_VALUE;
			int[] target = new int[2];
			
			for(int[] arr : list) {
				if(arr[1] < min) {
					min = arr[1];
					target = arr;
				}
			}
			
//			System.out.println(Arrays.toString(target));
			count++;
			for(int i = list.size()-1; i >= 0; i--) {
				if(list.get(i)[0] < target[1]) {
					list.remove(list.get(i));
				}
			}
		}
		
		System.out.println(count);

		
	}
}