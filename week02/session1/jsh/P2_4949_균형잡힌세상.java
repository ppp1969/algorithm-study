package week02.session1.jsh;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class P2_4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        /**
         * 균형잡힌세상
         *
         * 입력 :
         * So when I die (the [first] I will see in (heaven) is a score list).
         * [ first in ] ( first out ).
         * Half Moon tonight (At least it is better than no Moon at all].
         * A rope may form )( a trail in a maze.
         * Help( I[m being held prisoner in a fortune cookie factory)].
         * ([ (([( [ ] ) ( ) (( ))] )) ]).
         *  .
         * .
         *
         * 출력 :
         * yes
         * yes
         * no
         * no
         * no
         * yes
         * yes
         *
         * 유의 :
         * - 7번째의 " ."와 같이 괄호가 하나도 없는 경우도 균형잡힌 문자열로 간주할 수 있다. -> 기본값 true
         *
         * 알고리즘 :
         * 1. ( ) [ ] 를 제외한 모든 문자 건너뛰기.
         * 2. 괄호의 시작부분은 스택에 삽입
         * 3. 괄호의 끝부분에서 해당 조건 검사 (스택이 비어있는지, 괄호가 매칭되는지)
         *
         * 기억하고 싶은 내용 :
         * - n이 주어지지 않는다면 while( br.readLine() )을 떠올리기.
         * - 종료조건에 대해서 자세히 읽지 않아, 알고리즘보다 입력에 시간을 더 씀.
         * - bw.write 전에 sb에 대해서 trim 하기.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<String> input = new ArrayList<>();
        String in;
        while(!(in = br.readLine()).equals(".")){
            input.add(in);
        }


        solution(input, sb);
        bw.write(sb.toString().trim());
        bw.flush();
        br.close();
        bw.close();

    }

    public static void solution(List<String> input, StringBuilder sb){
        for (int i = 0; i < input.size(); i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean result = true;
            for(char c : input.get(i).toCharArray()){
                if (c != '(' && c!=')' && c!='[' && c!=']'){
                    continue;
                }
                if (c == '(' || c == '['){ // 입력이면 넣기
                    stack.push(c);
                    continue;
                }
                else if (stack.isEmpty()){ // ], )
                    result = false;
                    break;
                }

                char popC = stack.pop();
                if ((popC == '[' && c == ')') || (popC == '(' && c == ']')){
                    result = false;
                    break;
                }

            }

            if (!stack.isEmpty()) result = false;
            if (result) sb.append("yes\n");
            else sb.append("no\n");
        }
    }
}
