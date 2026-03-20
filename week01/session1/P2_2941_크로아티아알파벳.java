package week01.session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class P2_2941_크로아티아알파벳 {
    public int solution(String input, ArrayList<String> ca) {
        int answer = 0;
        HashSet<String> hs = new HashSet<>(ca);

        while(!input.isEmpty()) {
            String sub1 ="";
            String sub2="";
            if(input.length()>=2){
              sub1 =  input.substring(0, 2);
            }
            if(input.length()>=3){
              sub2 = input.substring(0, 3);
            }

            if(hs.contains(sub1)){
                input = input.substring(2);
                answer++;
            }else if(hs.contains(sub2)){
                input = input.substring(3);
                answer++;
            }else{
                input = input.substring(1);
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        P2_2941_크로아티아알파벳 T = new P2_2941_크로아티아알파벳();
        Scanner sc = new Scanner(System.in);

        ArrayList<String> ca = new ArrayList<>(
                Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
        );

        String input = sc.next();
        System.out.println(T.solution(input, ca));
    }
}
