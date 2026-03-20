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
		int N = Integer.parseInt(br.readLine()); 
		String s = br.readLine(); 
		
		// 2. 별의 인덱스 구하기 
		int starIdx = 0;
		for(int i = 0 ; i < s.length() ; i++) {
			if(s.charAt(i) == '*') { starIdx = i; break; }  
		}
		
		// 테스트 
//		bw.write(starIdx+"");
		
		
		// 알고리즘 
		for(int i = 0 ; i < N ; i++) {
			
			String target = br.readLine(); 
			 
			// 3. 파일의 길이에 맞춰서 별을 붙이거나 삭제 
			StringBuilder sb = new StringBuilder(s);
			
			String frontStar = sb.substring(0, starIdx); 
			String backStar = sb.substring(starIdx+1, s.length()); 
			
			sb = new StringBuilder(frontStar); 
			
			if(s.length() <= target.length()) {
				int count = target.length() - s.length() + 1; 
				for(int j = 0 ; j < count ; j++) {
					sb.append('*'); 
				}
			}
			sb.append(backStar); 
			String after = sb.toString(); 
			
			// 테스트 
//			bw.write(after+"\n");
			
			// 4. 비교 및 출력 
			boolean isOk = true;
			if(after.length() != target.length()) isOk = false; 
			else {
				for(int j = 0 ; j < after.length() ; j++) {
					if(after.charAt(j) != '*' && after.charAt(j) != target.charAt(j)) {
						isOk = false; 
						break;
					}
				}
			}
			if(isOk) bw.write("DA\n");
			else bw.write("NE\n");
			
		}
		
		
		
		
		

			
			
			
			
			
			
			
			
		
	
		bw.flush();
		bw.close();
		br.close();
		
		
		// 1157
		// 2941
		// 1316
		// 9996 
		
	 
	 }	
}

	 


	 
	
	


