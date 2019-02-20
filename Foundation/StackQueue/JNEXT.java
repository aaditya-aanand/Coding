import java.util.*;
import java.lang.*;
import java.io.*;

class JNEXT
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Parser in = new Parser(System.in);
		int T = in.nextInt();
		
	lab:for(int t = 0; t<T; t++)
		{
			int n = in.nextInt();
			int arr[] = new int[n];

			for(int i = 0; i<n; i++)
				arr[i] = in.nextInt();

			int last_elem = arr[n-1];

			int i = n-2;
			int pivot = -1;
			while(i >= 0)
			{
				if(arr[i] >= last_elem)
					last_elem = arr[i--];
				
				else
				{
					pivot = i;
					break;
				}
			}
			
			if(i == -1)
			{
				System.out.println(-1);
				continue lab;
			}

			int j = pivot+1;
			int second_pivot = -1;
			while(j <= n-1)
			{
				if(arr[j] <= arr[pivot])
				{
					second_pivot = j-1;
					break;
				}

				j++;
			}
            
            if(j == n)
                second_pivot = j-1;
                
			int temp = arr[pivot];
			arr[pivot] = arr[second_pivot];
			arr[second_pivot] = temp;

			int start = pivot+1;
			int end = n-1;
			while(start < end)
			{
				temp = arr[start];
				arr[start++] = arr[end];
				arr[end--] = temp;
			}
			
			StringBuilder ans = new StringBuilder();
			for(int k = 0; k<n; k++)
			    ans.append(arr[k]);

			System.out.println(ans);
				
		}
	}
}

class Parser
{
   final private int BUFFER_SIZE = 1 << 16;

   private DataInputStream din;
   private byte[] buffer;
   private int bufferPointer, bytesRead;

   public Parser(InputStream in)
   {
      din = new DataInputStream(in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
   }

   public long nextLong() throws Exception
   {
      long ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }
   
   //reads in the next string
   public String next() throws Exception
   {
      StringBuilder ret =  new StringBuilder();
      byte c = read();
      while (c <= ' ') c = read();
      do
      {
         ret = ret.append((char)c);
         c = read();
      } while (c > ' ');
      return ret.toString();
   }

   public int nextInt() throws Exception
   {
      int ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }
   
   private void fillBuffer() throws Exception
   {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) buffer[0] = -1;
   }

   private byte read() throws Exception
   {
      if (bufferPointer == bytesRead) fillBuffer();
      return buffer[bufferPointer++];
   }
}
