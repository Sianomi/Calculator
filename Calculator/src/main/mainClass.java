package main;

import java.util.Scanner;
//import java.io.File;

public class mainClass 
{
	
	Scanner sc = new Scanner(System.in);
	String value;
	void input()
	{
		System.out.println("���ϴ� ��ȣ�� �Է����ּ���.");
		System.out.println("1.���  2.���� 3.�����ȸ 0.����");
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
