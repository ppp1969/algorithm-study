package week02.session1.khb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class P2_4949_균형잡힌세상 {
	public ArrayList<String> solution(ArrayList<String> input) {
		ArrayList<String> answer = new ArrayList<>();
		Stack<Character> st = new Stack<>();

		for (String x : input) {
			x = x.replaceAll(" ", "").replaceAll("[A-Z]", "").replaceAll("[a-z]", "").replaceAll("[.]", "");
			boolean flag = true;

			for (char s : x.toCharArray()) {
				if(s == ')') {
					if(st.isEmpty() || st.peek() != '('){
						flag = false;
						break;
					}
					st.pop();
				} else if (s == ']') {
					if(st.isEmpty() || st.peek() != '['){
						flag = false;
						break;
					}
					st.pop();
				} else if (s == '(' || s == '[') {
					st.push(s);
				}
			}
			if(!st.isEmpty()) flag = false;

			if (flag) {
				answer.add("yes");
			} else {
				answer.add("no");
			}

			st.clear();
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		P2_4949_균형잡힌세상 T = new P2_4949_균형잡힌세상();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> input = new ArrayList<>();

		String line;
		while (!(line = br.readLine()).equals(".")) {
			input.add(line);
		}

		for (String x : T.solution(input)) {
			System.out.println(x);
		}
		br.close();
	}
}
