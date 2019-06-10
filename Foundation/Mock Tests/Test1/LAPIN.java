/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int t = 0; t<T; t++)
		{
		    String s = in.next();
		    int len = s.length();
		    
		    int end1 = -1 + len/2;
		    int start2 = (len%2 == 0) ? end1 + 1 : end1 + 2;
		    
		    int c1[] = new int[26];
		    int c2[] = new int[26];
		    
		    int i = 0;
		    while(i < len/2)
		        c1[s.charAt(i++) - 'a']++;
		        
		    i = start2;
		    while(i < len)
		        c2[s.charAt(i++) - 'a']++;
		    
		    boolean flag = true;
		    for(int j = 0; j<26; j++)
		    {
		        if(c1[j] != c2[j])
		        {
		            flag = false;
		            break;
		        }
		    }
		    
		    if(flag) System.out.println("YES");
		    else System.out.println("NO");
		}
		
		in.close();
	}
}
