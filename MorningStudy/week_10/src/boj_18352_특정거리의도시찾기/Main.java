package boj_18352_특정거리의도시찾기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int end;
	int w;
	
	public Node (int end, int w) {
		this.end = end;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
	
}

public class Main {

	static int N;
	static int M;
	static int K;
	static int X;
	static ArrayList<Node>[] adjList;
	static int[] D;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 도시의 개수 (정점)
		M = sc.nextInt(); // 도로의 개수 (간선)
		K = sc.nextInt(); // 거리 정보
		X = sc.nextInt(); // 도시 출발 번호

		// 인접행렬 생성 및 초기화
		adjList = new ArrayList[N + 1];
		D = new int[N+1];

		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();		// 
		}

		// 간선 입력 to 인접리스트
		for (int i = 0; i < M; i++) {
			adjList[sc.nextInt()].add(new Node(sc.nextInt(), 1));
		}
		
		Arrays.fill(D, 987654321);	// 충분히 큰 값으로 DP 초기화
		
		dijkstra(X);
		
		int count = 0;				// 최단 거리 K인 도시 갯수 count
		for(int i = 0; i <= N; i++) {
			if(D[i] == K) {
				sb.append(i + "\n");
				count++;
			}
		}
		
		if(count == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}
		
	}

	public static void dijkstra(int start) {

		PriorityQueue<Node> pq = new PriorityQueue<>();	// 우선순위 큐를 만들고
		// 우선순위큐는 위에서 정의한 가중치 크기의 오름차순대로 알아서 정렬됨

		boolean[] visited = new boolean[N + 1];			// 방문체크 배열 생성
		
		D[start] = 0;		// 다익스트라는 시작점이 전부 있음

		pq.add(new Node(start, 0));	// 시작 노드를 큐에 먼저 넣음

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.end]) {
				continue;
			}
			
			visited[curr.end] = true;	// 방문했다는 흔적을 남기고
			for(Node node : adjList[curr.end]) {	// 인접하는 노드에 대해
				if(!visited[node.end] && D[node.end] > D[curr.end] + node.w) {	// 방문 안했고 + 해당 노드의 DP가 현재 노드 + 뽑은 노드의 가중치보다 작다면
					D[node.end] = D[curr.end] + node.w;							// 작은 값으로 갱신
					pq.add(new Node(node.end, D[node.end]));					// pq에 넣음
				}
			}
		}
	}
}