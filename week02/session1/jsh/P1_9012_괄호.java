package week02.session1.jsh;

import java.io.*;
import java.util.ArrayDeque;

public class P1_9012_괄호 {
    public static void main(String[] args) throws IOException {
        /**
         * 괄호
         * 입력으로 주어진 n개의 문자열에 대해서, 괄호가 제대로 닫혔는지 체크하는 문제
         *
         * 알고리즘
         * - 스택에 넣고, )를 만나게 되면
         * - 해당 stack에서 top을 확인하고
         *          - (이면 삭제
         *          - )이면 에러발생 NO 출력
         * - 마지막 까지 훑은 이후 스택에 남아있다면 NO 출력
         * - 그 외 YESt 출력
         *
         * 입력 :
         * 3
         * ((
         * ))
         * ())(()
         *
         * 출력 :
         * NO
         * NO
         * NO
         *
         * 유의 :
         * - 하나의 괄호 문자열의 길이는 2 이상 50 이하
         *
         * 기억하고 싶은 점:
         * ')'가 들어올 때, 빈 스택인 경우 상정 못함.
         * 스택에서는 검사해야하는 것이 들어올 때, 필수적으로 isEmpty 체크.
         * 더 안전하게는 peek
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }

        solution(input, sb);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    public static void solution(String[] input, StringBuilder sb){
        for (String s: input) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean result = true;

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                }
                if (c == ')'){
                    // ) 일때, 비어있거나 (가 아니라면 에러발생
                    if (stack.isEmpty()){
                        result = false;
                        break;
                    }
                    if (stack.pop() != '('){
                        result = false;
                        break;
                    }
                }

            }
            if (!stack.isEmpty()) result = false;
            if (result) sb.append("YES\n");
            else sb.append("NO\n");
        }
    }
}
