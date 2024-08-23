package boj_11779_최소비용구하기2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int N;
	static int M;
	static int start;
	static int destination;
	
	static ArrayList<ArrayList<Node>> graph;
	static boolean[] visited;
	static int[] dist;
	static int[] pre;
	
	static class Node {
		int end;
		int cost;
		
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N+1];
		dist = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		graph = new ArrayList<ArrayList<Node>>();
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			graph.get(sc.nextInt()).add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		start = sc.nextInt();
		destination = sc.nextInt();
		
		int count = 1;
		pre = new int[N+1];
		Stack<Integer> stack = new Stack<>();
		dijkstra(start);
		
		stack.push(destination);
		while(pre[destination] != 0) {
			count++;
			stack.push(pre[destination]);
			destination = pre[destination];
		}
		
		System.out.println(count);
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> (o1.cost - o2.cost));

		visited = new boolean[N+1];
		
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.end]) continue;
			visited[curr.end] = true;
			
			for(Node next : graph.get(curr.end)) {
				if(dist[next.end] > dist[curr.end] + next.cost) {
					dist[next.end] = dist[curr.end] + next.cost;
					pre[next.end] = curr.end;
					pq.add(new Node(next.end, dist[next.end]));
				}
			}
		}
		
		System.out.println(dist[destination]);
	}
}
