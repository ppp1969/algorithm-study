package week01.session2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class P2_1302_베스트셀러 {
	public String solution(int n, String[] input) {
		String answer = "";
		HashMap<String, Integer> hs = new HashMap<>();
		int max = Integer.MIN_VALUE;

		for (String x : input) {
			hs.put(x, hs.getOrDefault(x, 0) + 1);
			if (hs.get(x) > max) max = hs.get(x);
		}

		ArrayList<String> book = new ArrayList<>();
		for (String x : hs.keySet()) {
			if (hs.get(x) == max) {
				book.add(x);
			}
		}

		Collections.sort(book);
		answer = book.get(0);

		return answer;
	}
	public static void main(String[] args) {
		P2_1302_베스트셀러 T = new P2_1302_베스트셀러();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] input = new String[n];

		for (int i = 0; i < n; i++) {
			input[i] = sc.next();
		}

		System.out.println(T.solution(n, input));
	}
}
