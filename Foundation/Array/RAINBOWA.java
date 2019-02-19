import java.util.*;
import java.lang.*;
import java.io.*;

class RAINBOWA
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
	lab:for(int t = 0; t<T; t++)
		{
		    int n = in.nextInt();
		    int arr[] = new int[n];
		    
		    for(int i = 0; i<n; i++)
		        arr[i] = in.nextInt();
		        
		    int prev_element = 0;
		    
		    int start = 0;
		    int end = n-1;
		    while(start <= end)
		    {
		        if(arr[start] == arr[end] && arr[start]-prev_element <= 1 && arr[start]-prev_element >= 0)
		        {
		            prev_element = arr[start];
		            start++;
		            end--;
		        }
		        
		        else
		        {
		            System.out.println("no");
		            continue lab;
		        }
		    }
		    
		    if(prev_element == 7)
		        System.out.println("yes");
		        
		    else
		        System.out.println("no");
		}
		
		in.close();
	}
}
