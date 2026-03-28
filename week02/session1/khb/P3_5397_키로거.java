package week02.session1.khb;

import java.util.Scanner;
import java.util.Stack;

public class P3_5397_키로거 {
	public String[] solution(int n, String[] input) {
		String[] answer = new String[n];
		Stack<Character> a = new Stack<>();
		Stack<Character> tmp = new Stack<>();

		for (int i = 0; i < n; i++) {
			for (char k : input[i].toCharArray()) {
				if (k == '-') {
					if (!a.isEmpty()) {
						a.pop();
					}
				} else if (k == '<') {
					if (!a.isEmpty()) {
						tmp.push(a.pop());
					}
				} else if (k == '>') {
					if (!tmp.isEmpty()) {
						a.push(tmp.pop());
					}
				} else {
					a.push(k);
				}
			}

			while (!tmp.isEmpty()) {
				a.push(tmp.pop());
			}

			StringBuilder sb = new StringBuilder();
			for (char k : a) {
				sb.append(k);
			}
			answer[i] = sb.toString();
			a.clear();
			tmp.clear();
		}
		return answer;
	}

	public static void main(String[] args) {
		P3_5397_키로거 T = new P3_5397_키로거();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] input = new String[n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.next();
		}

		for (String x : T.solution(n, input)) {
			System.out.println(x);
		}
	}
}
