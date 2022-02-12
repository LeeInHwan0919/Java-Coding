package com.min.edu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Exam06_1 {

	// 각 친구의 목록배열
	// 친구의 친구까지 찾는 그래프 문제
	// 인접행렬 방식으로 해결
	// 1번 노드 부터 끝노드 까지 방문하면서 체크를 진행
	public int[] solution(int N, int[][] relation) {
		int arrLen = N + 1;
		int[] answer = new int[arrLen];

		// 값이 있는 index를 행렬로 변환
		int[][] graph = new int[arrLen][arrLen];
		for (int i = 0; i < relation.length; i++) {
			int[] edge = relation[i];
			graph[edge[0]][edge[1]] = 1;
			graph[edge[1]][edge[0]] = 1;
		}

//		for (int i = 0; i < graph.length; i++) {
//			System.out.println(Arrays.toString(graph[i]));
//		}

		Queue<Integer> q = new LinkedList<Integer>();

		int cnt = 0;

		for (int i = 0; i < arrLen; i++) {
			boolean[] checked = new boolean[N + 1]; // [f, f, f, f, f, f]
			checked[i] = true; // [f, t, f ,f ,f ,f ]

			// 직접친구를 구하자 (1촌)
			for (int j = 0; j < arrLen; j++) {
				if (graph[i][j] == 1 && !checked[j]) {
					checked[j] = true; //
					q.offer(j);
				}
			}
			System.out.println("---------------------------");
			System.out.println(Arrays.toString(checked));
			// 1촌 친구 사이즈
			cnt = q.size();
			System.out.println(cnt);

			while (!q.isEmpty()) {
				int secondLink = q.poll(); // 2
				for (int j = 0; j < arrLen; j++) {
					if (graph[secondLink][j] == 1 && !checked[j]) {
						cnt++;
					}
				}
			}
			answer[i] = cnt;
			cnt = 0;
		}

		return answer;
	}

}
