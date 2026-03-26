package cah;

import java.io.*;
import java.util.*;

    /*
      문제 요약
      - 문자열 편집기에서 커서 이동 및 문자 삽입/삭제 명령을 처리하는 문제

      핵심 아이디어
      - 커서를 기준으로 왼쪽/오른쪽을 나눠 Deque 2개로 관리

      시간 복잡도
      - O(N + M)

      참고
      - 스택 2개로도 동일하게 구현 가능
    */

public class P1406_에디터 {
    // 커서 기준 왼쪽 / 오른쪽 문자 저장
    public static Deque<Character> left;
    public static Deque<Character> right;

    static void editor(String s){
        char cmd = s.charAt(0);

        if(cmd == 'P'){ // 문자 추가
            left.addLast(s.charAt(2));
        } else if(cmd == 'L'){ // 커서 왼쪽 이동
            if(!left.isEmpty()) right.addFirst(left.removeLast());
        }
        else if(cmd == 'D') { // 커서 오른쪽 이동
            if (!right.isEmpty()) left.addLast(right.removeFirst());
        }
        else if(cmd == 'B'){ // 커서 왼쪽 문자 삭제
            if(!left.isEmpty()) left.removeLast();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        left = new ArrayDeque<>();
        right = new ArrayDeque<>();

        for(char c : input.toCharArray()) left.addLast(c);

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            editor(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for(char c: left){
            sb.append(c);
        }
        for(char c: right){
            sb.append(c);
        }

        System.out.println(sb.toString());

        br.close();
    }
}
