package swea_3289_서로소집합;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	static int[] p;
	
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("src/swea_3289_서로소집합/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// 노드 갯수
			
			p = new int[N+1];
			
			for(int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			int M = sc.nextInt();	// 연산 횟수
			String answer = "";
			
			for(int i = 0; i < M; i++) {
				int cal = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				int px = findParent(x);
				int py = findParent(y);
				
				if(cal == 0) {
					union(px, py);
				} else {
					if(px == py) {
						answer += 1;
					} else {
						answer += 0;
					}
				}
			}
			
			System.out.printf("#%d %s\n", tc, answer);
		}
		// test case
	}
	
	static int findParent(int n) {
		if(n != p[n]) {
			p[n] = findParent(p[n]);
		}
		return p[n];
	}
	
	static void union(int a, int b) {
		p[b] = a;
	}
}