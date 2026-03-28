package week02.session1.khb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4_1406_에디터 {
	public String solution(String input, int n, String[] p) {
		Stack<Character> a = new Stack<>();
		Stack<Character> tmp = new Stack<>();

		for (char x : input.toCharArray()) {
			a.push(x);
		}

		for (String x : p) {
			if(x.charAt(0) == 'B'){
				if (!a.isEmpty()) {
					a.pop();
				}
			} else if(x.charAt(0) == 'L'){
				if (!a.isEmpty()) {
					tmp.push(a.pop());
				}
			} else if(x.charAt(0) == 'D'){
				if (!tmp.isEmpty()) {
					a.push(tmp.pop());
				}
			}
			else if (x.charAt(0) == 'P') {
				a.push(x.charAt(2));
			}
		}

		while (!tmp.isEmpty()) {
			a.push(tmp.pop());
		}

		StringBuilder sb = new StringBuilder();
		for (char x : a) {
			sb.append(x);
		}

		return sb.toString();
	}
	public static void main(String[] args) throws Exception{
		P4_1406_에디터 T = new P4_1406_에디터();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(br.readLine());

		String[] p = new String[n];
		for (int i = 0; i < n; i++) {
			p[i] = br.readLine();
		}
		System.out.println(T.solution(input, n, p));

		br.close();
	}
}
