package main;

import java.util.Scanner;
//import java.io.File;

public class mainClass 
{
	
	Scanner sc = new Scanner(System.in);
	String value;
	void input()
	{
		System.out.println("원하는 번호를 입력해주세요.");
		System.out.println("1.계산  2.삭제 3.기록조회 0.종료");
		value = sc.nextLine();
	}
	
	void output(String text)
	{
		System.out.println(text);
	}
	
	public static void main(String[] args) 
	{
		mainClass mainObject = new mainClass();
		while(true)
		{
			mainObject.input();
			if(mainObject.value.equalsIgnoreCase("0")) break;
			
			mainObject.output(mainObject.value);
		}
	}
}
