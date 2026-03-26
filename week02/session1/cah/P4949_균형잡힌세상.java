package cah;

import java.io.*;
import java.util.*;

    /*
      문제 요약
      - 문자열의 소,대괄호가 짝이 모두 맞는지 판별
      - 한 줄씩 입력받고, "."이 나오면 종료

      핵심 아이디어
      - 여는 괄호를 만나면 짝이 맞는 닫는 괄호를 스택에 저장
      - 닫는 괄호를 만나면 stack의 top과 비교해 일치하지 않으면 false
      - 문자열 순회 후 스택이 비어있어야 균형 잡힌 문자열

      시간 복잡도: O(N)

      참고
      - 괄호 외의 문자도 포함되어 있으니, 괄호만 선별 처리 필요
    */

public class P4949_균형잡힌세상 {
    static boolean isBalanceString(String s){

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            // 여는 괄호면 대응되는 닫는 괄호 저장
            if(c == '(' || c == '['){
                if(c=='(') stack.push(')');
                else stack.push(']');
            // 닫는 괄호 분기
            }else if(c == ')' || c == ']'){
                if(stack.isEmpty()) return false; // 스택이 비어있으면 false
                // stack의 top이 현재의 닫는 괄호와 같다면 짝이 됨
                if(stack.pop() != c) return false;
            }
        }
        // 최종적으로 스택이 비었다면 균형있는 문자열
        return stack.isEmpty();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String s = br.readLine();
            if(s.equals(".")) break; // .이 들어오면 입력 끝

            System.out.println(isBalanceString(s)?"yes":"no");
        }

        br.close();
    }
}
