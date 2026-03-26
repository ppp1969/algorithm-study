package week02.session1.jsh;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P3_5397_키로거 {
    public static void main(String[] args) throws IOException {
        /**
         * 키로거
         *
         * 화살표 -> 커서의 이동
         * - -> 백스페이스 (앞의 글자 하나를 지운다.)
         *
         * 입력 :
         * 2
         * <<BP<A>>Cd-
         * ThIsIsS3Cr3t
         *
         * 출력 :
         * BAPC
         * ThIsIsS3Cr3t
         *
         * 유의 :
         * 1. 풀이법을 링크드 리스트로 풀었지만, 스택으로도 풀어보자.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }

        solutionStack(input,sb);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    public static void solutionLinkedList(String[] input, StringBuilder sb){
        for(String s: input){
            int cursor = 0; // 커서는 0부터 링크드 리스트.size 까지 가능함
            List<Character> list = new LinkedList<>();

            for (char c: s.toCharArray()){
                if (c == '<'){
                    if (cursor > 0){
                        cursor --;
                    }
                    continue;
                }
                if (c == '>'){
                    if (cursor < list.size()){
                        cursor ++;
                    }
                    continue;
                }
                if (c == '-'){
                    // 현재 커서의 위치 -1에 있는걸 삭제.
                    if (cursor != 0 && !list.isEmpty()){
                        list.remove(--cursor);
                    }
                    continue;
                }
                list.add(cursor, c);
                cursor++;
            }
            // 1번 방식. 틀렸음.
//            for (int i=0; i<list.size(); i++){
//                sb.append(list.get(i)); // list의 get 메소드 자체가 O(n)인데, 이걸 n번 반복했으니 N^2으로 시간초과
//            }
            // 2. iterator 기반의 for로 접근
            // 안터짐! 제일 빠름 -> 메모리 135800 KB 시간 : 2400ms
            for (char rc : list){
                sb.append(rc);
            }

            // 3. 배열 변환후, O(1)으로 접근 : 201652KB, 2528ms
            // 배열 변환에서의 비용이 더 크다.
//            Character[] result = list.toArray(Character[]::new);
//            for (int i=0; i<result.length; i++){
//                sb.append(result[i]);
//            }

            sb.append("\n");
        }
    }

    public static void solutionStack(String[] input, StringBuilder sb){
        // 훨씬 빠르다. 링크드 리스트는 접근시 O(N)이지만 스택에서는 O(1)이기에!
        // 시간 1152ms - 거의 절반정도
        // stack 2개 사용
        // 커서 기준으로 [스택 1] top < > top [스택 2]
        for(String s: input){
            // 커서를 관리하지말고, stack 2개로 값 이전
            Stack<Character> stackLeft = new Stack<>();
            Stack<Character> stackRight = new Stack<>();

            for (char c: s.toCharArray()){
                if (c == '<'){
                    if (stackLeft.isEmpty()) continue;
                    stackRight.push(stackLeft.pop());
                    continue;
                }


                if (c == '>'){
                    if (stackRight.isEmpty()) continue;
                    stackLeft.push(stackRight.pop());
                    continue;
                }

                if (c == '-'){
                    if (stackLeft.isEmpty()) continue;
                    stackLeft.pop();
                    continue;
                }

                stackLeft.push(c);


            }

            // left에 있는 건 역순, right에 있는건 정순으로 꺼내짐.
            // left -> right로 이전 후 right 출력
            while(!stackLeft.isEmpty()){
                stackRight.push(stackLeft.pop());
            }

            // right 출력
            while (!stackRight.isEmpty()){
                sb.append(stackRight.pop());
            }
            sb.append("\n");

        }



    }
}
