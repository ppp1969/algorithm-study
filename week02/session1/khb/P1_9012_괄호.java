package week02.session1.khb;

import java.util.Scanner;
import java.util.Stack;

public class P1_9012_괄호 {
	public String[] solution(int n, String[] input) {
		String[] answer = new String[n];
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			answer[i] = "YES";
		}

		for (int i = 0; i < n; i++) {
			for (char x : input[i].toCharArray()) {
				if(x == ')'){
					if (st.isEmpty()) {
						answer[i] = "NO";
						break;
					}
					st.pop();
				} else {
					st.push(x);
				}
			}
			if(!st.isEmpty()) answer[i] = "NO";
			st.clear();
		}

		return answer;
	}
	public static void main(String[] args) {
		P1_9012_괄호 T = new P1_9012_괄호();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();;
		String[] input = new String[n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.next();
		}

		for (String x : T.solution(n, input)) {
			System.out.println(x);
		}
	}
}
