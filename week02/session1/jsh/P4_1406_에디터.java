package week02.session1.jsh;

import java.io.*;
import java.util.Stack;

public class P4_1406_에디터 {
    public static void main(String[] args) throws IOException {
        /**
         * 에디터
         *
         * 입력 :
         * abcd - 기본문자열
         * 3 - 명령어 n개
         * P x -- 명령어 시작
         * L
         * P y
         *
         * 출력 :
         * abcdyx
         *
         * 유의 :
         * - 소문자만 최대 600,000
         * - 커서가 위치가능한 곳은 최대 L+1
         * - L, D, B, P ?
         *
         * 기억하고 싶은 점 :
         * 커서관련 내용이 나온다면,
         * 스택 2개를 기억하기
         * 커서위치에 좌우로 top인 스택2개 그림
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String base = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] command = new String[n];
        for (int i = 0; i < n; i++) {
            command[i] = br.readLine();
        }

        solution(base, n, command, sb);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    public static void solution(String base, int n, String[] command, StringBuilder sb){
        Stack<Character> stackLeft = new Stack<>();
        Stack<Character> stackRight = new Stack<>();
        // b a s e 순으로 left에 넣어야함.
        // [b a s e] | []

        for(char c: base.toCharArray()){
            stackLeft.push(c);
        }

        for (int i = 0; i < n; i++) {
            // String의 charAt(0)으로 구분
            if (command[i].charAt(0) == 'L'){
                if (stackLeft.isEmpty()) continue;
                stackRight.push(stackLeft.pop());
                continue;
            }
            if (command[i].charAt(0) == 'D'){
                if (stackRight.isEmpty()) continue;
                stackLeft.push(stackRight.pop());
                continue;
            }
            if (command[i].charAt(0) == 'B'){
                if (stackLeft.isEmpty()) continue;
                stackLeft.pop();
                continue;
            }
            stackLeft.push(command[i].charAt(2));
        }

        while(!stackLeft.isEmpty()){
            stackRight.push(stackLeft.pop());
        }

        while (!stackRight.isEmpty()){
            sb.append(stackRight.pop());
        }

    }
}
