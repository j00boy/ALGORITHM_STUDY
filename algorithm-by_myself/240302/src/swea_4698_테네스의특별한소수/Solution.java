package swea_4698_테네스의특별한소수;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	static boolean[] prime;
		
	public static void main(String[] args) throws FileNotFoundException {
		
//		Scanner sc = new Scanner(new File("src/swea_4698_테네스의특별한소수/input.txt"));
		Scanner sc = new Scanner(System.in);


		int T = sc.nextInt();

		// test case
		for (int tc = 1; tc <= T; tc++) {
			int count = 0;
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			makePrime(1000000);

			for (int i = A; i <= B; i++) {
				if (prime[i] == false) {
					if (String.valueOf(i).contains(String.valueOf(D))) {
						count++;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, count);
		}
		// test case
	}
	
	public static void makePrime(int N) {
		prime = new boolean[N+1];
		
		if(N < 2) {
			return;
		}
		
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(N); i++) {
			if(prime[i] == true) continue;
			
			for(int j = i * i; j < prime.length; j = j += i) {
				prime[j] = true;
			}
		}
	}
	
	

}
