package boj_1753_최단경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();	// 간선의 개수가 20000까지라서, 한번에 출력하기 위한 StringBuilder
	
	static class Edge implements Comparable<Edge> {
		int end;
		int w;
		
		public Edge(int end, int w) {
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;	// 최단경로를 위해 가중치로 비교(우선순위)
		}
	}
	
	static int V;
	static int E;
	static int[] dist;
	static ArrayList<Edge>[] adjList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();			// 정점의 개수 
		E = sc.nextInt();			// 간선의 개수 
		int start = sc.nextInt();	// 시작점 정보 
		
		// 최단거리 갱신배열 초기화 
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		// 인접리스트 초기화
		adjList = new ArrayList[V+1];
		for(int i = 0; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 간선정보 입력 받기
		for(int i = 0; i < E; i++) {
			adjList[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
		}
		
		dijkstra(start);
		
		// 정점을 1번부터 v번까지 돌면서 
		for(int i = 1; i <= V; i++) {
			// 갈수 없는 경로였다면 
			if(dist[i] == INF) {
				sb.append("INF\n");	// INF로 출력 
			} else {
				sb.append(dist[i] + "\n");	// 최단거리로 출력 
			}
		}
		
		System.out.println(sb);
	}
	
	// 다익스트라 알고리즘 
	static void dijkstra(int start) {
		// 우선순위큐 선언
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		// 나한테 가는 최단거리 = 0
		dist[start] = 0;
		
		// 방문체크 배열 생성 -> 한번 방문했던 정점을 다시 방문할 필요가 없기 때문에
		// - why? Comparable을 가중치로 비교햤기 때문에, 이미 최단거리의 간선이 선택되어 있음
		boolean[] visited = new boolean[V+1];
		
		pq.add(new Edge(start, dist[start]));	// 시작점 정보를 넣고 
		
		// 모든 노드가 선택될 때까지 반복
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			// 방문 체크 여부 확인 
			if(visited[curr.end]) {
				continue;
			}
			
			// 방문 체크 
			visited[curr.end] = true;
			
			// 뽑은 노드와 인접한 노드들을 돌며 
			for(Edge edge : adjList[curr.end]) {
				// 방문한적 없고, 인접한 노드로 더 최단거리로 이동할 수 있을 때 갱신 
				if(!visited[edge.end] && dist[edge.end] > dist[curr.end] + edge.w) {
					dist[edge.end] = dist[curr.end] + edge.w;	// 최단거리 배열 업데이트 
					pq.add(new Edge(edge.end, dist[edge.end]));
				}
			}
		}
	}
}