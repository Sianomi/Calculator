package History;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class History {
	final String path = "C:\\result\\out.txt";

	public List<String> Read() throws IOException {
		
		String tokenHistory = "";
		Scanner scanner = new Scanner(new File(path)).useDelimiter("\r\n");
		List<String> historyList = new LinkedList<String>();

		// 텍스트 파일의 모든 문자열 불러옴 
		// 위에서 useDelimiter()사용하여 "\r\n" 기준으로 split함(각 문자열을 List안의  각각의 요소로 받기위해)
		while(scanner.hasNext()) {
			tokenHistory = scanner.next();
				
			historyList.add(tokenHistory);
			
			// historyList안에 문자열 20개 이상이면 문자열 첫줄 삭제(20개 될 때까지)
			while(historyList.size()>20) {
				historyList.remove(0);
			}
		}
		scanner.close();
		
		return historyList;
		
	}
	public void Reset() throws IOException {
		
		PrintWriter reset = new PrintWriter(path);
		reset.close();		
		
	}
	public void Write(String str) throws IOException
	{
		BufferedWriter bw = new BufferedWriter( new FileWriter( path , true) );
		PrintWriter pw = new PrintWriter(bw, true);
		
		pw.write(str+"\r\n");
		pw.flush();
		pw.close();
	}
}



