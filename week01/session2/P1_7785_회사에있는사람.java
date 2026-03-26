package week01.session2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class P1_7785_회사에있는사람 {
	public ArrayList<String> solution(int n, String[] input) {
		ArrayList<String> answer;
		HashSet<String> hs = new HashSet<>();

		for (String x : input) {
			String name = x.split(" ")[0];
			String status = x.split(" ")[1];

			if(hs.contains(name) && status.equals("leave")){
				hs.remove(name);
			}else{
				hs.add(name);
			}
		}

		answer = new ArrayList<>(hs);
		Collections.sort(answer, Collections.reverseOrder());

		return answer;
	}
	public static void main(String[] args) {
		P1_7785_회사에있는사람 T = new P1_7785_회사에있는사람();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] input = new String[n];

		sc.nextLine();
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextLine();
		}

		for(String x: T.solution(n, input)){
			System.out.println(x);
		}
	}
}
