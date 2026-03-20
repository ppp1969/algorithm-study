package week01.session1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class P4_9996_한국이그리울땐서버에접속하지 {
	public ArrayList<String> solution(int n, String pattern, String[] fileName){
		ArrayList<String> answer = new ArrayList<>();
		pattern = pattern.replace("*", "[a-z]*");

		for (String x : fileName) {
			if(Pattern.matches(pattern, x)){
				answer.add("DA");
			}else{
				answer.add("NE");
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		P4_9996_한국이그리울땐서버에접속하지 T = new P4_9996_한국이그리울땐서버에접속하지();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String pattern = sc.next();

		String[] fileName = new String[n];
		for (int i = 0; i < n; i++) {
			fileName[i] = sc.next();
		}

		for(String x : T.solution(n, pattern, fileName)){
			System.out.println(x);
		}
	}
}
