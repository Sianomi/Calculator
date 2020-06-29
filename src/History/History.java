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

		// �ؽ�Ʈ ������ ��� ���ڿ� �ҷ��� 
		// ������ useDelimiter()����Ͽ� "\r\n" �������� split��(�� ���ڿ��� List����  ������ ��ҷ� �ޱ�����)
		while(scanner.hasNext()) {
			tokenHistory = scanner.next();
				
			historyList.add(tokenHistory);
			
			// historyList�ȿ� ���ڿ� 20�� �̻��̸� ���ڿ� ù�� ����(20�� �� ������)
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



