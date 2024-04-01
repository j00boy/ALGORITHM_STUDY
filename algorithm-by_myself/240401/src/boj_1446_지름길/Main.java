package boj_1446_지름길;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

import org.w3c.dom.Node;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int len;
		
		public Edge(int start, int end, int len) {
			this.start = start;
			this.end = end;
			this.len = len;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int D;
	static int[] dist;
	static ArrayList<Edge> adjList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 지름길의 개수
		D = sc.nextInt();	// 고속도로의 길이
		
		dist = new int[D+1];
		for(int i = 0; i <= D; i++) {
			dist[i] = i;
		}
		
		adjList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			adjList.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		
	}
	
	public static void dijkstra(int start) {
		if(start >= D) {
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(start < adjList.get(i).start) {
				dijkstra(start + 1);
				break;
			}
		}
	}
}
