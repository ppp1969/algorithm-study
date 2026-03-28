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



        String s = br.readLine();
        int count = Integer.parseInt(br.readLine());

        // 1. list 시뮬레이션
        List<Character> list = new LinkedList<>();
        ListIterator<Character> iter = list.listIterator();


        for(int i = 0 ; i < s.length() ; i++) {
            iter.add(s.charAt(i));
        }
        
        for(int i = 0 ; i < count ; i++) {

            String k = br.readLine();
            char inst = k.charAt(0);


            if(inst == 'B') {
                // 삭제
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            }
            else if(inst == 'L') {
                // 커서 좌측 이동
                if(iter.hasPrevious()) iter.previous();

            }
            else if(inst == 'D') {
                // 커서 우측 이동
                if(iter.hasNext()) iter.next();
            }
            else {
                // 리스트 추가
                char element = k.charAt(2);
                iter.add(element);
            }
        }

        // 2. 출력
        for(char c : list) bw.write(c);
        bw.write("\n");


        /////////////////////////////////////////////////////////

        bw.flush();
        bw.close();
        br.close();


    }

}









