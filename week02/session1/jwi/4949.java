import java.util.*;
import java.io.*;


public class Main
{

    private static BufferedReader br;
    private static BufferedWriter bw;


    public static void main(String args[]) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 시간복잡도 : O(N)

        ////////////////////////////////////////////////////////

        while(true) {

            String s = br.readLine();

            if(s.length() == 1 && s.charAt(0) == '.') break;

            // 1. 스택으로 시뮬레이션 () = 0 , [] = 1
            Deque<Integer> stack = new ArrayDeque<>();

            // 패딩
            stack.push(2);

            for(int i = 0 ; i < s.length() ; i++) {

                char c = s.charAt(i);

                if(c == '[') stack.push(1);
                else if(c == '(') stack.push(0);
                else if(c == ')' && stack.peek() == 0) stack.pop();
                else if(c == ')' && stack.peek() != 0) {stack.push(0); break;}
                else if(c == ']' && stack.peek() == 1) stack.pop();
                else if(c == ']' && stack.peek() != 1) {stack.push(1); break;}

            }

            if(stack.pop() == 2) bw.write("yes\n");
            else bw.write("no\n");

        }
        /////////////////////////////////////////////////////////

        bw.flush();
        bw.close();
        br.close();


    }

}









