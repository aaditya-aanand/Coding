import java.util.*;
import java.lang.*;
import java.io.*;

class MMASS
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Parser in = new Parser(System.in);
		String str = in.next();
		int len = str.length();

		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i<len; i++)
		{
			char x = str.charAt(i);
			if(x == 'H') stack.push(1);
			else if(x == 'C') stack.push(12);
			else if(x == 'O') stack.push(16);
			else if(x == '(') stack.push(0);
			else if(x >= '2' && x <= '9') stack.push(stack.pop()*(x-'0'));

			else if(x == ')')
			{
				int sum = 0;
				while(stack.peek() != 0)
					sum += stack.pop();
				
				stack.pop();
				stack.push(sum);
			}
		}

		int sum = 0;
		while(!stack.isEmpty())
			sum += stack.pop();

		System.out.println(sum);
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
