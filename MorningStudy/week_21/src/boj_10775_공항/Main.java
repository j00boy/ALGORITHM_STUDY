package boj_10775_공항;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int G;
	static int P;
	static int[] parents;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 오랜만에 연습해보고 싶었음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());

		parents = new int[G + 1];

		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		count = 0;
		
		/*
		 * 비어 있는 게이트를 한번에 찾기 위한 유니온 파인드
		 * 
		 * 평균적으로 트리의 높이만큼 탐색하는 O(log N)의 시간복잡도를 가지나,
		 * 경로 압축을 통해서 상수의 시간 복잡도를 가짐 
		 */

		for (int i = 0; i < P; i++) {
			int gateNo = Integer.parseInt(br.readLine());	// 게이트 넘버
			int depart = findParents(gateNo);				// 비행기가 내려야 할 곳
			
			if (depart == 0) {
				break;
			}

			union(depart, depart - 1);					// 비행기가 내려야할 곳--
			count++;

//			System.out.println(Arrays.toString(parents));

		}

		System.out.println(count);
	}

	// 부모찾기
	public static int findParents(int v) {
		if (v != parents[v]) {
			parents[v] = findParents(parents[v]);
		}

		return parents[v];
	}

	// 합치기
	public static void union(int a, int b) {
		parents[findParents(a)] = findParents(b);
	}
}
