package boj_2632_피자판매;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int order;
	static int n;
	static int m;
	static int[] A;
	static int[] B;
	static int[] a;
	static int[] b;
	
	static int way;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		order = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();
		
		A = new int[n];
		B = new int[m];
		
		way = 0;
		
		for(int i = 1; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i = 1; i < m; i++) {
			B[i] = sc.nextInt();
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		
		System.out.println(way);
	}
}
