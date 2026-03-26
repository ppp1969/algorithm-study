package cah;

import java.io.*;
import java.util.*;

    /*
      문제 요약
      - 키 입력 문자열을 보고 실제 입력된 암호 유추

      핵심 아이디어
      - 커서를 기준으로 왼쪽/오른쪽을 나눠 Deque 2개로 관리

      시간 복잡도
      - O(N)

      참고
      - 스택 2개로도 구현 가능
    */

public class P5397_키로거 {
    static String keyLogger(String s){

        // 커서 기준 오른쪽, 왼쪽 deque로 분리
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            // 화살표 입력
            if(c == '<' || c == '>'){
                // 왼쪽 화살표: 왼쪽 pop해서 오른쪽 앞에 push
                if(c == '<'){
                    if(!left.isEmpty()) right.addFirst(left.removeLast());
                // 오른쪽 화살표: 오른쪽 poll해서 왼쪽 뒤에 push
                }else{
                    if(!right.isEmpty()) left.addLast(right.removeFirst());
                }
            }
            // 백스페이스 입력: 왼쪽에서 pop
            else if(c == '-'){
                if(!left.isEmpty()) left.removeLast();
            }
            // 이 외의 문자 입력: 왼쪽에 push
            else{
                left.addLast(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c: left){
            sb.append(c);
        }
        for(char c: right){
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            String input = br.readLine();
            System.out.println(keyLogger(input));
        }

        br.close();
    }
}
