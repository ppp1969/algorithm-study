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

        // 1. 횟수 입력
        int T = Integer.parseInt(br.readLine());

        ////////////////////////////////////////////////////////

        // 2. 스택으로 시뮬레이션

        for(int i = 0 ; i < T ; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            String s = br.readLine();
            for(int j = 0 ; j < s.length() ; j++) {

                char current = s.charAt(j);

                if(current == '(') {
                    // case 1 : '('
                    stack.push(0);
                }
                else if(stack.isEmpty()) {
                    // case 2 : 스택 빔 && ')'
                    stack.push(1);
                    break;
                }
                else {
                    // case 3 : 스택 비지 않음 && ')'
                    stack.pop();
                }
            }

            if(stack.isEmpty()) bw.write("YES\n");
            else bw.write("NO\n");
        }


        /////////////////////////////////////////////////////////

        bw.flush();
        bw.close();
        br.close();


    }

}









