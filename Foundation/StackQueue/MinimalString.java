import java.util.*;
import java.lang.*;
import java.io.*;

class C797
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Parser in = new Parser(System.in);

		String str = in.next();
		int len = str.length();

      char min_arr[] = new char[len];
      min_arr[len-1] = str.charAt(len-1);

      for(int i = len-2; i>=0; i--)
         min_arr[i] = (str.charAt(i) > min_arr[i+1]) ? min_arr[i+1] : str.charAt(i);

		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder ans = new StringBuilder();

		for(int i = 0; i<len; i++)
		{
         stack.push(i);
         if(i == len-1)
            break;

         while(!stack.isEmpty())
         {
            if(min_arr[i+1] >= str.charAt(stack.peek()))
               ans.append(str.charAt(stack.pop()));

            else
               break;
         }
		}

      while(!stack.isEmpty())
         ans.append(str.charAt(stack.pop()));
			
		System.out.println(ans);
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
