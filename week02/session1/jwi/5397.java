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

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCase ; i++) {

            String s = br.readLine();

            // 1. list 시뮬레이션
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for(int len = 0 ; len < s.length() ; len++) {

                char c = s.charAt(len);

                if(c == '-') {
                    // case 1 : 백스페이스
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                }
                else if(c == '<') {
                    // case 2 : 커서 좌측 이동
                    if(iter.hasPrevious()) iter.previous();

                }
                else if(c == '>') {
                    // case 3 : 커서 우측 이동
                    if(iter.hasNext()) iter.next();
                }
                else {
                    // case 4 : 리스트 추가
                    iter.add(c);
                }
            }

            // 2. 출력
            for(char c : list) bw.write(c);
            bw.write("\n");


        }
        
        /////////////////////////////////////////////////////////

        bw.flush();
        bw.close();
        br.close();


    }

}









