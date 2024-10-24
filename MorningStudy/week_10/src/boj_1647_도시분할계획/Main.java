package boj_1647_도시분할계획;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] p;
	static int[][] edges;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		p = new int[N+1];
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		edges = new int[M][3];
		
		for(int i = 0; i < M; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		int count = 0;
		int W = 0;
		
		for(int i = 0; i < M; i++) {
			int px = findParents(edges[i][0]);
			int py = findParents(edges[i][1]);
			
			if(px != py) {
				union(px, py);
				count++;
				W += edges[i][2];
			}
			
			
			if(count == N-1) {			// 일단 모든 정점을 이은 다음에
				W -= edges[i][2];		// 가장 최근에 이은 거 하나만 끊어주면 도시 분할됨
				System.out.println(W);	// 그 때의 가중치가 최소값
				break;
			}
		}
		
	}
	
	public static int findParents(int num) {
		if(num != p[num]) {
			p[num] = findParents(p[num]);
		}
		return p[num];
	}
	
	public static void union(int a, int b) {
		p[b] = a;
	}
	
}