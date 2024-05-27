package swea_1225_암호생성기;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static List<Integer> queue = new ArrayList<>();
	static int front, rear;

	public static void main(String[] args) throws IOException {

		File file = new File("src/swea_1225_암호생성기/input.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			
			queue.clear();
			front = -1;
			rear = -1;
			int test_case = sc.nextInt();

			// Queue에 숫자 넣기
			for (int i = 0; i < 8; i++) {
				enQueue(sc.nextInt());
			}

			boolean flag = true;
			while (flag) {
				for (int i = 1; i <= 5; i++) {
					int tmp = deQueue();
					if (tmp - i <= 0) {
						enQueue(0);
						flag = false;
						break;
					} else {
						enQueue(tmp - i);
					}
				}
				
//				System.out.println(queue);
			}

			String ans = "";
			for(int i = queue.size()-8; i < queue.size(); i++) {
				ans += queue.get(i) + " ";
			}
			
			System.out.printf("#%d %s\n", tc, ans);

		}

	}

	public static boolean isEmpty() {
		return front == rear;
	}

	public static void enQueue(int data) {
		queue.add(data);
		rear++;
	}

	public static int deQueue() {
		if (isEmpty()) {
			System.out.println("값을 빼낼 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		return queue.get(++front);
	}

	public static int peek() {
		if (isEmpty()) {
			System.out.println("값을 빼낼 수 없습니다.");
			return Integer.MIN_VALUE;
		}
		return queue.get(front+1);
	}

}