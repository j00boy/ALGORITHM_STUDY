package boj_9251_LCS;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] arr1 = sc.next().toCharArray();
		char[] arr2 = sc.next().toCharArray();
		
		int[][] D = new int[arr1.length][arr2.length];
		
		if(arr1[0] != arr2[0]) D[0][0] = 0;
		else D[0][0] = 1;
		for(int c = 1; c < arr2.length; c++) {
			if(arr1[0] == arr2[c]) {
				D[0][c] = 1;
			} else {
				if(D[0][c-1] == 1) D[0][c] = 1;
				else D[0][c] = D[0][c-1];
			}
		}

		for(int r = 1; r < arr1.length; r++) {
			for(int c = 0; c < arr2.length; c++) {
				if(arr1[r] != arr2[c]) {
					D[r][c] = D[r-1][c];
				} else {
					D[r][c] = D[r-1][c]+ 1;
				}
			}
		}
		
		for(int r = 0; r < arr1.length; r++) {
			System.out.println(Arrays.toString(D[r]));
		}
		
		System.out.println(D[arr1.length-1][arr2.length-1]);
	}
}
