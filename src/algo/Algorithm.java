package algo;

public class Algorithm {
	public static double runAlgorithm(double x, double y, String op)
	{
		if(op.equals("eea"))
			return EEA((int)x,(int)y);
		
		return 0;
	}
	static double EEA(int x, int y)
	{
		int r0 = x, r1 = y, s0 = 0, s1 = 0, t0 = 0, t1 = 1;
		int temp, q;
		while(r1 != 0)
		{
		    q=r0/r1;
		    temp=r0;
		    r0=r1;
		    r1=temp-r1*q;
		    temp=s0;
		    s0=s1;
		    s1=temp-s1*q;
		    temp=t0;
		    t0=t1;
		    t1=temp-t1*q;
		}
		return (double)r0;
	}
	public static boolean isAlgorithm(String str,int index)
	{
		if(str.indexOf("eea",index)==index)
			return true;
		return false;
	}
	
	public static String[] getAlgorithmList()
	{
		String []list = {"EEA"};
		return list;
	}
}
