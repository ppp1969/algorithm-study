import java.util.*;
import java.io.*; 


public class Main
{		
	
	private static BufferedReader br; 
	private static BufferedWriter bw; 
	
	
	 public static void main(String args[]) throws Exception {

		 br = new BufferedReader(new InputStreamReader(System.in)); 
		 bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		 
		// 1. 입출력 
		String s = br.readLine(); 
		
		// 2. 갯수 세기 
		int count[] = new int[26]; 
		for(int i = 0 ; i < s.length() ; i++) {
			char k = Character.toUpperCase(s.charAt(i)) ; 
			count[k-'A']++; 
		}
		
		// 테스트 
//		for(int i = 0 ; i < 26 ; i++) {
//			bw.write(count[i]+ " ");
//		}
		
		// 3. 가장 많이 사용된 갯수 구하기 (복사하고 정렬) 
		int copy[] = new int[26];  
		for(int i = 0 ; i < 26 ; i++) {
			copy[i] = count[i];  
		}
		Arrays.sort(copy);
		if(copy[25] == copy[24]) { bw.write("?"); bw.flush(); br.close(); bw.close(); return; }  
		int max = copy[25]; 
		
		// 테스트 
//		bw.write(max+"");
		
		
//		 4. 가장 많이 사용된 알파벳 구하기 , 출력 
		for(int i = 0 ; i < 26 ; i++) {
			if(max == count[i]) {
				System.out.printf("%c\n" , 'A'+i);
				return; 
			}		
		}
		
		
		 
		// 1157
		// 2941
		// 1316
		// 9996 
	 }	
}

	 


	 
	
	


