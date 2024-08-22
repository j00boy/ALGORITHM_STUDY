package boj_1744_수묶기;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static int N;
	
	static PriorityQueue<Integer> plus;
	static PriorityQueue<Integer> minus;
	static PriorityQueue<Integer> zero;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		plus = new PriorityQueue<>(Collections.reverseOrder());
		minus = new PriorityQueue<>();
		zero = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num > 0) plus.add(num);
			else if(num == 0) zero.add(num);
			else minus.add(num);
		}
		
		int sum = 0;
		
		while(!plus.isEmpty()) {
			int num1 = plus.poll();
			int num2 = 1111;
			
			if(!plus.isEmpty()) {
				num2 = plus.poll();
			}
			
			if(num2 != 1111) {
				if(num1 != 1 && num2 != 1) {
					sum += num1 * num2;
				} else {
					sum += num1 + num2;
				}
			} else {
				sum += num1;
			}
		}
		
		while(!minus.isEmpty()) {
			int num1 = minus.poll();
			int num2 = -1111;
			
			if(!minus.isEmpty()) {
				num2 = minus.poll();
			}
			
			if(num2 != -1111) {
				sum += num1 * num2;
			} else {
				if(!zero.isEmpty()) {
					zero.poll();
				} else {
					sum += num1;
				}
			}
		}
		
		System.out.println(sum);
		
	}
}
