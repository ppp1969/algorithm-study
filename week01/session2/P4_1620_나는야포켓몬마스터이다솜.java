package week01.session2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class P4_1620_나는야포켓몬마스터이다솜 {
	public ArrayList<String> solution(int n, int m, String[] q, String[] a) {
		ArrayList<String> answer = new ArrayList<>();
		HashMap<String, String> hsS = new HashMap<>();
		HashMap<String, String> hsN = new HashMap<>();


		for (int i = 1; i <= n; i++) {
			hsS.put(q[i], String.valueOf(i));
			hsN.put(String.valueOf(i), q[i]);
		}

		for (String x : a) {
			if (hsS.containsKey(x)) {
				answer.add(hsS.get(x));
			} else {
				if (hsN.containsKey(x)) {
					answer.add(hsN.get(x));
				}
			}
		}

		return answer;
	}
	public static void main(String[] args) {
		P4_1620_나는야포켓몬마스터이다솜 T = new P4_1620_나는야포켓몬마스터이다솜();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		String[] q = new String[n+1];
		String[] a = new String[m+1];

		for (int i = 1; i <= n; i++) {
			q[i] = sc.next();
		}
		for (int i = 1; i <= m; i++) {
			a[i] = sc.next();
		}

		for (String x : T.solution(n, m, q, a)) {
			System.out.println(x);
		}
	}
}
