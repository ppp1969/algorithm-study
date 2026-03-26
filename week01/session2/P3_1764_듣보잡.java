package week01.session2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class P3_1764_듣보잡 {
	public ArrayList<String> solution(int n, int m, String[] input1, String[] input2) {
		ArrayList<String> answer = new ArrayList<>();
		HashSet<String> hs = new HashSet<>();

		for (String x : input1) {
			hs.add(x);
		}

		for (String x : input2) {
			if (hs.contains(x)) {
				answer.add(x);
			}
		}
		Collections.sort(answer);

		return answer;
	}
	public static void main(String[] args) {
		P3_1764_듣보잡 T = new P3_1764_듣보잡();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		String[] input1 = new String[n];
		String[] input2 = new String[m];

		for (int i = 0; i < n; i++) {
			input1[i] = sc.next();
		}
		for (int i = 0; i < m; i++) {
			input2[i] = sc.next();
		}

		ArrayList<String> answer = T.solution(n, m, input1, input2);
		System.out.println(answer.size());
		for (String x : answer) {
			System.out.println(x);
		}
	}
}
