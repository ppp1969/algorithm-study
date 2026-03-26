package week01.session2.jsh;

import java.io.*;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class P1_7785_회사에있는사람 {
    public static void main(String[] args) throws IOException {
        /**
         * 입력 :
         * n
         * enter char1
         * enter char2
         * leave char1
         * ...
         *
         * 출력 :
         * 회사에 남아있는 사람 - char1
         * 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다.
         *
         * 유의
         * -회사에는 동명이인이 없으며, 대소문자가 다른 경우에는 다른 이름이다.
         * -사람들의 이름은 알파벳 대소문자로 구성된 5글자 이하의 문자열이다.
         *
         * 시간제한은 1초이므로,  (2 ≤ n ≤ 10^6)인 n에 대해서 n^2은 불가능
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        String[] result = Solution(str);

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static String[] Solution(String[] str){
        Set<String> company = new TreeSet<>(Collections.reverseOrder());

        for(String s : str){
            String[] command = s.split(" ");
            // name, [append leave]

            if (command[1].equals("enter")){
                company.add(command[0]);
            } else if (command[1].equals("leave")){
                company.remove(command[0]);
            }
        }

        return company.toArray(String[]::new); // toArray안에는 String을 명시
    }
}
