package boj_10775_공항;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int G;
	static int P;
	static boolean[] isFull;
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 오랜만에 연습해보고 싶었음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		
		isFull = new boolean[G+1];
		count = 0;
		
		for(int i = 0; i < P; i++) {
			int gateNo = Integer.parseInt(br.readLine());
			
			findGate(gateNo);
			
		}
//		System.out.println(Arrays.toString(isFull));
		
		System.out.println(count);
	}
	
	public static void findGate(int gateNo) {
		for(int i = gateNo; i >= 1; i--) {
			if(!isFull[i]) {
				isFull[i] = true;
				count++;
				break;
			}
		}
	}
}
