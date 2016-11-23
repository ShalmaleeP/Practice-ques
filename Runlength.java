package AI;
import java.util.*;
public class Runlength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String op="";
		int i,n=0;
		char ch;
		String str;
		while(sc.hasNext())
		{
			//System.out.println(sc.hasNext());
			str=sc.nextLine();
			System.out.println("String is:"+str);
		for(i=0;i<str.length();)
		{
			n=0;
			if((str.charAt(i)>='0' && str.charAt(i)<='9')||(str.charAt(i)>='A' && str.charAt(i)<='Z')||(str.charAt(i)=='\\'))
			{
				if((str.charAt(i)=='\\')&&((str.charAt(i+1)>='0' && str.charAt(i+1)<='9')||(str.charAt(i+1)>='A' && str.charAt(i+1)<='F'))&&((str.charAt(i+2)>='0' && str.charAt(i+2)<='9')||(str.charAt(i+2)>='A' && str.charAt(i+2)<='Z')))
				{
					ch=str.charAt(i+1);
					if(ch>='0' && ch<='9')
						n=(int)(ch-46);
					if(ch>='A' && ch<='F')
						n=(int)(ch-53);
					while(n>0)
					{
						op=op+str.charAt(i+2);
						n--;
					}
					i=i+2;
				}
				else if((str.charAt(i)>='0' && str.charAt(i)<='9')||(str.charAt(i)>='A' && str.charAt(i)<='Z')){
					op=op+str.charAt(i);
					i++;
				}
				else
				{
					System.out.println("CORRUPT");
					break;
				}
				
			}
			else
			{
				System.out.println("CORRUPT");
				break;
			}
		}
		if(i==str.length())
		{
			System.out.println(op);
			op="";
		}

	}
	}

}
