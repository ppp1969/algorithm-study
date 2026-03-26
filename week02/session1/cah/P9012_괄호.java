package cah;

import java.io.*;
import java.util.*;

    /*
      문제 요약
      - 여러 개의 괄호 문자열이 주어질 때, 각 문자열이 VPS(올바른 괄호 문자열)인지 판별

      핵심 아이디어
      - '(' 가 나오면 스택에 넣음
      - ')' 가 나오면 스택에서 '(' 하나를 꺼내 짝을 맞춤
      - 이때 꺼낼 '(' 가 없으면 올바르지 않은 괄호 문자열
      - 모든 문자를 확인한 뒤 스택이 비어 있으면 VPS

      시간 복잡도
      - 문자열 하나당 O(N) -> 전체 O(T * N)

      참고
      - Stack 클래스도 사용할 수 있지만, 보통 ArrayDeque를 더 많이 사용
      - ArrayDeque는 스택/큐 연산을 모두 지원, 코테에서도 자주 쓰임
     */

public class P9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String s = br.readLine();

            // Deque를 스택처럼 사용
            Deque<Character> stack = new ArrayDeque<>();

            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);

                // 여는 괄호는 스택에 저장
                if(c == '(') {
                    stack.push(c);
                }else{
                    // 닫는 괄호를 만났는데 짝이 될 여는 괄호가 없으면 실패
                    if(stack.isEmpty()){
                        stack.push(c); // 짝이 없는 ')'를 넣기
                        break; // 멈춰서 바로 결과 출력으로 넘어감
                    }
                    // 짝이 되는 여는 괄호 하나 제거
                    stack.pop();
                }
            }

            // 최종적으로 스택에 남아있는게 없다면 VPS가 됨
            System.out.println(stack.isEmpty()? "YES" : "NO");
        }
        br.close();
    }
}
